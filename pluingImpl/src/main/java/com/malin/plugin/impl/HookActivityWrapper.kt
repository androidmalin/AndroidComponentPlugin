package com.malin.plugin.impl

import android.content.Context
import android.os.Build
import com.malin.plugin.impl.HookActivity.hookLauncherActivity
import com.malin.plugin.impl.HookActivity.hookPackageManager
import com.malin.plugin.impl.HookActivity.hookStartActivity

object HookActivityWrapper {
    fun hookStartActivity(context: Context, subActivityClass: Class<*>, isAppCompat: Boolean) {
        if (Build.VERSION.SDK_INT <= 18) {
            hookPackageManager(context, subActivityClass)
        }
        hookStartActivity(context, subActivityClass)
        hookLauncherActivity(context, subActivityClass, isAppCompat)
    }
}
