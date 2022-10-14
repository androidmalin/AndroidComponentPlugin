package com.malin.plugin

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper

open class BaseActivity : AppCompatActivity() {

    protected var mContext: Context? = null
    protected var pluginInHostRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var hostAppClazz: Class<*>? = null
        try {
            hostAppClazz = Class.forName("com.malin.hook.MApplication")
        } catch (ignore: Throwable) {
        }
        pluginInHostRunning = hostAppClazz != null
        if (pluginInHostRunning) {
            // 插件apk在宿主中运行
            val resource = PluginResourceUtil.getResource(application)
            mContext = ContextThemeWrapper(baseContext, 0)
            val contextClazz: Class<*> = mContext?.javaClass ?: return
            try {
                val mResourcesField = contextClazz.getDeclaredField("mResources")
                mResourcesField.isAccessible = true
                mResourcesField[mContext] = resource
                val rClazz = Class.forName("com.google.android.material.R\$style")
                val themeField = rClazz.getDeclaredField("Theme_MaterialComponents_DayNight")
                themeField.isAccessible = true
                val themeObj = themeField[null]
                if (themeObj != null) {
                    val theme = themeObj as Int
                    val mThemeResourceField = contextClazz.getDeclaredField("mThemeResource")
                    mThemeResourceField.isAccessible = true
                    mThemeResourceField[mContext] = theme
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        } else {
            // 插件作为独立的apk运行
            mContext = null
        }
    }
}
