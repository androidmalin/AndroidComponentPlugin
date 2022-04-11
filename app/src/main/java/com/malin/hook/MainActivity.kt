package com.malin.hook

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }catch (e:Exception){
            e.printStackTrace()
        }
        setContentView(R.layout.activity_main)
        initListener()
        try {
            val actionBar = actionBar
            actionBar?.hide()
            val supportActionBar = supportActionBar
            supportActionBar?.hide()
        } catch (ignore: Throwable) {
        }
    }

    private fun initListener() {
        findViewById<View>(R.id.btn_start_plugin_apk_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_start_plugin_apk_activity -> {
                this.startActivity(Intent(this, ImageActivity::class.java))
            }
            R.id.btn_start_plugin_apk_appcompat_activity -> {
                val intent = Intent()
                intent.component =
                    ComponentName(PLUGIN_PACKAGE_NAME, PLUGIN_APPCOMPAT_ACTIVITY_NAME)
                this.startActivity(intent)
            }
        }
    }

    /**
     * companion object
     *
     * 伴生对象提供了一种机制，用于定义在概念上与某个类型相关但不与某个特定对象关联的变量或函数。
     * 伴生对象类似于对变量和方法使用 Java 的 static 关键字。
     * 伴生对象有助于连接变量、函数和类定义，而无需引用该类的任何特定实例。
     */
    private companion object {
        private const val PLUGIN_PACKAGE_NAME = "com.malin.plugin"
        private const val PLUGIN_ACTIVITY_NAME = "com.malin.plugin.PluginActivity"
        private const val PLUGIN_APPCOMPAT_ACTIVITY_NAME =
            "com.malin.plugin.PluginAppCompatActivity"
    }

    private enum class Type {
        PLUGIN_ACTIVITY,
        PLUGIN_APPCOMPAT_ACTIVITY,
    }
}
