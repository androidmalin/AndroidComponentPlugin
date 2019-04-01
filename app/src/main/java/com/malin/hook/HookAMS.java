package com.malin.hook;

import android.annotation.SuppressLint;
import android.os.Build;

/**
 * AMS Hook
 */
@SuppressLint("PrivateApi")
public class HookAMS {

    public static void hookStartActivity() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            HookActivity8.hookStartActivity();
        } else {
            HookActivity7.hookStartActivity();
        }
    }
}
