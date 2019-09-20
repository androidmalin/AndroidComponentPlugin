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
     * @param classLoader 表示宿主的LoadedApk在Application类中有一个成员变量mLoadedApk,而这个变量是从ContextImpl中获取的;
     *                    ContextImpl重写了getClassLoader方法,
     *                    因此我们在Context环境中直接getClassLoader()获取到的就是宿主程序唯一的ClassLoader.
     * @param apkFile     apkFile
     * @param optDexFile  optDexFile
     */
    static void patchClassLoader(ClassLoader classLoader, File apkFile, File optDexFile) {

        try {
            //0.获取dalvik.system.BaseDexClassLoader的Class
            Class<?> baseDexClassLoaderClazz = PathClassLoader.class.getSuperclass();
            if (baseDexClassLoaderClazz == null) return;

            //1. 获取 BaseDexClassLoader : pathList
            //private final DexPathList pathList;
            //http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/BaseDexClassLoader.java
            Field pathListField = baseDexClassLoaderClazz.getDeclaredField("pathList");
            pathListField.setAccessible(true);

            //2.获取DexPathList pathList;
            Object dexPathList = pathListField.get(classLoader);
            if (dexPathList == null) return;


            //3. 获取 DexPathList的属性: Element[] dexElements
            //private final Element[] dexElements;
            //http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/DexPathList.java
            Field dexElementArrayField = dexPathList.getClass().getDeclaredField("dexElements");
            dexElementArrayField.setAccessible(true);

            //4.获取 DexPathList的属性 Element[] dexElements;值
            //Element是DexPathList的内部类
            Object[] dexElements = (Object[]) dexElementArrayField.get(dexPathList);
            if (dexElements == null) return;

            //5. 获取数组的类型 (Element)
            // 数组的 class 对象的getComponentType()方法可以取得一个数组的Class对象
            Class<?> elementClazz = dexElements.getClass().getComponentType();
            if (elementClazz == null) return;

            //6. 创建一个数组, 用来替换原始的数组
            //通过Array.newInstance()可以反射生成数组对象,生成数组,指定元素类型和数组长度
            Object[] newElements = (Object[]) Array.newInstance(elementClazz, dexElements.length + 1);


            //根据不同的API, 获取插件DexClassLoader的 DexPathList中的 dexElements数组
            Object elementObj;
            if (Build.VERSION.SDK_INT >= 26) {
                //26<=API<=29 (8.0<=API<=10.0)
                //7.构造插件Element
                // 使用构造函数 public Element(DexFile dexFile, File dexZipPath){}
                //这个构造函数不能用了 @Deprecated public Element(File dir, boolean isDirectory, File zip, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getConstructor(DexFile.class, File.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                //http://androidxref.com/9.0.0_r3/xref/libcore/dalvik/src/main/java/dalvik/system/DexFile.java

                //DexFile.loadDex(String sourcePathName,String outputPathName,int flag);
                //  @param sourcePathName Jar or APK file with "classes.dex".  (May expand this to include "raw DEX" in the future.)
                //  @param outputPathName File that will hold the optimized form of the DEX data.
                elementObj = elementConstructor.newInstance(DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getAbsolutePath(), 0), apkFile);
            } else if (Build.VERSION.SDK_INT >= 18) {
                //18<=API<=25 (4.3<=API<=7.1.1)
                //7.构造插件Element
                // 使用构造函数 public Element(File file, boolean isDirectory, File zip, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getConstructor(File.class, boolean.class, File.class, DexFile.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                elementObj = elementConstructor.newInstance(apkFile, false, apkFile, DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getAbsolutePath(), 0));
            } else if (Build.VERSION.SDK_INT == 17) {
                //API=17  (API=4.2)
                //7.构造插件Element
                // 使用构造函数:public Element(File file, File zip, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getConstructor(File.class, File.class, DexFile.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                elementObj = elementConstructor.newInstance(apkFile, apkFile, DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getAbsolutePath(), 0));
            } else {
                //15~16
                //7.构造插件Element
                // 使用构造函数:public Element(File file, ZipFile zipFile, DexFile dexFile){}
                Constructor<?> elementConstructor = elementClazz.getConstructor(File.class, ZipFile.class, DexFile.class);
                elementConstructor.setAccessible(true);

                //8. 生成Element的实例对象
                elementObj = elementConstructor.newInstance(apkFile, new ZipFile(apkFile), DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getAbsolutePath(), 0));
            }


            Object[] pluginElementArray = new Object[]{elementObj};

            // 把原始的elements复制进去
            System.arraycopy(dexElements, 0, newElements, 0, dexElements.length);

            // 插件的那个element复制进去
            System.arraycopy(pluginElementArray, 0, newElements, dexElements.length, pluginElementArray.length);

            // 替换
            dexElementArrayField.set(dexPathList, newElements);
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
