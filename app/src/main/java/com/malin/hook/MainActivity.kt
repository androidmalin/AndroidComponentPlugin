package com.malin.hook

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    private fun initView() {
        mImageView = findViewById(R.id.iv_image_plugin)
    }

    private fun initListener() {
        mImageView?.setOnClickListener(this)
        findViewById<View>(R.id.btn_start).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_appcompat).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_load_img).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_inner).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_start -> {
                startActivity(type = 1, context = false)
            }
            R.id.btn_start_appcompat -> {
                startActivity(type = 2, context = false)
            }
            R.id.btn_start_plugin_apk_activity -> {
                startActivity(type = 3, context = false)
            }
            R.id.btn_start_plugin_apk_appcompat_activity -> {
                startActivity(type = 4, context = false)
            }
            R.id.btn_load_img -> {
                val drawable = PluginResourceUtil.getPluginDrawableByName(
                    context = this,
                    pluginApkName = "pluginapk-debug.apk",
                    pluginPackageName = "com.malin.plugin",
                    sourceName = "plugin_img"
                )
                mImageView?.setImageDrawable(drawable)
            }
            R.id.btn_start_inner -> {
                startActivity(5, false)
            }
        }
    }

    @Suppress("SameParameterValue")
    private fun startActivity(type: Int, context: Boolean) {
        if (type < 1 || type > 5) {
            return
        }
        var intent: Intent? = null
        when (type) {
            1 -> {
                intent = Intent(this, TargetActivity::class.java)
            }
            2 -> {
                intent = Intent(this, TargetAppCompatActivity::class.java)
            }
            3 -> {
                intent = Intent()
                intent.component =
                    ComponentName("com.malin.plugin", "com.malin.plugin.PluginActivity")
            }
            4 -> {
                intent = Intent()
                intent.component =
                    ComponentName("com.malin.plugin", "com.malin.plugin.PluginAppCompatActivity")
            }
            5 -> {
                intent = Intent(this, SecondActivity::class.java)
            }
        }
        if (context) {
            intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext.startActivity(intent)
        } else {
            startActivity(intent)
        }
    }
}