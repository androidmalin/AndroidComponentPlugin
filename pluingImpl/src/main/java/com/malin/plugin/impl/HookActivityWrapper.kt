package com.malin.plugin.impl

import android.content.Context
import android.os.Build

object HookActivityWrapper {
    fun hookStartActivity(context: Context, subActivityClass: Class<*>, isAppCompat: Boolean) {
        hookPackageManager(context, subActivityClass, isAppCompat)
        HookActivity.hookStartActivity(context, subActivityClass)
        HookActivity.hookLauncherActivity(context, subActivityClass, isAppCompat)
    }

    fun hookPackageManager(context: Context, subActivityClass: Class<*>, isAppCompat: Boolean) {
        // 处理启动的Activity为AppCompatActivity类或者子类的情况
        if (isAppCompat || Build.VERSION.SDK_INT <= 18) {
            HookActivity.hookPackageManager(context, subActivityClass)
        }
    }
}
