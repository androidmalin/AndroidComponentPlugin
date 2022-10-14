package com.malin.plugin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View

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
            LayoutInflater.from(this).inflate(R.layout.plugin_activity, null)
        }
        setContentView(rootView)
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