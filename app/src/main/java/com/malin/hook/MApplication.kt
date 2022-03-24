package com.malin.hook

import android.app.Application
import android.content.Context
import android.os.Build
import com.malin.plugin.impl.PluginImpl
import org.lsposed.hiddenapibypass.HiddenApiBypass

class MApplication : Application() {
    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        if (Build.VERSION.SDK_INT >= 28) HiddenApiBypass.addHiddenApiExemptions("");
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        PluginImpl.init(context = baseContext, instrumentation = false, firstMode = true)
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}
