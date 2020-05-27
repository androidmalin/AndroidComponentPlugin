package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * get/reset ActivityManager, PackageManager, ActivityThread$H
 */
public class HookAMS {

    public static void hookStartActivity(Context context, Class<?> subActivityClass, boolean isAppCompat) {
        if (Build.VERSION.SDK_INT <= 18) {
            HookActivity.hookPackageManager(context, subActivityClass);
        }
        HookActivity.hookStartActivity(context, subActivityClass);
        HookActivity.hookLauncherActivity(context, subActivityClass, isAppCompat);
    }


    /**
     * 获取IActivityManager/IActivityTaskManager实例
     *
     * @return IActivityManager/IActivityTaskManager实例
     */
    @SuppressWarnings({"JavaReflectionMemberAccess", "PrivateApi"})
    public static Object getIActivityManager() {
        try {
            Field iActivityManagerSingletonField;
            if (Build.VERSION.SDK_INT >= 29) {
                //1.获取ActivityTaskManager的Class对象
                //package android.app;
                //public class ActivityTaskManager
                Class<?> activityTaskManagerClazz = Class.forName("android.app.ActivityTaskManager");

                //2.获取ActivityTaskManager的私有静态成员变量IActivityTaskManagerSingleton Field
                // private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton
                iActivityManagerSingletonField = activityTaskManagerClazz.getDeclaredField("IActivityTaskManagerSingleton");

            } else if (Build.VERSION.SDK_INT >= 26) {
                //1.获取ActivityManager的Class对象
                //package android.app
                //public class ActivityManager
                Class<?> activityManagerClazz = Class.forName("android.app.ActivityManager");

                //2.获取ActivityManager中IActivityManagerSingleton成员变量的IActivityManagerSingleton Field
                //private static final Singleton<IActivityManager> IActivityManagerSingleton
                iActivityManagerSingletonField = activityManagerClazz.getDeclaredField("IActivityManagerSingleton");
            } else {
                Class<?> activityManagerNativeClazz = Class.forName("android.app.ActivityManagerNative");
                iActivityManagerSingletonField = activityManagerNativeClazz.getDeclaredField("gDefault");
            }

            //3.禁止Java语言访问检查
            iActivityManagerSingletonField.setAccessible(true);

            //4.获取IActivityTaskManagerSingleton/IActivityManagerSingleton属性的值
            // 所有静态对象的反射可以通过传null获取。如果是实列必须传实例
            // private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton
            // private static final Singleton<IActivityManager> IActivityManagerSingleton
            Object iActivityManagerSingletonObj = iActivityManagerSingletonField.get(null);

            //5.获取Singleton类的对象
            //package android.util;
            //public abstract class Singleton<T>
            Class<?> singletonClazz = Class.forName("android.util.Singleton");

            //6.获取Singleton中mInstance属性的Field
            // private T mInstance;既 IActivityTaskManager mInstance /IActivityManager mInstance
            Field mInstanceField = singletonClazz.getDeclaredField("mInstance");

            //7.禁止Java语言访问检查
            mInstanceField.setAccessible(true);

            //8.获取mInstance属性的的值,既IActivityTaskManager/IActivityManager
            return mInstanceField.get(iActivityManagerSingletonObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 重置系统的IActivityManager/IActivityTaskManager
     *
     * @param iActivityManagerObj IActivityManager/IActivityTaskManager
     */
    @SuppressWarnings({"JavaReflectionMemberAccess", "PrivateApi"})
    public static void resetIActivityManager(Object iActivityManagerObj) {
        try {
            Field iActivityManagerSingletonField;
            if (Build.VERSION.SDK_INT >= 29) {
                //1.获取ActivityTaskManager的Class对象
                //package android.app;
                //public class ActivityTaskManager
                Class<?> activityTaskManagerClazz = Class.forName("android.app.ActivityTaskManager");

                //2.获取ActivityTaskManager的私有静态成员变量IActivityTaskManagerSingleton
                // private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton
                iActivityManagerSingletonField = activityTaskManagerClazz.getDeclaredField("IActivityTaskManagerSingleton");

            } else if (Build.VERSION.SDK_INT >= 26) {
                Class<?> activityManagerClazz = Class.forName("android.app.ActivityManager");
                iActivityManagerSingletonField = activityManagerClazz.getDeclaredField("IActivityManagerSingleton");
            } else {
                Class<?> activityManagerNativeClazz = Class.forName("android.app.ActivityManagerNative");
                iActivityManagerSingletonField = activityManagerNativeClazz.getDeclaredField("gDefault");
            }
            iActivityManagerSingletonField.setAccessible(true);
            Object iActivityManager = iActivityManagerSingletonField.get(null);
            Class<?> singletonClazz = Class.forName("android.util.Singleton");
            Field mInstanceField = singletonClazz.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);
            mInstanceField.set(iActivityManager, iActivityManagerObj);
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
    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    public static Object getActivityThreadInnerHandler() {
        try {
            //1.获取ActivityThread的Class对象
            //package android.app
            //public final class ActivityThread
            Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");

            //2.获取currentActivityThread()方法
            //public static ActivityThread currentActivityThread()
            Method currentActivityThreadMethod = activityThreadClazz.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);

            //3.获取ActivityThread的对象
            //public static ActivityThread currentActivityThread()
            Object activityThreadObj = currentActivityThreadMethod.invoke(null);

            //4.获取mH属性的Field
            // final H mH = new H();
            Field mHField = activityThreadClazz.getDeclaredField("mH");

            //5.禁止Java语言访问检查
            mHField.setAccessible(true);

            //6.获取mH属性对应的值,既ActivityThread类中的Handler
            return mHField.get(activityThreadObj);
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
        return null;
    }

    /**
     * 重置ActivityThread中mH属性的值
     *
     * @param mH Handler
     */
    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    public static void resetActivityThreadInnerHandler(Object mH) {
        try {
            //1.获取ActivityThread的Class对象
            //package android.app
            //public final class ActivityThread
            Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

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
