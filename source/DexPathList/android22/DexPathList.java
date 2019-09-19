/*
 * Copyright (C) 2011 The Android Open Source Project
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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipFile;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import static android.system.OsConstants.*;

/**
 * A pair of lists of entries, associated with a {@code ClassLoader}.
 * One of the lists is a dex/resource path &mdash; typically referred
 * to as a "class path" &mdash; list, and the other names directories
 * containing native code libraries. Class path entries may be any of:
 * a {@code .jar} or {@code .zip} file containing an optional
 * top-level {@code classes.dex} file as well as arbitrary resources,
 * or a plain {@code .dex} file (with no possibility of associated
 * resources).
 *
 * <p>This class also contains methods to use these lists to look up
 * classes and resources.</p>
 */
/*package*/ final class DexPathList {
    private static final String DEX_SUFFIX = ".dex";

    /** class definition context */
    private final ClassLoader definingContext;

    /**
     * List of dex/resource (class path) elements.
     * Should be called pathElements, but the Facebook app uses reflection
     * to modify 'dexElements' (http://b/7726934).
     */
    private final Element[] dexElements;

    /** List of native library directories. */
    private final File[] nativeLibraryDirectories;

    /**
     * Exceptions thrown during creation of the dexElements list.
     */
    private final IOException[] dexElementsSuppressedExceptions;

    /**
     * Constructs an instance.
     *
     * @param definingContext the context in which any as-yet unresolved
     * classes should be defined
     * @param dexPath list of dex/resource path elements, separated by
     * {@code File.pathSeparator}
     * @param libraryPath list of native library directory path elements,
     * separated by {@code File.pathSeparator}
     * @param optimizedDirectory directory where optimized {@code .dex} files
     * should be found and written to, or {@code null} to use the default
     * system directory for same
     */
    public DexPathList(ClassLoader definingContext, String dexPath,
            String libraryPath, File optimizedDirectory) {
        if (definingContext == null) {
            throw new NullPointerException("definingContext == null");
        }

        if (dexPath == null) {
            throw new NullPointerException("dexPath == null");
        }

        if (optimizedDirectory != null) {
            if (!optimizedDirectory.exists())  {
                throw new IllegalArgumentException(
                        "optimizedDirectory doesn't exist: "
                        + optimizedDirectory);
            }

            if (!(optimizedDirectory.canRead()
                            && optimizedDirectory.canWrite())) {
                throw new IllegalArgumentException(
                        "optimizedDirectory not readable/writable: "
                        + optimizedDirectory);
            }
        }

        this.definingContext = definingContext;
        ArrayList<IOException> suppressedExceptions = new ArrayList<IOException>();
        this.dexElements = makeDexElements(splitDexPath(dexPath), optimizedDirectory,
                                           suppressedExceptions);
        if (suppressedExceptions.size() > 0) {
            this.dexElementsSuppressedExceptions =
                suppressedExceptions.toArray(new IOException[suppressedExceptions.size()]);
        } else {
            dexElementsSuppressedExceptions = null;
        }
        this.nativeLibraryDirectories = splitLibraryPath(libraryPath);
    }

    @Override public String toString() {
        return "DexPathList[" + Arrays.toString(dexElements) +
            ",nativeLibraryDirectories=" + Arrays.toString(nativeLibraryDirectories) + "]";
    }

    /**
     * For BaseDexClassLoader.getLdLibraryPath.
     */
    public File[] getNativeLibraryDirectories() {
        return nativeLibraryDirectories;
    }

    /**
     * Splits the given dex path string into elements using the path
     * separator, pruning out any elements that do not refer to existing
     * and readable files. (That is, directories are not included in the
     * result.)
     */
    private static ArrayList<File> splitDexPath(String path) {
        return splitPaths(path, null, false);
    }

    /**
     * Splits the given library directory path string into elements
     * using the path separator ({@code File.pathSeparator}, which
     * defaults to {@code ":"} on Android, appending on the elements
     * from the system library path, and pruning out any elements that
     * do not refer to existing and readable directories.
     */
    private static File[] splitLibraryPath(String path) {
        // Native libraries may exist in both the system and
        // application library paths, and we use this search order:
        //
        //   1. this class loader's library path for application libraries
        //   2. the VM's library path from the system property for system libraries
        //
        // This order was reversed prior to Gingerbread; see http://b/2933456.
        ArrayList<File> result = splitPaths(path, System.getProperty("java.library.path"), true);
        return result.toArray(new File[result.size()]);
    }

    /**
     * Splits the given path strings into file elements using the path
     * separator, combining the results and filtering out elements
     * that don't exist, aren't readable, or aren't either a regular
     * file or a directory (as specified). Either string may be empty
     * or {@code null}, in which case it is ignored. If both strings
     * are empty or {@code null}, or all elements get pruned out, then
     * this returns a zero-element list.
     */
    private static ArrayList<File> splitPaths(String path1, String path2,
            boolean wantDirectories) {
        ArrayList<File> result = new ArrayList<File>();

        splitAndAdd(path1, wantDirectories, result);
        splitAndAdd(path2, wantDirectories, result);
        return result;
    }

    /**
     * Helper for {@link #splitPaths}, which does the actual splitting
     * and filtering and adding to a result.
     */
    private static void splitAndAdd(String searchPath, boolean directoriesOnly,
            ArrayList<File> resultList) {
        if (searchPath == null) {
            return;
        }
        for (String path : searchPath.split(":")) {
            try {
                StructStat sb = Libcore.os.stat(path);
                if (!directoriesOnly || S_ISDIR(sb.st_mode)) {
                    resultList.add(new File(path));
                }
            } catch (ErrnoException ignored) {
            }
        }
    }

    /**
     * Makes an array of dex/resource path elements, one per element of
     * the given array.
     */
    private static Element[] makeDexElements(ArrayList<File> files, File optimizedDirectory,
                                             ArrayList<IOException> suppressedExceptions) {
        ArrayList<Element> elements = new ArrayList<Element>();
        /*
         * Open all files and load the (direct or contained) dex files
         * up front.
         */
        for (File file : files) {
            File zip = null;
            DexFile dex = null;
            String name = file.getName();

            if (file.isDirectory()) {
                // We support directories for looking up resources.
                // This is only useful for running libcore tests.
                elements.add(new Element(file, true, null, null));
            } else if (file.isFile()){
                if (name.endsWith(DEX_SUFFIX)) {
                    // Raw dex file (not inside a zip/jar).
                    try {
                        dex = loadDexFile(file, optimizedDirectory);
                    } catch (IOException ex) {
                        System.logE("Unable to load dex file: " + file, ex);
                    }
                } else {
                    zip = file;

                    try {
                        dex = loadDexFile(file, optimizedDirectory);
                    } catch (IOException suppressed) {
                        /*
                         * IOException might get thrown "legitimately" by the DexFile constructor if
                         * the zip file turns out to be resource-only (that is, no classes.dex file
                         * in it).
                         * Let dex == null and hang on to the exception to add to the tea-leaves for
                         * when findClass returns null.
                         */
                        suppressedExceptions.add(suppressed);
                    }
                }
            } else {
                System.logW("ClassLoader referenced unknown path: " + file);
            }

            if ((zip != null) || (dex != null)) {
                elements.add(new Element(file, false, zip, dex));
            }
        }

        return elements.toArray(new Element[elements.size()]);
    }

    /**
     * Constructs a {@code DexFile} instance, as appropriate depending
     * on whether {@code optimizedDirectory} is {@code null}.
     */
    private static DexFile loadDexFile(File file, File optimizedDirectory)
            throws IOException {
        if (optimizedDirectory == null) {
            return new DexFile(file);
        } else {
            String optimizedPath = optimizedPathFor(file, optimizedDirectory);
            return DexFile.loadDex(file.getPath(), optimizedPath, 0);
        }
    }

    /**
     * Converts a dex/jar file path and an output directory to an
     * output file path for an associated optimized dex file.
     */
    private static String optimizedPathFor(File path,
            File optimizedDirectory) {
        /*
         * Get the filename component of the path, and replace the
         * suffix with ".dex" if that's not already the suffix.
         *
         * We don't want to use ".odex", because the build system uses
         * that for files that are paired with resource-only jar
         * files. If the VM can assume that there's no classes.dex in
         * the matching jar, it doesn't need to open the jar to check
         * for updated dependencies, providing a slight performance
         * boost at startup. The use of ".dex" here matches the use on
         * files in /data/dalvik-cache.
         */
        String fileName = path.getName();
        if (!fileName.endsWith(DEX_SUFFIX)) {
            int lastDot = fileName.lastIndexOf(".");
            if (lastDot < 0) {
                fileName += DEX_SUFFIX;
            } else {
                StringBuilder sb = new StringBuilder(lastDot + 4);
                sb.append(fileName, 0, lastDot);
                sb.append(DEX_SUFFIX);
                fileName = sb.toString();
            }
        }

        File result = new File(optimizedDirectory, fileName);
        return result.getPath();
    }

    /**
     * Finds the named class in one of the dex files pointed at by
     * this instance. This will find the one in the earliest listed
     * path element. If the class is found but has not yet been
     * defined, then this method will define it in the defining
     * context that this instance was constructed with.
     *
     * @param name of class to find
     * @param suppressed exceptions encountered whilst finding the class
     * @return the named class or {@code null} if the class is not
     * found in any of the dex files
     */
    public Class findClass(String name, List<Throwable> suppressed) {
        for (Element element : dexElements) {
            DexFile dex = element.dexFile;

            if (dex != null) {
                Class clazz = dex.loadClassBinaryName(name, definingContext, suppressed);
                if (clazz != null) {
                    return clazz;
                }
            }
        }
        if (dexElementsSuppressedExceptions != null) {
            suppressed.addAll(Arrays.asList(dexElementsSuppressedExceptions));
        }
        return null;
    }

    /**
     * Finds the named resource in one of the zip/jar files pointed at
     * by this instance. This will find the one in the earliest listed
     * path element.
     *
     * @return a URL to the named resource or {@code null} if the
     * resource is not found in any of the zip/jar files
     */
    public URL findResource(String name) {
        for (Element element : dexElements) {
            URL url = element.findResource(name);
            if (url != null) {
                return url;
            }
        }

        return null;
    }

    /**
     * Finds all the resources with the given name, returning an
     * enumeration of them. If there are no resources with the given
     * name, then this method returns an empty enumeration.
     */
    public Enumeration<URL> findResources(String name) {
        ArrayList<URL> result = new ArrayList<URL>();

        for (Element element : dexElements) {
            URL url = element.findResource(name);
            if (url != null) {
                result.add(url);
            }
        }

        return Collections.enumeration(result);
    }

    /**
     * Finds the named native code library on any of the library
     * directories pointed at by this instance. This will find the
     * one in the earliest listed directory, ignoring any that are not
     * readable regular files.
     *
     * @return the complete path to the library or {@code null} if no
     * library was found
     */
    public String findLibrary(String libraryName) {
        String fileName = System.mapLibraryName(libraryName);
        for (File directory : nativeLibraryDirectories) {
            String path = new File(directory, fileName).getPath();
            if (IoUtils.canOpenReadOnly(path)) {
                return path;
            }
        }
        return null;
    }

    /**
     * Element of the dex/resource file path
     */
    /*package*/ static class Element {
        private final File file;
        private final boolean isDirectory;
        private final File zip;
        private final DexFile dexFile;

        private ZipFile zipFile;
        private boolean initialized;

        public Element(File file, boolean isDirectory, File zip, DexFile dexFile) {
            this.file = file;
            this.isDirectory = isDirectory;
            this.zip = zip;
            this.dexFile = dexFile;
        }

        @Override public String toString() {
            if (isDirectory) {
                return "directory \"" + file + "\"";
            } else if (zip != null) {
                return "zip file \"" + zip + "\"";
            } else {
                return "dex file \"" + dexFile + "\"";
            }
        }

        public synchronized void maybeInit() {
            if (initialized) {
                return;
            }

            initialized = true;

            if (isDirectory || zip == null) {
                return;
            }

            try {
                zipFile = new ZipFile(zip);
            } catch (IOException ioe) {
                /*
                 * Note: ZipException (a subclass of IOException)
                 * might get thrown by the ZipFile constructor
                 * (e.g. if the file isn't actually a zip/jar
                 * file).
                 */
                System.logE("Unable to open zip file: " + file, ioe);
                zipFile = null;
            }
        }

        public URL findResource(String name) {
            maybeInit();

            // We support directories so we can run tests and/or legacy code
            // that uses Class.getResource.
            if (isDirectory) {
                File resourceFile = new File(file, name);
                if (resourceFile.exists()) {
                    try {
                        return resourceFile.toURI().toURL();
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            if (zipFile == null || zipFile.getEntry(name) == null) {
                /*
                 * Either this element has no zip/jar file (first
                 * clause), or the zip/jar file doesn't have an entry
                 * for the given name (second clause).
                 */
                return null;
            }

            try {
                /*
                 * File.toURL() is compliant with RFC 1738 in
                 * always creating absolute path names. If we
                 * construct the URL by concatenating strings, we
                 * might end up with illegal URLs for relative
                 * names.
                 */
                return new URL("jar:" + file.toURL() + "!/" + name);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
