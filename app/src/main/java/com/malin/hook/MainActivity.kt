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
    private lateinit var mIvPluginRes: ImageView
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
     * 带有标记的类型!称为平台类型，它是一种来自 Java的类型，
     * 因此很可能是null. 这是 Kotlin 编译器在调用 Java 时默认推断的内容
     * https://stackoverflow.com/questions/43826699/single-exclamation-mark-in-kotlin
     */
    private fun initLoadPluginResourceImg() {
        findViewById<View>(R.id.btn_load_plugin_img).setOnClickListener {
            val drawableImg = PluginResourceUtil.getPluginDrawableByName(
                context = applicationContext,
                pluginApkFileName = PLUGIN_APK_FILE_NAME,
                pluginPackageName = PLUGIN_PACKAGE_NAME,
                resourceName = PLUGIN_IMG_NAME,
                loadResourceType = 1
            )
            mIvPluginRes.setImageDrawable(drawableImg)
        }
    }

    /**
     * https://kotlinlang.org/docs/control-flow.html#when-expression
     */
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
     * when
     * https://www.kotlincn.net/docs/reference/control-flow.html
     */
    private fun startActivity(startActType: Type, isApplicationContext: Boolean) {
        lateinit var intent: Intent
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
     * 伴生对象提供了一种机制，用于定义在概念上与某个类型相关但不与某个特定对象关联的变量或函数。
     * 伴生对象类似于对变量和方法使用 Java 的 static 关键字。
     * 在以下代码中，PLUGIN_PACKAGE_NAME 是一个 String 常量。
     * 你不需要为每个 MainActivity 实例定义一个唯一的 String 实例，
     * 因此你应在伴生对象中定义它：
     * 你可以在文件的顶级定义 PLUGIN_PACKAGE_NAME，但文件中可能有大量的变量、函数和类也是在顶级定义的。
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