package com.malin.hook

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mIvPluginRes: ImageView by bindView(R.id.iv_plugin_img)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        lightStatus()
        initListener()
        initLoadPluginResourceImg()
    }

    private fun initView() {
        supportActionBar?.hide()
    }

    private fun lightStatus() {
        val localWindow = window ?: return
        val localDecorView = localWindow.decorView
        val controller = WindowCompat.getInsetsController(localWindow, localDecorView)
        controller.isAppearanceLightStatusBars = true
    }

    private fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T> {
        return lazy { findViewById(res) }
    }

    private fun initListener() {
        findViewById<View>(R.id.btn_start_host_register_act).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_host_unregister_act).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_host_unregister_appcompat_act).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this)
    }

    /**
     * 宿主中使用插件APK中的资源
     */
    private fun initLoadPluginResourceImg() {
        findViewById<View>(R.id.btn_load_plugin_img).setOnClickListener {
            val drawableImg = PluginResourceUtil.getPluginDrawableByName(
                context = applicationContext,
                pluginApkFileName = PLUGIN_APK_FILE_NAME,
                pluginPackageName = PLUGIN_PACKAGE_NAME,
                resourceName = PLUGIN_IMG_NAME,
                loadResourceType = 2
            )
            mIvPluginRes.setImageDrawable(drawableImg)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {

            // 启动宿主中注册的 HostRegisterActivity
            R.id.btn_start_host_register_act -> {
                startActivity(
                    startActType = LaunchTargetActType.HOST_EXIST_ACTIVITY,
                    isApplicationContext = true
                )
            }

            // 启动宿主中未注册的 TargetActivity
            R.id.btn_start_host_unregister_act -> {
                startActivity(
                    startActType = LaunchTargetActType.HOST_UNREGISTER_ACTIVITY,
                    isApplicationContext = false
                )
            }

            // 启动宿主中未注册的 TargetAppCompatActivity
            R.id.btn_start_host_unregister_appcompat_act -> {
                startActivity(
                    startActType = LaunchTargetActType.HOST_UNREGISTER_APPCOMPAT_ACTIVITY,
                    isApplicationContext = false
                )
            }

            // 启动插件APK中的 PluginActivity
            R.id.btn_start_plugin_apk_activity -> {
                startActivity(
                    startActType = LaunchTargetActType.PLUGIN_ACTIVITY,
                    isApplicationContext = false
                )
            }

            // 启动插件APK中的 PluginAppCompatActivity
            R.id.btn_start_plugin_apk_appcompat_activity -> {
                startActivity(
                    startActType = LaunchTargetActType.PLUGIN_APPCOMPAT_ACTIVITY,
                    isApplicationContext = false
                )
            }
        }
    }


    private fun startActivity(startActType: LaunchTargetActType, isApplicationContext: Boolean) {

        val intent: Intent = when (startActType) {

            // 启动 宿主中注册的 [HostRegisterActivity]
            LaunchTargetActType.HOST_EXIST_ACTIVITY -> {
                Intent(this, HostRegisterActivity::class.java)
            }

            // 启动 宿主中未注册的 [TargetActivity]
            LaunchTargetActType.HOST_UNREGISTER_ACTIVITY -> {
                Intent(this, TargetActivity::class.java)
            }

            // 启动 宿主中未注册的 [TargetAppCompatActivity]
            LaunchTargetActType.HOST_UNREGISTER_APPCOMPAT_ACTIVITY -> {
                Intent(this, TargetAppCompatActivity::class.java)
            }

            // 启动 插件APK中的 PluginActivity
            LaunchTargetActType.PLUGIN_ACTIVITY -> {
                Intent().apply {
                    component = ComponentName(PLUGIN_PACKAGE_NAME, PLUGIN_ACTIVITY_NAME)
                }
            }

            // 启动 插件APK中的 PluginAppCompatActivity
            LaunchTargetActType.PLUGIN_APPCOMPAT_ACTIVITY -> {
                Intent().apply {
                    component = ComponentName(PLUGIN_PACKAGE_NAME, PLUGIN_APPCOMPAT_ACTIVITY_NAME)
                }
            }
        }

        when {
            // 启动的上下文是 ApplicationContext
            isApplicationContext -> {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                applicationContext.startActivity(intent)
            }

            // 启动的上下文不是 ApplicationContext
            else -> {
                this@MainActivity.startActivity(intent)
            }
        }
    }

    private companion object {
        /**
         * 插件apk的文件名称
         * 位置: app/src/main/assets/pluginapk-debug.apk
         */
        private const val PLUGIN_APK_FILE_NAME = "pluginapk-debug.apk"

        /**
         * 插件apk的包名
         * 插件apk的包名和宿主包名一致,原理参考如下博客
         * https://juejin.cn/post/6844903875284058119
         */
        private const val PLUGIN_PACKAGE_NAME = "com.malin.hook"

        /**
         * 插件apk中插件PluginActivity的类名
         * 位置: pluginapk/src/main/java/com/malin/plugin/PluginActivity.kt
         */
        private const val PLUGIN_ACTIVITY_NAME = "com.malin.plugin.PluginActivity"

        /**
         * 插件apk中插件PluginAppCompatActivity的类名
         * 位置: pluginapk/src/main/java/com/malin/plugin/PluginAppCompatActivity.kt
         */
        private const val PLUGIN_APPCOMPAT_ACTIVITY_NAME =
            "com.malin.plugin.PluginAppCompatActivity"

        /**
         * 插件apk的一种图片
         * 位置: pluginapk/src/main/res/drawable/plugin_img.png
         */
        private const val PLUGIN_IMG_NAME = "plugin_img"
    }


    private enum class LaunchTargetActType {
        /**
         * 宿主中注册的 [HostRegisterActivity]
         */
        HOST_EXIST_ACTIVITY,

        /**
         * 宿主中未注册的 [TargetActivity]
         */
        HOST_UNREGISTER_ACTIVITY,

        /**
         * 宿主中未注册的 [TargetAppCompatActivity]
         */
        HOST_UNREGISTER_APPCOMPAT_ACTIVITY,

        /**
         * 插件APK中的 PluginActivity
         */
        PLUGIN_ACTIVITY,

        /**
         * 插件APK中的 PluginAppCompatActivity
         */
        PLUGIN_APPCOMPAT_ACTIVITY,
    }
}
