package com.malin.plugin.impl

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * AppCompatActivity类型的桩Activity
 */
class StubAppCompatActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = "StubAppCompatActivity"
        setContentView(textView)
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
        private const val TAG = "StubAppCompatActivity"
    }
}
