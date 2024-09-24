package com.malin.hook

import android.app.Application
import android.content.Context
import android.os.Build
import com.malin.plugin.impl.PluginImpl
import org.lsposed.hiddenapibypass.HiddenApiBypass

class MApplication : Application() {

    /**
     * 处理反射系统API的限制
     * 原理参考:
     * https://github.com/LSPosed/AndroidHiddenApiBypass
     */
    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        if (Build.VERSION.SDK_INT >= 28) {
            HiddenApiBypass.addHiddenApiExemptions("")
        }
    }

    /**
     * 开启插件hook,加载插件apk和进行相关的hook
     */
    override fun onCreate() {
        super.onCreate()
        instance = this
        PluginImpl.init(context = baseContext, instrumentation = false, firstMode = false)
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}
