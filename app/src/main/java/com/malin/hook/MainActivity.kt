package com.malin.hook

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * https://developer.android.com/kotlin/common-patterns?hl=zh-cn
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * lateinit 推迟 View 的属性初始化。
     * 你可以使用 lateinit 推迟属性初始化。使用 lateinit 时，你应尽快初始化属性。
     * 通过 lateinit 关键字，可以避免在构建对象时初始化属性。
     * 如果在属性进行初始化之前对其进行了引用，Kotlin 会抛出 UninitializedPropertyAccessException，因此请务必尽快初始化属性。
     */
    private lateinit var mImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "$TAG:onCreate")
        initView()
        initListener()
        initLoadPluginResourceImg()
    }

    private fun initView() {
        mImageView = findViewById(R.id.iv_image_plugin)
    }

    private fun initListener() {
        mImageView.setOnClickListener(this)
        findViewById<View>(R.id.btn_start).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_appcompat).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_inner).setOnClickListener(this)
    }

    /**
     * 注意Kotlin 并没有new 关键字。 不能通过 new关键字来 创建嵌套类、内部类与匿名内部类的类实例
     *
     * Button 对象包含一个 setOnClickListener() 函数，该函数接受 OnClickListener 的实现。
     *
     * OnClickListener 具有单一抽象方法 onClick()，您必须实现该方法。
     * 因为 setOnClickListener() 始终接受 OnClickListener 作为参数，
     * 又因为 OnClickListener 始终都有相同的单一抽象方法，
     * 所以此实现在 Kotlin 中可以使用匿名函数来表示。
     * 此过程称为单一抽象方法转换，简称 SAM 转换。
     * https://kotlinlang.org/docs/java-interop.html#sam-conversions
     *
     * Kotlin中的单个感叹号
     * https://stackoverflow.com/questions/43826699/single-exclamation-mark-in-kotlin
     */
    private fun initLoadPluginResourceImg() {
        findViewById<View>(R.id.btn_load_img).setOnClickListener {
            val drawable = PluginResourceUtil.getPluginDrawableByName(
                context = this,
                pluginApkName = "pluginapk-debug.apk",
                pluginPackageName = "com.malin.plugin",
                resourceName = "plugin_img",
                loadResourceType = 1
            )
            mImageView.setImageDrawable(drawable)
        }
    }

    /**
     * https://kotlinlang.org/docs/control-flow.html#when-expression
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_start -> {
                startActivity(type = Type.HOST_UNREGISTER_ACTIVITY, isContext = false)
            }
            R.id.btn_start_appcompat -> {
                startActivity(type = Type.HOST_UNREGISTER_APPCOMPAT_ACTIVITY, isContext = false)
            }
            R.id.btn_start_plugin_apk_activity -> {
                startActivity(type = Type.PLUGIN_ACTIVITY, isContext = false)
            }
            R.id.btn_start_plugin_apk_appcompat_activity -> {
                startActivity(type = Type.PLUGIN_APPCOMPAT_ACTIVITY, isContext = false)
            }
            R.id.btn_start_inner -> {
                startActivity(type = Type.HOST_EXIST_ACTIVITY, isContext = true)
            }
        }
    }

    /**
     * https://www.kotlincn.net/docs/reference/ranges.html
     */
    private fun startActivity(type: Type, isContext: Boolean) {
        lateinit var intent: Intent
        when (type) {

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

            Type.HOST_EXIST_ACTIVITY -> {
                intent = Intent(this, SecondActivity::class.java)
            }
        }
        if (isContext) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext.startActivity(intent)
        } else {
            startActivity(intent)
        }
    }

    /**
     * 伴生对象提供了一种机制，用于定义在概念上与某个类型相关但不与某个特定对象关联的变量或函数。
     * 伴生对象类似于对变量和方法使用 Java 的 static 关键字。
     * 在以下代码中，TAG 是一个 String 常量。
     * 你不需要为每个 MainActivity 实例定义一个唯一的 String 实例，
     * 因此你应在伴生对象中定义它：
     * 你可以在文件的顶级定义 TAG，但文件中可能有大量的变量、函数和类也是在顶级定义的。
     * 伴生对象有助于连接变量、函数和类定义，而无需引用该类的任何特定实例。
     */
    companion object {
        private const val TAG = "MainActivity"
        private const val PLUGIN_PACKAGE_NAME = "com.malin.plugin"
        private const val PLUGIN_ACTIVITY_NAME = "com.malin.plugin.PluginActivity"
        private const val PLUGIN_APPCOMPAT_ACTIVITY_NAME =
            "com.malin.plugin.PluginAppCompatActivity"
    }

    enum class Type {
        HOST_UNREGISTER_ACTIVITY,
        HOST_UNREGISTER_APPCOMPAT_ACTIVITY,
        PLUGIN_ACTIVITY,
        PLUGIN_APPCOMPAT_ACTIVITY,
        HOST_EXIST_ACTIVITY
    }
}