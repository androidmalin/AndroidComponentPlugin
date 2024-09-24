package com.malin.plugin

import android.annotation.SuppressLint
import android.app.UiModeManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.WindowCompat

@SuppressLint("SetTextI18n")
class PluginAppCompatActivity : BaseActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG:onCreate")
        val rootView: View = if (pluginInHostRunning) {
            // 插件apk在宿主中运行
            LayoutInflater.from(mContext).inflate(R.layout.plugin_activity, null)
        } else {
            // 插件作为独立的apk运行
            // "com.google.android.material.R\$style" 这个类, 在release编译后, 也会被替换为混淆后的类 o.d20
            // 在mapping.txt中 com.google.android.material.R$style -> o.d20
            val themeField = Class.forName("com.google.android.material.R\$style")
                .getDeclaredField("Theme_MaterialComponents_DayNight")
            themeField.isAccessible = true
            val themeObj = themeField[null]
            val theme = themeObj as Int
            // android studio 分析 pluginapk/build/outputs/apk/release/pluginapk-release.apk
            // 代码中的theme值为 2131755549(十进制) ==> 0x7f10021d(十六进制)==>style Theme.MaterialComponents.DayNight
            // aapt d resources pluginapk/build/outputs/apk/release/pluginapk-release.apk | grep "0x7f10021d"
            setTheme(theme)
            LayoutInflater.from(this).inflate(R.layout.plugin_activity, null)
        }

        setContentView(rootView)
        supportActionBar?.hide()
        lightStatus()
    }


    /**
     * https://stackoverflow.com/questions/71865491/change-the-color-of-status-bar-text-and-icon-in-api-30
     */
    @Suppress("DEPRECATION")
    private fun lightStatus() {
        val window = window ?: return
        val decorView = window.decorView
        val controller = WindowCompat.getInsetsController(window, decorView)
        if (pluginInHostRunning) {
            window.statusBarColor = Color.WHITE
            controller.isAppearanceLightStatusBars = true
        } else {
            val uiModeManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
            val nightMode = uiModeManager.nightMode == UiModeManager.MODE_NIGHT_YES
            if (nightMode) {
                window.statusBarColor = Color.BLACK
                controller.isAppearanceLightStatusBars = false
            } else {
                window.statusBarColor = Color.WHITE
                controller.isAppearanceLightStatusBars = true
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$TAG:onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$TAG:onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$TAG:onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$TAG:onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$TAG:onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$TAG:onDestroy")
    }

    companion object {
        private const val TAG = "PluginAppCompatActivity"
    }
}