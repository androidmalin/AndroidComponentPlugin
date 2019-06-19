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

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Base class for common functionality between various dex-based
 * {@link ClassLoader} implementations.
 */
public class BaseDexClassLoader extends ClassLoader {

    /**
     * Hook for customizing how dex files loads are reported.
     *
     * This enables the framework to monitor the use of dex files. The
     * goal is to simplify the mechanism for optimizing foreign dex files and
     * enable further optimizations of secondary dex files.
     *
     * The reporting happens only when new instances of BaseDexClassLoader
     * are constructed and will be active only after this field is set with
     * {@link BaseDexClassLoader#setReporter}.
     */
    /* @NonNull */ private static volatile Reporter reporter = null;

    private final DexPathList pathList;

    /**
     * Constructs an instance.
     * Note that all the *.jar and *.apk files from {@code dexPath} might be
     * first extracted in-memory before the code is loaded. This can be avoided
     * by passing raw dex files (*.dex) in the {@code dexPath}.
     *
     * @param dexPath the list of jar/apk files containing classes and
     * resources, delimited by {@code File.pathSeparator}, which
     * defaults to {@code ":"} on Android.
     * @param optimizedDirectory this parameter is deprecated and has no effect
     * @param librarySearchPath the list of directories containing native
     * libraries, delimited by {@code File.pathSeparator}; may be
     * {@code null}
     * @param parent the parent class loader
     */
    public BaseDexClassLoader(String dexPath, File optimizedDirectory,
            String librarySearchPath, ClassLoader parent) {
        super(parent);
        this.pathList = new DexPathList(this, dexPath, librarySearchPath, null);

        if (reporter != null) {
            reporter.report(this.pathList.getDexPaths());
        }
    }

    /**
     * Constructs an instance.
     *
     * dexFile must be an in-memory representation of a full dexFile.
     *
     * @param dexFiles the array of in-memory dex files containing classes.
     * @param parent the parent class loader
     *
     * @hide
     */
    public BaseDexClassLoader(ByteBuffer[] dexFiles, ClassLoader parent) {
        // TODO We should support giving this a library search path maybe.
        super(parent);
        this.pathList = new DexPathList(this, dexFiles);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        List<Throwable> suppressedExceptions = new ArrayList<Throwable>();
        Class c = pathList.findClass(name, suppressedExceptions);
        if (c == null) {
            ClassNotFoundException cnfe = new ClassNotFoundException(
                    "Didn't find class \"" + name + "\" on path: " + pathList);
            for (Throwable t : suppressedExceptions) {
                cnfe.addSuppressed(t);
            }
            throw cnfe;
        }
        return c;
    }

    /**
     * @hide
     */
    public void addDexPath(String dexPath) {
        pathList.addDexPath(dexPath, null /*optimizedDirectory*/);
    }

    @Override
    protected URL findResource(String name) {
        return pathList.findResource(name);
    }

    @Override
    protected Enumeration<URL> findResources(String name) {
        return pathList.findResources(name);
    }

    @Override
    public String findLibrary(String name) {
        return pathList.findLibrary(name);
    }

    /**
     * Returns package information for the given package.
     * Unfortunately, instances of this class don't really have this
     * information, and as a non-secure {@code ClassLoader}, it isn't
     * even required to, according to the spec. Yet, we want to
     * provide it, in order to make all those hopeful callers of
     * {@code myClass.getPackage().getName()} happy. Thus we construct
     * a {@code Package} object the first time it is being requested
     * and fill most of the fields with dummy values. The {@code
     * Package} object is then put into the {@code ClassLoader}'s
     * package cache, so we see the same one next time. We don't
     * create {@code Package} objects for {@code null} arguments or
     * for the default package.
     *
     * <p>There is a limited chance that we end up with multiple
     * {@code Package} objects representing the same package: It can
     * happen when when a package is scattered across different JAR
     * files which were loaded by different {@code ClassLoader}
     * instances. This is rather unlikely, and given that this whole
     * thing is more or less a workaround, probably not worth the
     * effort to address.
     *
     * @param name the name of the class
     * @return the package information for the class, or {@code null}
     * if there is no package information available for it
     */
    @Override
    protected synchronized Package getPackage(String name) {
        if (name != null && !name.isEmpty()) {
            Package pack = super.getPackage(name);

            if (pack == null) {
                pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        "Unknown", "0.0", "Unknown", null);
            }

            return pack;
        }

        return null;
    }

    /**
     * @hide
     */
    public String getLdLibraryPath() {
        StringBuilder result = new StringBuilder();
        for (File directory : pathList.getNativeLibraryDirectories()) {
            if (result.length() > 0) {
                result.append(':');
            }
            result.append(directory);
        }

        return result.toString();
    }

    @Override public String toString() {
        return getClass().getName() + "[" + pathList + "]";
    }

    /**
     * Sets the reporter for dex load notifications.
     * Once set, all new instances of BaseDexClassLoader will report upon
     * constructions the loaded dex files.
     *
     * @param newReporter the new Reporter. Setting null will cancel reporting.
     * @hide
     */
    public static void setReporter(Reporter newReporter) {
        reporter = newReporter;
    }

    /**
     * @hide
     */
    public static Reporter getReporter() {
        return reporter;
    }

    /**
     * @hide
     */
    public interface Reporter {
        public void report(List<String> dexPaths);
    }
}
