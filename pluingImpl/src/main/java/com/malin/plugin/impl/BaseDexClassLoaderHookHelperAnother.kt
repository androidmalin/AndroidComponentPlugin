package com.malin.plugin.impl

import android.content.Context
import android.os.Build
import dalvik.system.PathClassLoader
import java.io.File
import java.io.IOException

/**
 * 由于应用程序使用的ClassLoader为PathClassLoader 最终继承自 BaseDexClassLoader
 * 查看源码得知,这个BaseDexClassLoader加载代码根据一个叫做dexElements的数组进行,
 * 因此我们把包含代码的dex文件插入这个数组. 系统的classLoader就能帮助我们找到这个类
 *
 *
 * 把插件的相关信息放入BaseDexClassLoader的表示dex文件的数组里面,
 * 这样宿主程序的ClassLoader在进行类加载,遍历这个数组的时候,
 * 会自动遍历到我们添加进去的插件信息,从而完成插件类的加载！
 *
 *
 * 这个类用来进行对于BaseDexClassLoader的Hook
 * 使用makePathElements()或者makeDexElements()方法生成插件的Element[]
 */
object BaseDexClassLoaderHookHelperAnother {

    /**
     * 使用宿主ClassLoader帮助加载插件类
     *
     * @param baseDexClassLoader 表示宿主的LoadedApk在Application类中有一个成员变量mLoadedApk,而这个变量是从ContextImpl中获取的;
     * ContextImpl重写了getClassLoader方法,
     * 因此我们在Context环境中直接getClassLoader()获取到的就是宿主程序唯一的ClassLoader.
     * @param apkFile            apkFile
     */
    fun patchClassLoader(baseDexClassLoader: ClassLoader, context: Context, apkFile: File) {

        // -->PathClassLoader
        // -->BaseDexClassLoader
        // -->BaseDexClassLoader中DexPathList pathList
        // -->DexPathList中 Element[] dexElements
        try {
            // 0.获取PathClassLoader的父类dalvik.system.BaseDexClassLoader的Class对象
            val baseDexClassLoaderClazz = PathClassLoader::class.java.superclass

            // 1.获取BaseDexClassLoader的成员DexPathList pathList
            // private final DexPathList pathList;
            // http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/BaseDexClassLoader.java
            val pathListField = baseDexClassLoaderClazz.getDeclaredField("pathList")
                .also { it.isAccessible = true }

            // 2.获取DexPathList pathList实例;
            val dexPathList = pathListField[baseDexClassLoader]

            // 3.获取DexPathList的成员: Element[] dexElements 的Field
            // private Element[] dexElements;
            // http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/DexPathList.java
            val dexElementsField = dexPathList.javaClass.getDeclaredField("dexElements")
                .also { it.isAccessible = true }

            // 4.获取DexPathList的成员 Element[] dexElements 的值
            // Element是DexPathList的内部类
            val dexElements = dexElementsField[dexPathList] as Array<*>

            // 5.获取dexElements数组的类型 (Element)
            // 数组的 class 对象的getComponentType()方法可以取得一个数组的Class对象
            val elementClazz = dexElements.javaClass.componentType

            // 6.创建一个数组, 用来替换原始的数组
            // 通过Array.newInstance()可以反射生成数组对象,生成数组,指定元素类型和数组长度
            val hostAndPluginElements: Array<*> = java.lang.reflect.Array.newInstance(
                elementClazz!!,
                dexElements.size + 1
            ) as Array<*>

            // 根据不同的API, 获取插件DexClassLoader的 DexPathList中的 dexElements数组
            val optimizedDirectory =
                PluginUtils.getPluginOptDexDir(context = context, packageName = "com.malin.plugin")
            val pluginElements: Array<*>

            // 7.创建插件element数组
            val apiLevel = Build.VERSION.SDK_INT
            when {
                apiLevel >= 23 -> {

                    // 1.
                    val files = ArrayList<File>()
                    files.add(apkFile)
                    val suppressedExceptions: List<IOException> = ArrayList()

                    // 2.
                    // private static Element[] makePathElements(List<File> files, File optimizedDirectory, List<IOException> suppressedExceptions)
                    val makePathElementsMethod = dexPathList.javaClass.getDeclaredMethod(
                        "makePathElements",
                        List::class.java,
                        File::class.java,
                        List::class.java
                    ).also { it.isAccessible = true }

                    // 3.
                    pluginElements = makePathElementsMethod.invoke(
                        null,
                        files,
                        optimizedDirectory,
                        suppressedExceptions
                    ) as Array<*>
                }

                apiLevel >= 19 -> {
                    // 1.
                    val files = ArrayList<File>()
                    files.add(apkFile)
                    val suppressedExceptions = ArrayList<IOException>()

                    // 2.
                    // private static Element[] makeDexElements(ArrayList<File> files,File optimizedDirectory,ArrayList<IOException> suppressedExceptions)
                    val makeDexElementsMethod = dexPathList.javaClass.getDeclaredMethod(
                        "makeDexElements",
                        ArrayList::class.java,
                        File::class.java,
                        ArrayList::class.java
                    ).also { it.isAccessible = true }

                    // 3.
                    pluginElements = makeDexElementsMethod.invoke(
                        null,
                        files,
                        optimizedDirectory,
                        suppressedExceptions
                    ) as Array<*>
                }

                else -> {
                    // 1.
                    val files = ArrayList<File>()
                    files.add(apkFile)

                    // 2.
                    // private static Element[] makeDexElements(ArrayList<File> files,File optimizedDirectory)
                    val makeDexElementsMethod = dexPathList.javaClass.getDeclaredMethod(
                        "makeDexElements",
                        ArrayList::class.java,
                        File::class.java
                    ).also { it.isAccessible = true }

                    // 3.
                    pluginElements =
                        makeDexElementsMethod.invoke(null, files, optimizedDirectory) as Array<*>
                }
            }

            // public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length)
            // * @param      src      the source array.
            // * @param      srcPos   starting position in the source array.
            // * @param      dest     the destination array.
            // * @param      destPos  starting position in the destination data.
            // * @param      length   the number of array elements to be copied.
            // https://blog.csdn.net/wenzhi20102321/article/details/78444158

            // 8.把宿主的elements复制进去
            System.arraycopy(dexElements, 0, hostAndPluginElements, 0, dexElements.size)

            // 9.把宿主的elements复制进去
            System.arraycopy(
                pluginElements,
                0,
                hostAndPluginElements,
                dexElements.size,
                pluginElements.size
            )

            // 10.替换
            dexElementsField[dexPathList] = hostAndPluginElements

            // 简要总结一下这种方式的原理:
            // 默认情况下performLaunchActivity会使用替身StubActivity的ApplicationInfo也就是宿主程序的ClassLoader加载所有的类;
            // 我们的思路是告诉宿主ClassLoader我们在哪,让其帮助完成类加载的过程.
            // 宿主程序的ClassLoader最终继承自BaseDexClassLoader,BaseDexClassLoader通过DexPathList进行类的查找过程;
            // 而这个查找通过遍历一个dexElements的数组完成;
            // 我们通过把插件dex添加进这个数组就让宿主ClassLoader获取了加载插件类的能力.
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }
}
