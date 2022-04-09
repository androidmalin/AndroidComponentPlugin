package com.malin.hook

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.asynclayoutinflater.view.AsyncLayoutInflater

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mIvPluginRes: ImageView

    /**
     * 属性委托使用反射，这样会增加一些性能开销。这种代价换来的是简洁的语法，可让您节省开发时间。
     */
    private val mBtnStartHostRegisterAct: Button by bindView(R.id.btn_start_host_register_act)

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AsyncLayoutInflater(this@MainActivity).inflate(
            R.layout.activity_main,
            null
        ) { view, _, _ ->
            setContentView(view)
            initView()
            initListener()
            initLoadPluginResourceImg()
        }
    }

    private fun initView() {
        mIvPluginRes = findViewById(R.id.iv_plugin_img)
    }

    /**
     * 扩展方法
     */
    private fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T> {
        return lazy { findViewById(res) }
    }

    private fun initListener() {
        mIvPluginRes.setOnClickListener(this)
        mBtnStartHostRegisterAct.setOnClickListener {
            startActivity(startActType = Type.HOST_EXIST_ACTIVITY, isApplicationContext = true)
        }
        findViewById<View>(R.id.btn_start_host_unregister_act).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_host_unregister_appcompat_act).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this)
    }

    private fun initLoadPluginResourceImg() {
        // SAM 转换
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
            R.id.btn_start_host_unregister_act -> {
                startActivity(
                    startActType = Type.HOST_UNREGISTER_ACTIVITY,
                    isApplicationContext = false
                )
            }
            R.id.btn_start_host_unregister_appcompat_act -> {
                startActivity(
                    startActType = Type.HOST_UNREGISTER_APPCOMPAT_ACTIVITY,
                    isApplicationContext = false
                )
            }
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

            Type.HOST_EXIST_ACTIVITY -> {
                intent = Intent(this, HostRegisterActivity::class.java)
            }

            Type.HOST_UNREGISTER_ACTIVITY -> {
                intent = Intent(this, TargetActivity::class.java)
            }

            Type.HOST_UNREGISTER_APPCOMPAT_ACTIVITY -> {
                intent = Intent(this, TargetAppCompatActivity::class.java)
            }

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
        private const val PLUGIN_APK_FILE_NAME = "pluginapk-debug.apk"
        private const val PLUGIN_IMG_NAME = "plugin_img"
    }

    private enum class Type {
        HOST_UNREGISTER_ACTIVITY,
        HOST_UNREGISTER_APPCOMPAT_ACTIVITY,
        PLUGIN_ACTIVITY,
        PLUGIN_APPCOMPAT_ACTIVITY,
        HOST_EXIST_ACTIVITY
    }
}
