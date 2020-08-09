package com.malin.hook;

import android.content.Context;
import android.os.Build;

public class HookActivityWrapper {
    public static void hookStartActivity(Context context, Class<?> subActivityClass, boolean isAppCompat) {
        if (Build.VERSION.SDK_INT <= 18) {
            HookActivity.hookPackageManager(context, subActivityClass);
        }
        HookActivity.hookStartActivity(context, subActivityClass);
        HookActivity.hookLauncherActivity(context, subActivityClass, isAppCompat);
    }
}
