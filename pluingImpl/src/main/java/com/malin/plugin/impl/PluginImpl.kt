package com.malin.plugin.impl

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.malin.plugin.impl.BaseDexClassLoaderHookHelper.patchClassLoader
import com.malin.plugin.impl.BaseDexClassLoaderHookHelperAnother.patchClassLoader
import com.malin.plugin.impl.HookActivity.hookPackageManager
import com.malin.plugin.impl.HookActivityWrapper.hookStartActivity
import com.malin.plugin.impl.HookInstrumentation.hookInstrumentation
import org.chickenhook.restrictionbypass.Unseal
import java.util.concurrent.Executors

class PluginImpl {
    private val mSingleThreadExecutor = Executors.newSingleThreadExecutor()
    private val mHandler = Handler(Looper.getMainLooper())

    private object Holder {
        val instance = PluginImpl()
    }

    fun init(context: Context, instrumentation: Boolean, firstMode: Boolean) {
        unseal()
        if (instrumentation) {
            hookInstrumentation(context)
        }
        installActivity(context, instrumentation, firstMode)
    }

    private fun unseal() {
        try {
            Unseal.unseal()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(PluginImpl::class.java.simpleName, "Unable to unseal hidden api access", e)
        }
    }

    private fun installActivity(context: Context, instrumentation: Boolean, firstMode: Boolean) {
        val patchClassLoaderRunnable = Runnable {

            //插件使用宿主的ClassLoader加载
            PluginUtils.extractAssets(context, PLUGIN_APK_NAME)
            val dexFile = context.getFileStreamPath(PLUGIN_APK_NAME)
            val optDexFile = context.getFileStreamPath(PLUGIN_DEX_NAME)
            if (firstMode) {
                patchClassLoader(context.classLoader, dexFile, optDexFile)
            } else {
                patchClassLoader(context.classLoader, context, dexFile)
            }
            if (instrumentation) {
                hookPackageManager(context, StubAppCompatActivity::class.java)
            } else {
                if (Build.VERSION.SDK_INT >= 18) {
                    hookStartActivity(context, StubAppCompatActivity::class.java, true)
                } else {
                    mHandler.post {
                        hookStartActivity(
                            context,
                            StubAppCompatActivity::class.java,
                            true
                        )
                    }
                }
            }
        }
        mSingleThreadExecutor.execute(patchClassLoaderRunnable)
    }

    companion object {
        const val PLUGIN_APK_NAME = "pluginapk-debug.apk"
        private const val PLUGIN_DEX_NAME = "pluginapk-debug.dex"
        val instance: PluginImpl
            get() = Holder.instance
    }
}