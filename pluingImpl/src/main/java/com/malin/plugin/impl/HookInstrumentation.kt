package com.malin.plugin.impl

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.ResolveInfoFlags
import android.content.pm.ResolveInfo
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.text.TextUtils
import androidx.annotation.Keep
import dalvik.system.DexClassLoader
import java.io.File

/**
 * Activity插件化 Hook Instrumentation
 */
@SuppressLint("PrivateApi", "StaticFieldLeak")
object HookInstrumentation {
    private const val TARGET_INTENT_CLASS = "target_intent_class"

    // 插件是否使用单独的classloader
    private const val USE_SINGLE_CLASS_LOADER = false

    private lateinit var mContext: Context

    @SuppressLint("DiscouragedPrivateApi")
    fun hookInstrumentation(context: Context) {
        // 1.from ContextImpl get mMainThread field value (ActivityThread obj)
        // 2.from ActivityThread get mInstrumentation field (Instrumentation obj)
        // 3.replace ActivityThread  mInstrumentation field value use make a Instrumentation instance
        try {
            mContext = context
            // 1.ContextImpl-->mMainThread
            // package android.app
            // class ContextImpl
            val contextImplClazz = Class.forName("android.app.ContextImpl")

            // final @NonNull ActivityThread mMainThread;
            val mMainThreadField =
                contextImplClazz.getDeclaredField("mMainThread").also { it.isAccessible = true }

            // 2.get ActivityThread Object from ContextImpl
            val activityThreadObj = mMainThreadField.get(context)

            // 3.mInstrumentation Object
            val activityThreadClazz = Class.forName("android.app.ActivityThread")

            // Instrumentation mInstrumentation;
            val mInstrumentationField = activityThreadClazz.getDeclaredField("mInstrumentation")
                .also { it.isAccessible = true }
            val mInstrumentationObj =
                mInstrumentationField.get(activityThreadObj) as Instrumentation

            // 4.reset set value
            mInstrumentationField[activityThreadObj] = InstrumentationProxy(
                mInstrumentationObj,
                context.packageManager,
                StubAppCompatActivity::class.java
            )
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    @SuppressLint("DiscouragedPrivateApi")
    private class InstrumentationProxy(
        private val mInstrumentation: Instrumentation,
        private val mPackageManager: PackageManager,
        private val mStubActivityClazz: Class<*>,
    ) : Instrumentation() {
        /**
         * android16-android31
         * Instrumentation的execStartActivity方法激活Activity生命周期
         * 使用占坑的Activity来通过AMS的验证.
         */
        @Keep
        @Suppress("UNUSED")
        @SuppressLint("QueryPermissionsNeeded")
        fun execStartActivity(
            who: Context?,
            contextThread: IBinder?,
            token: IBinder?,
            target: Activity?,
            intent: Intent,
            requestCode: Int,
            options: Bundle?,
        ): ActivityResult? {
            var resolveInfoList: List<ResolveInfo>? = null
            try {
                var flags = 0
                if (Build.VERSION.SDK_INT >= 23) {
                    flags = PackageManager.MATCH_ALL
                }
                resolveInfoList = if (Build.VERSION.SDK_INT >= 33) {
                    mPackageManager.queryIntentActivities(
                        intent,
                        ResolveInfoFlags.of(flags.toLong())
                    )
                } else {
                    @Suppress("DEPRECATION")
                    mPackageManager.queryIntentActivities(intent, flags)
                }
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
            var finalIntent = intent
            if (resolveInfoList.isNullOrEmpty()) {
                // 目标Activity没有在AndroidManifest.xml中注册的话,将目标Activity的ClassName保存到桩Intent中.
                finalIntent = Intent(who, mStubActivityClazz)
                // public class Intent implements Parcelable;
                // Intent类已经实现了Parcelable接口
                finalIntent.putExtra(TARGET_INTENT_CLASS, intent)
            }
            try {
                // 通过反射调用execStartActivity方法,这样就可以用桩Activity通过AMS的验证.
                val execStartActivityMethod = Instrumentation::class.java.getDeclaredMethod(
                    "execStartActivity",
                    Context::class.java,
                    IBinder::class.java,
                    IBinder::class.java,
                    Activity::class.java,
                    Intent::class.java,
                    Int::class.javaPrimitiveType,
                    Bundle::class.java
                ).also { it.isAccessible = true }
                return execStartActivityMethod.invoke(
                    mInstrumentation,
                    who,
                    contextThread,
                    token,
                    target,
                    finalIntent,
                    requestCode,
                    options
                ) as? ActivityResult
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * just for android-15
         * Instrumentation#execStartActivity()方法参数和其他版本不同, 需要单独适配
         * Instrumentation的execStartActivity方法激活Activity生命周期
         * 使用占坑的Activity来通过AMS的验证.
         * http://androidxref.com/4.0.3_r1/xref/frameworks/base/core/java/android/app/Instrumentation.java
         */
        @Keep
        @Suppress("UNUSED")
        @SuppressLint("QueryPermissionsNeeded")
        fun execStartActivity(
            who: Context?,
            contextThread: IBinder?,
            token: IBinder?,
            target: Activity?,
            intent: Intent,
            requestCode: Int,
        ): ActivityResult? {
            if (Build.VERSION.SDK_INT != 15) return null
            var resolveInfoList: List<ResolveInfo>? = null
            try {
                val flags = 0
                resolveInfoList = if (Build.VERSION.SDK_INT >= 33) {
                    mPackageManager.queryIntentActivities(
                        intent,
                        ResolveInfoFlags.of(flags.toLong())
                    )
                } else {
                    @Suppress("DEPRECATION")
                    mPackageManager.queryIntentActivities(intent, flags)
                }
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
            var finalIntent = intent
            if (resolveInfoList.isNullOrEmpty()) {
                // 目标Activity没有在AndroidManifest.xml中注册的话,将目标Activity的ClassName保存到桩Intent中.
                finalIntent = Intent(who, mStubActivityClazz)
                // public class Intent implements Parcelable;
                // Intent类已经实现了Parcelable接口
                finalIntent.putExtra(TARGET_INTENT_CLASS, intent)
            }
            try {
                // just for android-15
                // 通过反射调用execStartActivity方法,这样就可以用桩Activity通过AMS的验证.
                val execStartActivityMethod = Instrumentation::class.java.getDeclaredMethod(
                    "execStartActivity",
                    Context::class.java,
                    IBinder::class.java,
                    IBinder::class.java,
                    Activity::class.java,
                    Intent::class.java,
                    Int::class.javaPrimitiveType
                ).also { it.isAccessible = true }
                return execStartActivityMethod.invoke(
                    mInstrumentation,
                    who,
                    contextThread,
                    token,
                    target,
                    finalIntent,
                    requestCode
                ) as? ActivityResult
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * Instrumentation的newActivity方法,用类加载器来创建Activity实例
         * 还原目标Activity.
         */
        @Keep
        @Throws(
            InstantiationException::class,
            IllegalAccessException::class,
            ClassNotFoundException::class
        )
        override fun newActivity(
            classLoader: ClassLoader,
            className: String,
            intent: Intent,
        ): Activity {
            val pluginIntent: Intent? = if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra(TARGET_INTENT_CLASS, Intent::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra(TARGET_INTENT_CLASS)
            }
            val pluginIntentClassNameExist = pluginIntent != null && !TextUtils.isEmpty(
                pluginIntent.component?.className
            )

            // 1.className
            val finalClassName =
                if (pluginIntentClassNameExist) pluginIntent?.component?.className else className

            // 2.intent
            val finalIntent = if (pluginIntentClassNameExist) pluginIntent else intent

            // 3.classLoader
            val finalClassLoader: ClassLoader =
                if (USE_SINGLE_CLASS_LOADER && pluginIntentClassNameExist) {
                    val pluginDexFile =
                        mContext.getFileStreamPath(PluginImpl.PLUGIN_APK_NAME)
                    CustomClassLoader.getPluginClassLoader(
                        mContext,
                        pluginDexFile,
                        "com.malin.plugin"
                    )
                } else {
                    classLoader
                }
            return if (Build.VERSION.SDK_INT >= 28) {
                mInstrumentation.newActivity(finalClassLoader, finalClassName, finalIntent)
            } else {
                super.newActivity(finalClassLoader, finalClassName, finalIntent)
            }
        }
    }

    private class CustomClassLoader(
        dexPath: String,
        optimizedDirectory: String,
        libraryPath: String,
        parent: ClassLoader,
    ) : DexClassLoader(dexPath, optimizedDirectory, libraryPath, parent) {
        companion object {
            /**
             * 获取插件的ClassLoader,能够加载指定的插件中的类
             */
            fun getPluginClassLoader(
                context: Context,
                plugin: File,
                packageName: String,
            ): CustomClassLoader {
                // String dexPath, String optimizedDirectory, String librarySearchPath, ClassLoader parent
                return CustomClassLoader(
                    plugin.path,
                    PluginUtils.getPluginOptDexDir(
                        context = context,
                        packageName = packageName
                    ).path,
                    PluginUtils.getPluginLibDir(context = context, packageName = packageName).path,
                    context.classLoader
                )
            }
        }
    }
}
