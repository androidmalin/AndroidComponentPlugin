package com.malin.hook

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    private val handle: Handler = Handler(Looper.myLooper()!!)
    private val image: ImageView by lazy { findViewById(R.id.iv_) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        setContentView(R.layout.image)

        try {
            val actionBar = actionBar
            actionBar?.hide()
            val supportActionBar = supportActionBar
            supportActionBar?.hide()
        } catch (ignore: Throwable) {
        }

        findViewById<View>(R.id.root_layout).setOnClickListener {
            this.finish()
        }
        loadImage()
    }

    private fun loadImage() {
        Thread {
            val drawableImg = PluginResourceUtil.getPluginDrawableByName(
                context = applicationContext,
                pluginApkFileName = PLUGIN_APK_FILE_NAME,
                pluginPackageName = PLUGIN_PACKAGE_NAME,
                resourceName = PLUGIN_IMG_NAME,
                loadResourceType = 2
            )
            handle.post {
                image.setImageDrawable(drawableImg)
            }
        }.start()
    }

    companion object {
        private const val PLUGIN_PACKAGE_NAME = "com.malin.plugin"
        private const val PLUGIN_APK_FILE_NAME = "pluginapk-debug.apk"
        private const val PLUGIN_IMG_NAME = "plugin_img"
    }
}