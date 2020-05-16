package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * get set ActivityManager, PackageManager, ActivityThread$H
 */
@SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
public class HookAMS {

    static void hookStartActivity(Context context, Class<?> subActivityClass, boolean isAppCompat) {
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
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    static Object getIActivityManager() {
        Object iActivityManagerObj = null;
        try {
            Field iActivityManagerSingletonField;
            if (Build.VERSION.SDK_INT >= 26) {
                //1.获取ActivityManager的Class对象
                //package android.app
                //public class ActivityManager
                Class<?> activityManagerClazz = Class.forName("android.app.ActivityManager");

                //2.获取ActivityManager中IActivityManagerSingleton属性的Field
                //private static final Singleton<IActivityManager> IActivityManagerSingleton
                iActivityManagerSingletonField = activityManagerClazz.getDeclaredField("IActivityManagerSingleton");
            } else {
                Class<?> activityManagerNativeClazz = Class.forName("android.app.ActivityManagerNative");
                iActivityManagerSingletonField = activityManagerNativeClazz.getDeclaredField("gDefault");
            }

            //3.禁止Java语言访问检查
            iActivityManagerSingletonField.setAccessible(true);

            //4.获取IActivityManagerSingleton属性的值
            // 所有静态对象的反射可以通过传null获取。如果是实列必须传实例
            // private static final Singleton<IActivityManager> IActivityManagerSingleton
            Object iActivityManagerSingletonObj = iActivityManagerSingletonField.get(null);

            //5.获取Singleton类的对象
            //package android.util;
            //public abstract class Singleton<T>
            Class<?> singletonClazz = Class.forName("android.util.Singleton");

            //6.获取Singleton中mInstance属性的Field
            // private T mInstance;既 IActivityManager mInstance
            Field mInstanceField = singletonClazz.getDeclaredField("mInstance");

            //7.禁止Java语言访问检查
            mInstanceField.setAccessible(true);

            //8.获取mInstance属性的的值,既IActivityManager
            iActivityManagerObj = mInstanceField.get(iActivityManagerSingletonObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return iActivityManagerObj;
    }


    /**
     * 重置系统的IActivityManager
     *
     * @param iActivityManager IActivityManager
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    static void resetIActivityManager(Object iActivityManager) {
        try {
            Field iActivityManagerSingletonField;
            if (Build.VERSION.SDK_INT >= 26) {
                Class<?> activityManagerClazz = Class.forName("android.app.ActivityManager");
                iActivityManagerSingletonField = activityManagerClazz.getDeclaredField("IActivityManagerSingleton");
            } else {
                Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
                iActivityManagerSingletonField = activityManagerNativeClass.getDeclaredField("gDefault");
            }
            iActivityManagerSingletonField.setAccessible(true);
            Object iActivityManagerSingletonObj = iActivityManagerSingletonField.get(null);
            Class<?> singletonClazz = Class.forName("android.util.Singleton");
            Field mInstanceField = singletonClazz.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);
            mInstanceField.set(iActivityManagerSingletonObj, iActivityManager);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取ActivityThread属性mH的值
     *
     * @return ActivityThread类中的内部类H的值 Handler
     */
    @SuppressWarnings("unused")
    public static Object getActivityThreadInnerHandler() {
        Object handlerObj = null;
        try {
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
            handlerObj = mHField.get(activityThreadObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return handlerObj;
    }

    /**
     * 重置ActivityThread中mH属性的值
     *
     * @param mH Handler
     */
    @SuppressWarnings("unused")
    public static void resetActivityThreadInnerHandler(Object mH) {
        try {
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
