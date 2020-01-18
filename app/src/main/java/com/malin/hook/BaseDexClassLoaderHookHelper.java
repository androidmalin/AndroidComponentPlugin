package com.malin.hook;

import android.os.Build;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipFile;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;

/**
 * 由于应用程序使用的ClassLoader为PathClassLoader 最终继承自 BaseDexClassLoader
 * 查看源码得知,这个BaseDexClassLoader加载代码根据一个叫做dexElements的数组进行,
 * 因此我们把包含代码的dex文件插入这个数组. 系统的classLoader就能帮助我们找到这个类
 * <p>
 * 把插件的相关信息放入BaseDexClassLoader的表示dex文件的数组里面,
 * 这样宿主程序的ClassLoader在进行类加载,遍历这个数组的时候,
 * 会自动遍历到我们添加进去的插件信息,从而完成插件类的加载！
 * <p>
 * 这个类用来进行对于BaseDexClassLoader的Hook
 * com from wei shu
 * http://weishu.me/2016/04/05/understand-plugin-framework-classloader/
 * https://www.jianshu.com/p/a8184c8fe688?tdsourcetag=s_pcqq_aiomsg
 * https://www.jianshu.com/p/31dbe3317fe1
 */
final class BaseDexClassLoaderHookHelper {

    /*
     * 默认情况下performLaunchActivity会使用替身StubActivity的ApplicationInfo也就是宿主程序的ClassLoader加载所有的类;
     * 我们的思路是告诉宿主ClassLoader我们在哪,让其帮助完成类加载的过程.
     * <p>
     * 宿主程序的ClassLoader最终继承自BaseDexClassLoader,BaseDexClassLoader通过DexPathList进行类的查找过程;
     * 而这个查找通过遍历一个dexElements的数组完成;
     * <p>
     * 我们通过把插件dex添加进这个数组就让宿主ClassLoader获取了加载插件类的能力.
     * <p>
     * 系统使用ClassLoader findClass的过程,发现应用程序使用的非系统类都是通过同一个PathClassLoader加载的;
     * 而这个类的最终父类BaseDexClassLoader通过DexPathList完成类的查找过程;我们hack了这个查找过程,从而完成了插件类的加载
     */

    /**
     * 使用宿主ClassLoader帮助加载插件类
     * java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation
     * 在插件apk和宿主中包含了相同的Jar包;解决方法,插件编译时使用compileOnly依赖和宿主相同的依赖.
     * https://blog.csdn.net/berber78/article/details/41721877
     *
     * @param baseDexClassLoader 表示宿主的LoadedApk在Application类中有一个成员变量mLoadedApk,而这个变量是从ContextImpl中获取的;
     *                           ContextImpl重写了getClassLoader方法,
     *                           因此我们在Context环境中直接getClassLoader()获取到的就是宿主程序唯一的ClassLoader.
     * @param apkFile            apkFile
     * @param optDexFile         optDexFile
     */
    static void patchClassLoader(ClassLoader baseDexClassLoader, File apkFile, File optDexFile) {

        // -->PathClassLoader
        // -->BaseDexClassLoader
        // -->BaseDexClassLoader中DexPathList pathList
        // -->DexPathList中 Element[] dexElements
        try {
            //0. 获取PathClassLoader的父类dalvik.system.BaseDexClassLoader的Class对象
            Class<?> baseDexClassLoaderClazz = PathClassLoader.class.getSuperclass();
            if (baseDexClassLoaderClazz == null) return;

            //1. 获取 BaseDexClassLoader的成员DexPathList pathList
            //private final DexPathList pathList;
            //http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/BaseDexClassLoader.java
            Field pathListField = baseDexClassLoaderClazz.getDeclaredField("pathList");
            pathListField.setAccessible(true);

            //2.获取DexPathList pathList实例;
            Object dexPathList = pathListField.get(baseDexClassLoader);
            if (dexPathList == null) return;


            //3. 获取 DexPathList的成员: Element[] dexElements 的Field
            //private Element[] dexElements;
            //http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/DexPathList.java
            Field dexElementsField = dexPathList.getClass().getDeclaredField("dexElements");
            dexElementsField.setAccessible(true);

            //4.获取 DexPathList的成员 Element[] dexElements 的值
            //Element是DexPathList的内部类
            Object[] dexElements = (Object[]) dexElementsField.get(dexPathList);
            if (dexElements == null) return;

            //5. 获取dexElements数组的类型 (Element)
            // 数组的 class 对象的getComponentType()方法可以取得一个数组的Class对象
            Class<?> elementClazz = dexElements.getClass().getComponentType();
            if (elementClazz == null) return;

            //6. 创建一个数组, 用来替换原始的数组
            //通过Array.newInstance()可以反射生成数组对象,生成数组,指定元素类型和数组长度
            Object[] hostAndPluginElements = (Object[]) Array.newInstance(elementClazz, dexElements.length + 1);


            //根据不同的API, 获取插件DexClassLoader的 DexPathList中的 dexElements数组
            Object elementPluginObj;
            if (Build.VERSION.SDK_INT >= 26) {
                //26<=API<=29 (8.0<=API<=10.0)
                //7.构造插件Element
                // 使用构造函数 public Element(DexFile dexFile, File dexZipPath){}
                // 这个构造函数不能用了 @Deprecated public Element(File dir, boolean isDirectory, File zip, DexFile dexFile){}
                // http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/DexPathList.java#637
                // 注意getConstructor vs getDeclaredConstructor 的区别
                // public Element(File dir, boolean isDirectory, File zip, DexFile dexFile) {
                @SuppressWarnings("deprecation")
                Constructor<?> elementConstructor = elementClazz.getDeclaredConstructor(DexFile.class, File.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                //http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/DexFile.java

                //DexFile.loadDex(String sourcePathName,String outputPathName,int flag);
                //  @param sourcePathName Jar or APK file with "classes.dex".  (May expand this to include "raw DEX" in the future.)
                //  @param outputPathName File that will hold the optimized form of the DEX data.
                //  @param flags Enable optional features.  (Currently none defined.)
                // warn log from http://androidxref.com/9.0.0_r3/xref/art/runtime/oat_file_manager.cc#404
                @SuppressWarnings("deprecation")
                DexFile dexFile = DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getCanonicalPath(), 0);
                elementPluginObj = elementConstructor.newInstance(dexFile, apkFile);
            } else if (Build.VERSION.SDK_INT >= 18) {
                //18<=API<=25 (4.3<=API<=7.1.1)
                //7.构造插件Element
                // 使用构造函数 public Element(File file, boolean isDirectory, File zip, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getDeclaredConstructor(File.class, boolean.class, File.class, DexFile.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                DexFile dexFile = DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getCanonicalPath(), 0);
                elementPluginObj = elementConstructor.newInstance(apkFile, false, apkFile, dexFile);
            } else if (Build.VERSION.SDK_INT == 17) {
                //API=17  (API=4.2)
                //7.构造插件Element
                // 使用构造函数:public Element(File file, File zip, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getDeclaredConstructor(File.class, File.class, DexFile.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                DexFile dexFile = DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getCanonicalPath(), 0);
                elementPluginObj = elementConstructor.newInstance(apkFile, apkFile, dexFile);
            } else {
                //15~16 (4.0.3=<API=4.1)
                //7.构造插件Element
                // 使用构造函数:public Element(File file, ZipFile zipFile, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getDeclaredConstructor(File.class, ZipFile.class, DexFile.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                DexFile dexFile = DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getCanonicalPath(), 0);
                elementPluginObj = elementConstructor.newInstance(apkFile, new ZipFile(apkFile), dexFile);
            }


            Object[] pluginElements = new Object[]{elementPluginObj};

            //public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length)
            //* @param      src      the source array.
            //* @param      srcPos   starting position in the source array.
            //* @param      dest     the destination array.
            //* @param      destPos  starting position in the destination data.
            //* @param      length   the number of array elements to be copied.
            //https://blog.csdn.net/wenzhi20102321/article/details/78444158

            // 插件的那个element复制进去
            System.arraycopy(pluginElements, 0, hostAndPluginElements, 0, pluginElements.length);

            // 把宿主的elements复制进去
            System.arraycopy(dexElements, 0, hostAndPluginElements, pluginElements.length, dexElements.length);

            // 替换
            dexElementsField.set(dexPathList, hostAndPluginElements);

            // 简要总结一下这种方式的原理:
            // 默认情况下performLaunchActivity会使用替身StubActivity的ApplicationInfo也就是宿主程序的CLassLoader加载所有的类;
            // 我们的思路是告诉宿主ClassLoader我们在哪,让其帮助完成类加载的过程.
            // 宿主程序的ClassLoader最终继承自BaseDexClassLoader,BaseDexClassLoader通过DexPathList进行类的查找过程;
            // 而这个查找通过遍历一个dexElements的数组完成;
            // 我们通过把插件dex添加进这个数组就让宿主ClassLoader获取了加载插件类的能力.
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
