package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 15-27 ok
 * >=28,29,30 error
 */
public class ApplicationParserUtil {

    /**
     * ApplicationInfo:这个类就是AndroidManifest.xml里面的这个标签下面的信息
     * 这个方法的最终目的是调用
     * android.content.pm.PackageParser#generateActivityInfo(android.content.pm.PackageParser.Activity,int,android.content.pm.PackageUserState,int)
     */
    @SuppressLint("PrivateApi")
    public static ApplicationInfo generateApplicationInfo(File apkFile)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {

        //1.获取PackageParser的Class对象
        //package android.content.pm
        //public class PackageParser
        Class<?> packageParserClazz = Class.forName("android.content.pm.PackageParser");

        //2.获取parsePackage()方法的Method
        Method parsePackageMethod;
        if (Build.VERSION.SDK_INT >= 20) {
            //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//21<=api<=29
            parsePackageMethod = packageParserClazz.getDeclaredMethod("parsePackage", File.class, int.class);
        } else {
            //15<=Build.VERSION.SDK_INT <=19
            //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//15<=api<=19
            parsePackageMethod = packageParserClazz.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, int.class);
        }
        parsePackageMethod.setAccessible(true);

        //3.生成PackageParser对象实例
        Object packageParser;
        if (Build.VERSION.SDK_INT >= 20) {
            packageParser = packageParserClazz.newInstance();
        } else {
            // 15<=Build.VERSION.SDK_INT <=19
            //public PackageParser(String archiveSourcePath) {}//15<=api<=19
            Constructor<?> packageParserConstructor = packageParserClazz.getDeclaredConstructor(String.class);
            packageParserConstructor.setAccessible(true);
            String archiveSourcePath = apkFile.getCanonicalPath();
            packageParser = packageParserConstructor.newInstance(archiveSourcePath);
        }

        //4.调用parsePackage获取到apk对象对应的Package对象(return information about intent receivers in the package)
        //Package为PackageParser的内部类;public final static class Package implements Parcelable {}
        Object packageObj;
        if (Build.VERSION.SDK_INT >= 20) {
            //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//21<=api<=29
            //第二个参数是解析包使用的flag,直接选择解析全部信息,也就是0
            packageObj = parsePackageMethod.invoke(packageParser, apkFile, 0);
        } else {
            // 15<=Build.VERSION.SDK_INT <=19
            String destCodePath = apkFile.getCanonicalPath();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();//参考api=29时 PackageParser的默认构造函数中的表达式

            //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//15<=api<=19
            packageObj = parsePackageMethod.invoke(packageParser, apkFile, destCodePath, displayMetrics, 0);
        }

        //Package:为PackageParser的静态内部类
        //public class PackageParser {
        //       public final static class Package implements Parcelable {
        //           public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        //       }
        // }
        if (packageObj == null) return null;

        //5.获取内部类Package的class对象
        //public final static class Package
        Class<?> packageParser$PackageClazz = Class.forName("android.content.pm.PackageParser$Package");

        // 我们的终极目标:
        // android.content.pm.PackageParser#generateApplicationInfo(android.content.pm.PackageParser.Package,int,android.content.pm.PackageUserState)
        // 要调用这个方法,需要做很多准备工作

        // 首先准备 generateApplicationInfo方法的三个参数

        ApplicationInfo applicationInfo;
        if (Build.VERSION.SDK_INT >= 17) {
            //public static ApplicationInfo generateApplicationInfo(Package p,int flags,PackageUserState state) {}

            //6.获取PackageUserState的Class对象
            Class<?> packageUserStateClazz = Class.forName("android.content.pm.PackageUserState");

            //7.生成PackageUserState的实例对象
            Object defaultPackageUserState = packageUserStateClazz.newInstance();

            //8.获取generateApplicationInfo()方法
            //public static ApplicationInfo generateApplicationInfo(Package p,int flags,PackageUserState state) {
            Method generateApplicationInfoMethod = packageParserClazz.getDeclaredMethod("generateApplicationInfo", packageParser$PackageClazz, int.class, packageUserStateClazz);

            //9.反射调用generateApplicationInfo()方法,获取插件的ApplicationInfo实例对象
            //public static ApplicationInfo generateApplicationInfo(Package p,int flags,PackageUserState state) {}
            applicationInfo = (ApplicationInfo) generateApplicationInfoMethod.invoke(packageParser, packageObj, 0, defaultPackageUserState);

        } else if (Build.VERSION.SDK_INT == 16) {
            //public static ApplicationInfo generateApplicationInfo(Package p, int flags, boolean stopped,int enabledState)//api=16
            Method generateApplicationInfoMethod = packageParserClazz.getDeclaredMethod("generateApplicationInfo", packageParser$PackageClazz, int.class, boolean.class, int.class);
            generateApplicationInfoMethod.setAccessible(true);
            int enabledState = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
            applicationInfo = (ApplicationInfo) generateApplicationInfoMethod.invoke(packageParser, packageObj, 0, false, enabledState);
        } else {
            //15
            //public static ApplicationInfo generateApplicationInfo(Package p, int flags) {}//api=15
            Method generateApplicationInfoMethod = packageParserClazz.getDeclaredMethod("generateApplicationInfo", packageParser$PackageClazz, int.class);
            generateApplicationInfoMethod.setAccessible(true);
            applicationInfo = (ApplicationInfo) generateApplicationInfoMethod.invoke(packageParser, packageObj, 0);
        }

        if (applicationInfo == null) throw new NullPointerException("applicationInfo == null");
        String apkPath = apkFile.getPath();
        applicationInfo.sourceDir = apkPath;
        applicationInfo.publicSourceDir = apkPath;
        return applicationInfo;
    }
}
