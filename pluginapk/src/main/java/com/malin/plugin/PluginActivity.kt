package com.malin.plugin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.WindowCompat

@SuppressLint("SetTextI18n")
class PluginActivity : Activity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG:onCreate")
        val linearLayout = LinearLayout(this)
        linearLayout.gravity = Gravity.CENTER
        linearLayout.orientation = LinearLayout.VERTICAL

        var hostAppClazz: Class<*>? = null
        try {
            hostAppClazz = Class.forName("com.malin.hook.MApplication")
        } catch (ignore: Throwable) {
        }
        val pluginInHostRunning = hostAppClazz != null

        if (pluginInHostRunning) {
            val imageView = ImageView(this)
            val resource: Resources? = PluginResourceUtil.getResource(application)
            if (resource != null) {
                @Suppress("DEPRECATION")
                val imgDrawable = resource.getDrawable(R.drawable.plugin_img)
                imageView.setImageDrawable(imgDrawable)
            }
            val layoutParams = LinearLayout.LayoutParams(100.dp2px(), 100.dp2px())
            linearLayout.addView(imageView, layoutParams)

            val textView = TextView(this)
            textView.text =
                "插件APK使用自己的Resources加载图片\n 启动插件APK中的PluginActivity,成功!"
            textView.setTextColor(Color.parseColor("#000000"))
            textView.gravity = Gravity.CENTER
            linearLayout.addView(textView)
        } else {
            val textView = TextView(this)
            textView.text = "启动插件APK中的PluginActivity,成功!"
            textView.gravity = Gravity.CENTER
            linearLayout.addView(textView)
        }
        setContentView(linearLayout)
        lightStatus()
    }

    private fun lightStatus() {
        val window = window ?: return
        val decorView = window.decorView
        val controller = WindowCompat.getInsetsController(window, decorView)
        controller.isAppearanceLightStatusBars = true
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
        private const val TAG = "PluginActivity"
    }

    private fun Number.dp2px(): Int {
        val f = toFloat()
        val scale: Float = Resources.getSystem().displayMetrics.density
        return (f * scale + 0.5f).toInt()
    }
}