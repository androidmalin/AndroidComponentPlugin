package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

/**
 * AMS Hook
 */
@SuppressLint("PrivateApi")
public class HookAMS {

    public static void hookStartActivity(Context context, Class<?> aClass) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 26) {
            HookActivity8.hookStartActivity(context, aClass);
        } else {
            HookActivity7.hookStartActivity();
        }
    }
}
