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
        //111 instrumentation = false, firstMode = true; meizu 15/15pro error
        //122 instrumentation = true, firstMode = false
        //133 instrumentation = false, firstMode = false
        //144 instrumentation = true, firstMode = false
        //145 instrumentation = false, firstMode = false
        //151 instrumentation = false, firstMode = false
        PluginImpl.init(context = baseContext, instrumentation = false, firstMode = false)
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}
