package com.malin.hook

import android.app.Application
import android.content.Context
import com.malin.plugin.impl.PluginImpl

class MApplication : Application() {
    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        PluginImpl.instance.init(context = context, instrumentation = true, firstMode = true)
    }
}