package com.malin.hook

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.WindowCompat

/**
 * 宿主中未注册的Activity
 */
@SuppressLint("SetTextI18n", "Registered")
class TargetActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG:onCreate")
        setContentView(getRootLayout())
        lightStatus()
    }

    private fun getRootLayout(): View {
        val relativeLayout = RelativeLayout(this)
        relativeLayout.gravity = Gravity.CENTER

        val textView = TextView(this)
        textView.text = "宿主中未注册的TargetActivity,启动成功!"
        textView.setTextColor(Color.parseColor("#000000"))
        relativeLayout.addView(textView)
        return relativeLayout
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
        private const val TAG = "TargetActivity"
    }
}
