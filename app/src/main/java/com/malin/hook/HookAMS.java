package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

/**
 * AMS Hook
 */
@SuppressLint("PrivateApi")
public class HookAMS {

    public static void hookStartActivity(Context context, Class<?> aClass, boolean isAppCompat) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 26) {
            HookActivity8.hookStartActivity(context, aClass);
            HookActivity8.hookLauncherActivity(context, aClass, isAppCompat);
        } else {
            HookActivity7.hookStartActivity();
        }
    }
}
