package com.malin.hook

import android.app.Application
import android.content.Context
import com.malin.plugin.impl.PluginImpl

class MApplication : Application() {
    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
    }

    override fun onCreate() {
        super.onCreate()
        PluginImpl.init(context = baseContext, instrumentation = false, firstMode = true)
    }
}
