/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dalvik.system;

import android.system.ErrnoException;
import android.system.StructStat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import libcore.io.Libcore;

/**
 * Manipulates DEX files. The class is similar in principle to
 * {@link java.util.zip.ZipFile}. It is used primarily by class loaders.
 * <p>
 * Note we don't directly open and read the DEX file here. They're memory-mapped
 * read-only by the VM.
 */
public final class DexFile {
  /**
   * If close is called, mCookie becomes null but the internal cookie is preserved if the close
   * failed so that we can free resources in the finalizer.
   */
    private Object mCookie;
    private Object mInternalCookie;
    private final String mFileName;
    private final CloseGuard guard = CloseGuard.get();

    /**
     * Opens a DEX file from a given File object. This will usually be a ZIP/JAR
     * file with a "classes.dex" inside.
     *
     * The VM will generate the name of the corresponding file in
     * /data/dalvik-cache and open it, possibly creating or updating
     * it first if system permissions allow.  Don't pass in the name of
     * a file in /data/dalvik-cache, as the named file is expected to be
     * in its original (pre-dexopt) state.
     *
     * @param file
     *            the File object referencing the actual DEX file
     *
     * @throws IOException
     *             if an I/O error occurs, such as the file not being found or
     *             access rights missing for opening it
     */
    public DexFile(File file) throws IOException {
        this(file.getPath());
    }
    /*
     * Private version with class loader argument.
     *
     * @param file
     *            the File object referencing the actual DEX file
     * @param loader
     *            the class loader object creating the DEX file object
     * @param elements
     *            the temporary dex path list elements from DexPathList.makeElements
     */
    DexFile(File file, ClassLoader loader, DexPathList.Element[] elements)
            throws IOException {
        this(file.getPath(), loader, elements);
    }

    /**
     * Opens a DEX file from a given filename. This will usually be a ZIP/JAR
     * file with a "classes.dex" inside.
     *
     * The VM will generate the name of the corresponding file in
     * /data/dalvik-cache and open it, possibly creating or updating
     * it first if system permissions allow.  Don't pass in the name of
     * a file in /data/dalvik-cache, as the named file is expected to be
     * in its original (pre-dexopt) state.
     *
     * @param fileName
     *            the filename of the DEX file
     *
     * @throws IOException
     *             if an I/O error occurs, such as the file not being found or
     *             access rights missing for opening it
     */
    public DexFile(String fileName) throws IOException {
        this(fileName, null, null);
    }

    /*
     * Private version with class loader argument.
     *
     * @param fileName
     *            the filename of the DEX file
     * @param loader
     *            the class loader creating the DEX file object
     * @param elements
     *            the temporary dex path list elements from DexPathList.makeElements
     */
    DexFile(String fileName, ClassLoader loader, DexPathList.Element[] elements) throws IOException {
        mCookie = openDexFile(fileName, null, 0, loader, elements);
        mInternalCookie = mCookie;
        mFileName = fileName;
        guard.open("close");
        //System.out.println("DEX FILE cookie is " + mCookie + " fileName=" + fileName);
    }

    /**
     * Opens a DEX file from a given filename, using a specified file
     * to hold the optimized data.
     *
     * @param sourceName
     *  Jar or APK file with "classes.dex".
     * @param outputName
     *  File that will hold the optimized form of the DEX data.
     * @param flags
     *  Enable optional features.
     * @param loader
     *  The class loader creating the DEX file object.
     * @param elements
     *  The temporary dex path list elements from DexPathList.makeElements
     */
    private DexFile(String sourceName, String outputName, int flags, ClassLoader loader,
            DexPathList.Element[] elements) throws IOException {
        if (outputName != null) {
            try {
                String parent = new File(outputName).getParent();
                if (Libcore.os.getuid() != Libcore.os.stat(parent).st_uid) {
                    throw new IllegalArgumentException("Optimized data directory " + parent
                            + " is not owned by the current user. Shared storage cannot protect"
                            + " your application from code injection attacks.");
                }
            } catch (ErrnoException ignored) {
                // assume we'll fail with a more contextual error later
            }
        }

        mCookie = openDexFile(sourceName, outputName, flags, loader, elements);
        mFileName = sourceName;
        //System.out.println("DEX FILE cookie is " + mCookie + " sourceName=" + sourceName + " outputName=" + outputName);
    }

    /**
     * Open a DEX file, specifying the file in which the optimized DEX
     * data should be written.  If the optimized form exists and appears
     * to be current, it will be used; if not, the VM will attempt to
     * regenerate it.
     *
     * This is intended for use by applications that wish to download
     * and execute DEX files outside the usual application installation
     * mechanism.  This function should not be called directly by an
     * application; instead, use a class loader such as
     * dalvik.system.DexClassLoader.
     *
     * @param sourcePathName
     *  Jar or APK file with "classes.dex".  (May expand this to include
     *  "raw DEX" in the future.)
     * @param outputPathName
     *  File that will hold the optimized form of the DEX data.
     * @param flags
     *  Enable optional features.  (Currently none defined.)
     * @return
     *  A new or previously-opened DexFile.
     * @throws IOException
     *  If unable to open the source or output file.
     */
    static public DexFile loadDex(String sourcePathName, String outputPathName,
        int flags) throws IOException {

        /*
         * TODO: we may want to cache previously-opened DexFile objects.
         * The cache would be synchronized with close().  This would help
         * us avoid mapping the same DEX more than once when an app
         * decided to open it multiple times.  In practice this may not
         * be a real issue.
         */
        return loadDex(sourcePathName, outputPathName, flags, null, null);
    }

    /*
     * Private version of loadDex that also takes a class loader.
     *
     * @param sourcePathName
     *  Jar or APK file with "classes.dex".  (May expand this to include
     *  "raw DEX" in the future.)
     * @param outputPathName
     *  File that will hold the optimized form of the DEX data.
     * @param flags
     *  Enable optional features.  (Currently none defined.)
     * @param loader
     *  Class loader that is aloading the DEX file.
     * @param elements
     *  The temporary dex path list elements from DexPathList.makeElements
     * @return
     *  A new or previously-opened DexFile.
     * @throws IOException
     *  If unable to open the source or output file.
     */
    static DexFile loadDex(String sourcePathName, String outputPathName,
        int flags, ClassLoader loader, DexPathList.Element[] elements) throws IOException {

        /*
         * TODO: we may want to cache previously-opened DexFile objects.
         * The cache would be synchronized with close().  This would help
         * us avoid mapping the same DEX more than once when an app
         * decided to open it multiple times.  In practice this may not
         * be a real issue.
         */
        return new DexFile(sourcePathName, outputPathName, flags, loader, elements);
    }

    /**
     * Gets the name of the (already opened) DEX file.
     *
     * @return the file name
     */
    public String getName() {
        return mFileName;
    }

    @Override public String toString() {
        return getName();
    }

    /**
     * Closes the DEX file.
     * <p>
     * This may not be able to release all of the resources. If classes from this DEX file are
     * still resident, the DEX file can't be unmapped. In the case where we do not release all
     * the resources, close is called again in the finalizer.
     *
     * @throws IOException
     *             if an I/O error occurs during closing the file, which
     *             normally should not happen
     */
    public void close() throws IOException {
        if (mInternalCookie != null) {
            if (closeDexFile(mInternalCookie)) {
                mInternalCookie = null;
            }
            guard.close();
            mCookie = null;
        }
    }

    /**
     * Loads a class. Returns the class on success, or a {@code null} reference
     * on failure.
     * <p>
     * If you are not calling this from a class loader, this is most likely not
     * going to do what you want. Use {@link Class#forName(String)} instead.
     * <p>
     * The method does not throw {@link ClassNotFoundException} if the class
     * isn't found because it isn't reasonable to throw exceptions wildly every
     * time a class is not found in the first DEX file we look at.
     *
     * @param name
     *            the class name, which should look like "java/lang/String"
     *
     * @param loader
     *            the class loader that tries to load the class (in most cases
     *            the caller of the method
     *
     * @return the {@link Class} object representing the class, or {@code null}
     *         if the class cannot be loaded
     */
    public Class loadClass(String name, ClassLoader loader) {
        String slashName = name.replace('.', '/');
        return loadClassBinaryName(slashName, loader, null);
    }

    /**
     * See {@link #loadClass(String, ClassLoader)}.
     *
     * This takes a "binary" class name to better match ClassLoader semantics.
     *
     * @hide
     */
    public Class loadClassBinaryName(String name, ClassLoader loader, List<Throwable> suppressed) {
        return defineClass(name, loader, mCookie, this, suppressed);
    }

    private static Class defineClass(String name, ClassLoader loader, Object cookie,
                                     DexFile dexFile, List<Throwable> suppressed) {
        Class result = null;
        try {
            result = defineClassNative(name, loader, cookie, dexFile);
        } catch (NoClassDefFoundError e) {
            if (suppressed != null) {
                suppressed.add(e);
            }
        } catch (ClassNotFoundException e) {
            if (suppressed != null) {
                suppressed.add(e);
            }
        }
        return result;
    }

    /**
     * Enumerate the names of the classes in this DEX file.
     *
     * @return an enumeration of names of classes contained in the DEX file, in
     *         the usual internal form (like "java/lang/String").
     */
    public Enumeration<String> entries() {
        return new DFEnum(this);
    }

    /*
     * Helper class.
     */
    private class DFEnum implements Enumeration<String> {
        private int mIndex;
        private String[] mNameList;

        DFEnum(DexFile df) {
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
        }

        public boolean hasMoreElements() {
            return (mIndex < mNameList.length);
        }

        public String nextElement() {
            return mNameList[mIndex++];
        }
    }

    /**
     * Called when the class is finalized. Makes sure the DEX file is closed.
     *
     * @throws IOException
     *             if an I/O error occurs during closing the file, which
     *             normally should not happen
     */
    @Override protected void finalize() throws Throwable {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            if (mInternalCookie != null && !closeDexFile(mInternalCookie)) {
                throw new AssertionError("Failed to close dex file in finalizer.");
            }
            mInternalCookie = null;
            mCookie = null;
        } finally {
            super.finalize();
        }
    }


    /*
     * Open a DEX file.  The value returned is a magic VM cookie.  On
     * failure, an IOException is thrown.
     */
    private static Object openDexFile(String sourceName, String outputName, int flags,
            ClassLoader loader, DexPathList.Element[] elements) throws IOException {
        // Use absolute paths to enable the use of relative paths when testing on host.
        return openDexFileNative(new File(sourceName).getAbsolutePath(),
                                 (outputName == null)
                                     ? null
                                     : new File(outputName).getAbsolutePath(),
                                 flags,
                                 loader,
                                 elements);
    }

    /*
     * Returns true if the dex file is backed by a valid oat file.
     */
    /*package*/ boolean isBackedByOatFile() {
        return isBackedByOatFile(mCookie);
    }

    /*
     * Returns true if we managed to close the dex file.
     */
    private static native boolean closeDexFile(Object cookie);
    private static native Class defineClassNative(String name, ClassLoader loader, Object cookie,
                                                  DexFile dexFile)
            throws ClassNotFoundException, NoClassDefFoundError;
    private static native String[] getClassNameList(Object cookie);
    private static native boolean isBackedByOatFile(Object cookie);
    /*
     * Open a DEX file.  The value returned is a magic VM cookie.  On
     * failure, an IOException is thrown.
     */
    private static native Object openDexFileNative(String sourceName, String outputName, int flags,
            ClassLoader loader, DexPathList.Element[] elements);

    /**
     * Returns true if the VM believes that the apk/jar file is out of date
     * and should be passed through "dexopt" again.
     *
     * @param fileName the absolute path to the apk/jar file to examine.
     * @return true if dexopt should be called on the file, false otherwise.
     * @throws java.io.FileNotFoundException if fileName is not readable,
     *         not a file, or not present.
     * @throws java.io.IOException if fileName is not a valid apk/jar file or
     *         if problems occur while parsing it.
     * @throws java.lang.NullPointerException if fileName is null.
     */
    public static native boolean isDexOptNeeded(String fileName)
            throws FileNotFoundException, IOException;

    /**
     * See {@link #getDexOptNeeded(String, String, int)}.
     *
     * @hide
     */
    public static final int NO_DEXOPT_NEEDED = 0;

    /**
     * See {@link #getDexOptNeeded(String, String, int)}.
     *
     * @hide
     */
    public static final int DEX2OAT_NEEDED = 1;

    /**
     * See {@link #getDexOptNeeded(String, String, int)}.
     *
     * @hide
     */
    public static final int PATCHOAT_NEEDED = 2;

    /**
     * See {@link #getDexOptNeeded(String, String, int)}.
     *
     * @hide
     */
    public static final int SELF_PATCHOAT_NEEDED = 3;

    /**
     * Returns whether the given filter is a valid filter.
     *
     * @hide
     */
    public native static boolean isValidCompilerFilter(String filter);

    /**
     * Returns whether the given filter is based on profiles.
     *
     * @hide
     */
    public native static boolean isProfileGuidedCompilerFilter(String filter);

    /**
     * Returns the version of the compiler filter that is not based on profiles.
     * If the input is not a valid filter, or the filter is already not based on
     * profiles, this returns the input.
     *
     * @hide
     */
    public native static String getNonProfileGuidedCompilerFilter(String filter);

    /**
     * Returns the VM's opinion of what kind of dexopt is needed to make the
     * apk/jar file up to date, where {@code targetMode} is used to indicate what
     * type of compilation the caller considers up-to-date, and {@code newProfile}
     * is used to indicate whether profile information has changed recently.
     *
     * @param fileName the absolute path to the apk/jar file to examine.
     * @param compilerFilter a compiler filter to use for what a caller considers up-to-date.
     * @param newProfile flag that describes whether a profile corresponding
     *        to the dex file has been recently updated and should be considered
     *        in the state of the file.
     * @return NO_DEXOPT_NEEDED if the apk/jar is already up to date.
     *         DEX2OAT_NEEDED if dex2oat should be called on the apk/jar file.
     *         PATCHOAT_NEEDED if patchoat should be called on the apk/jar
     *         file to patch the odex file along side the apk/jar.
     *         SELF_PATCHOAT_NEEDED if selfpatchoat should be called on the
     *         apk/jar file to patch the oat file in the dalvik cache.
     * @throws java.io.FileNotFoundException if fileName is not readable,
     *         not a file, or not present.
     * @throws java.io.IOException if fileName is not a valid apk/jar file or
     *         if problems occur while parsing it.
     * @throws java.lang.NullPointerException if fileName is null.
     *
     * @hide
     */
    public static native int getDexOptNeeded(String fileName,
            String instructionSet, String compilerFilter, boolean newProfile)
            throws FileNotFoundException, IOException;

    /**
     * Returns the status of the dex file {@code fileName}. The returned string is
     * an opaque, human readable representation of the current status. The output
     * is only meant for debugging and is not guaranteed to be stable across
     * releases and/or devices.
     *
     * @hide
     */
    public static native String getDexFileStatus(String fileName, String instructionSet)
        throws FileNotFoundException;
}
