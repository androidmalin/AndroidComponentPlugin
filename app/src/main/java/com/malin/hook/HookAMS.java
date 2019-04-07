package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;

import java.lang.reflect.Field;

/**
 * AMS Hook
 */
@SuppressWarnings("JavaReflectionMemberAccess")
@SuppressLint("PrivateApi")
public class HookAMS {

    public static void hookStartActivity(Context context, Class<?> subActivityClass, boolean isAppCompat) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 26) {
            HookActivity8.hookStartActivity(context, subActivityClass);
            HookActivity8.hookLauncherActivity(context, subActivityClass, isAppCompat);
        } else {
            HookActivity7.hookStartActivity();
        }
    }

    public static Handler storeActivityLaunch() throws Exception {
        Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
        Field sCurrentActivityThreadField = activityThreadClazz.getDeclaredField("sCurrentActivityThread");
        sCurrentActivityThreadField.setAccessible(true);
        Object sCurrentActivityThreadObj = sCurrentActivityThreadField.get(null);
        Field mHField = activityThreadClazz.getDeclaredField("mH");
        mHField.setAccessible(true);
        return (Handler) mHField.get(sCurrentActivityThreadObj);

    }


    public static Object storeAms() throws Exception {
        Field gDefaultField;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Class<?> activityManager = Class.forName("android.app.ActivityManager");
            gDefaultField = activityManager.getDeclaredField("IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNativeClass = Class.forName("android.app" + ".ActivityManagerNative");
            gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        }
        gDefaultField.setAccessible(true);
        Object gDefaultObj = gDefaultField.get(null); //所有静态对象的反射可以通过传null获取。如果是实列必须传实例
        Class<?> singletonClazz = Class.forName("android.util.Singleton");
        Field amsField = singletonClazz.getDeclaredField("mInstance");
        amsField.setAccessible(true);
        return amsField.get(gDefaultObj);
    }

    public static void resetActivityLaunch(Object mH) throws Exception {
        Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
        Field sCurrentActivityThreadField = activityThreadClazz.getDeclaredField("sCurrentActivityThread");
        sCurrentActivityThreadField.setAccessible(true);
        Object sCurrentActivityThreadObj = sCurrentActivityThreadField.get(null);
        Field mHField = activityThreadClazz.getDeclaredField("mH");
        mHField.setAccessible(true);
        Field callBackField = Handler.class.getDeclaredField("mCallback");
        callBackField.setAccessible(true);
        callBackField.set(sCurrentActivityThreadObj, mH);
    }


    public static void resetAms(Object amsObj) throws Exception {
        Field gDefaultField;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Class<?> activityManager = Class.forName("android.app.ActivityManager");
            gDefaultField = activityManager.getDeclaredField("IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNativeClass = Class.forName("android.app" + ".ActivityManagerNative");
            gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        }
        gDefaultField.setAccessible(true);
        Object gDefaultObj = gDefaultField.get(null);
        Class<?> singletonClazz = Class.forName("android.util.Singleton");
        Field amsField = singletonClazz.getDeclaredField("mInstance");
        amsField.setAccessible(true);
        amsField.set(gDefaultObj, amsObj);
    }
}
