package com.malin.hook

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * 宿主中未注册的Activity
 */
@SuppressLint("SetTextI18n", "Registered")
class TargetActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG:onCreate")
        val relativeLayout = RelativeLayout(this)
        relativeLayout.gravity = Gravity.CENTER
        val textView = TextView(this)
        textView.text = "宿主中未注册的TargetActivity,启动成功!"
        relativeLayout.addView(textView)
        setContentView(relativeLayout)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "${TAG}:onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "${TAG}:onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "${TAG}:onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "${TAG}:onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "${TAG}:onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "${TAG}:onDestroy")
    }

    companion object {
        private const val TAG = "TargetActivity"
    }
}