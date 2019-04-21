package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * AMS Hook
 */
@SuppressWarnings("ALL")
@SuppressLint("PrivateApi")
public class HookAMS {

    public static void hookStartActivity(Context context, Class<?> subActivityClass, boolean isAppCompat) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (Build.VERSION.SDK_INT <= 18) {
            HookActivity.hookPackageManager(context, subActivityClass);
        }
        HookActivity.hookStartActivity(context, subActivityClass);
        HookActivity.hookLauncherActivity(context, subActivityClass, isAppCompat);
    }


    /**
     * 获取IActivityManager实例
     *
     * @return IActivityManager实例
     * @throws ClassNotFoundException classNotFoundException
     * @throws NoSuchFieldException   noSuchFieldException
     * @throws IllegalAccessException illegalAccessException
     */
    public static Object getIActivityManagerObj() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field gDefaultField;
        if (Build.VERSION.SDK_INT >= 26) {
            //1.获取ActivityManager的Class对象
            //package android.app
            //public class ActivityManager
            Class<?> activityManager = Class.forName("android.app.ActivityManager");

            //2.获取ActivityManager中IActivityManagerSingleton属性的Field
            //private static final Singleton<IActivityManager> IActivityManagerSingleton
            gDefaultField = activityManager.getDeclaredField("IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
            gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        }

        //3.禁止Java语言访问检查
        gDefaultField.setAccessible(true);

        //4.获取IActivityManagerSingleton属性的值
        // 所有静态对象的反射可以通过传null获取。如果是实列必须传实例
        // private static final Singleton<IActivityManager> IActivityManagerSingleton
        Object gDefaultObj = gDefaultField.get(null);

        //5.获取Singleton类的对象
        //package android.util;
        //public abstract class Singleton<T>
        Class<?> singletonClazz = Class.forName("android.util.Singleton");

        //6.获取Singleton中mInstance属性的Field
        // private T mInstance;既 IActivityManager mInstance
        Field iActivityManagerField = singletonClazz.getDeclaredField("mInstance");

        //7.禁止Java语言访问检查
        iActivityManagerField.setAccessible(true);

        //8.获取mInstance属性的的值,既IActivityManager
        return iActivityManagerField.get(gDefaultObj);
    }


    /**
     * 重置系统的IActivityManager
     *
     * @param iActivityManagerObj IActivityManager
     * @throws ClassNotFoundException classNotFoundException
     * @throws NoSuchFieldException   noSuchFieldException
     * @throws IllegalAccessException illegalAccessException
     */
    public static void resetIActivityManager(Object iActivityManagerObj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field gDefaultField;
        if (Build.VERSION.SDK_INT >= 26) {
            Class<?> activityManager = Class.forName("android.app.ActivityManager");
            gDefaultField = activityManager.getDeclaredField("IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
            gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        }
        gDefaultField.setAccessible(true);
        Object gDefaultObj = gDefaultField.get(null);
        Class<?> singletonClazz = Class.forName("android.util.Singleton");
        Field iActivityManagerField = singletonClazz.getDeclaredField("mInstance");
        iActivityManagerField.setAccessible(true);
        iActivityManagerField.set(gDefaultObj, iActivityManagerObj);
    }

    /**
     * 获取ActivityThread属性mH的值
     *
     * @return ActivityThread类中的内部类H的值 Handler
     * @throws ClassNotFoundException classNotFoundException
     * @throws NoSuchFieldException   noSuchFieldException
     * @throws IllegalAccessException illegalAccessException
     */
    public static Object getActivityThreadInnerHandler() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //1.获取ActivityThread的Class对象
        //package android.app
        //public final class ActivityThread
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

        //public static ActivityThread currentActivityThread()
        //2.获取currentActivityThread()方法
        //public static ActivityThread currentActivityThread()
        Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);

        //3.获取ActivityThread的对象
        //public static ActivityThread currentActivityThread()
        Object activityThreadObj = currentActivityThreadMethod.invoke(null);

        //5.获取mH属性的Field
        // final H mH = new H();
        Field mHField = activityThreadClass.getDeclaredField("mH");

        //6.禁止Java语言访问检查
        mHField.setAccessible(true);

        //7.获取mH属性对应的值,既ActivityThread类中的Handler
        return mHField.get(activityThreadObj);
    }

    /**
     * 重置ActivityThread中mH属性的值
     *
     * @param mH Handler
     * @throws ClassNotFoundException classNotFoundException
     * @throws NoSuchFieldException   noSuchFieldException
     * @throws IllegalAccessException illegalAccessException
     */
    public static void resetActivityThreadInnerHandler(Object mH) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.获取ActivityThread的Class对象
        //package android.app
        //public final class ActivityThread
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

        //public static ActivityThread currentActivityThread()
        //2.获取currentActivityThread()方法
        //public static ActivityThread currentActivityThread()
        Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);

        //3.获取ActivityThread的对象
        //public static ActivityThread currentActivityThread()
        Object activityThreadObj = currentActivityThreadMethod.invoke(null);


        //4.获取ActivityThread的中mH属性的Field
        //final H mH = new H();
        Field mHField = activityThreadClass.getDeclaredField("mH");

        //5.禁止Java访问检查
        mHField.setAccessible(true);

        //6.给mH属性设置新值
        //ActivityThread类中的mH属性设置新值
        mHField.set(activityThreadObj, mH);
    }

}
