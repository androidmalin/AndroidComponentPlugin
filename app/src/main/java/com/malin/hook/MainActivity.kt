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
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        findViewById<View>(R.id.btn_start_plugin_apk_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_start_plugin_apk_activity -> {
                startActivity(startActType = Type.PLUGIN_ACTIVITY, isApplicationContext = false)
            }
            R.id.btn_start_plugin_apk_appcompat_activity -> {
                startActivity(
                    startActType = Type.PLUGIN_APPCOMPAT_ACTIVITY,
                    isApplicationContext = false
                )
            }
        }
    }

    /**
     * 每个条件分支都隐式地返回其最后一行的表达式的结果，因此无需使用 return 关键字。
     * 由于全部三个分支的结果都是 Intent 类型，因此 when 表达式的结果也是 Intent 类型。
     */
    private fun startActivity(startActType: Type, isApplicationContext: Boolean) {
        // 1.延时初始化
        lateinit var intent: Intent

        // 2.条件表达式
        when (startActType) {
            Type.PLUGIN_ACTIVITY -> {
                intent = Intent()
                intent.component =
                    ComponentName(PLUGIN_PACKAGE_NAME, PLUGIN_ACTIVITY_NAME)
            }

            Type.PLUGIN_APPCOMPAT_ACTIVITY -> {
                intent = Intent()
                intent.component =
                    ComponentName(PLUGIN_PACKAGE_NAME, PLUGIN_APPCOMPAT_ACTIVITY_NAME)
            }
        }

        when {
            isApplicationContext -> {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                applicationContext.startActivity(intent)
            }
            else -> {
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
