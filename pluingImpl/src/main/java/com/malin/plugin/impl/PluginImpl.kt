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

object PluginImpl {

    const val PLUGIN_APK_NAME = "pluginapk-debug.apk"
    private const val PLUGIN_DEX_NAME = "pluginapk-debug.dex"
    private val mSingleThreadExecutor = Executors.newSingleThreadExecutor()
    private val mHandler = Handler(Looper.getMainLooper())

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
        } catch (e: Throwable) {
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
            when {
                firstMode -> {
                    patchClassLoader(
                        baseDexClassLoader = context.classLoader,
                        apkFile = dexFile,
                        optDexFile = optDexFile
                    )
                }
                else -> {
                    patchClassLoader(
                        baseDexClassLoader = context.classLoader,
                        context = context,
                        apkFile = dexFile
                    )
                }
            }
            when {
                instrumentation -> {
                    hookPackageManager(context, StubAppCompatActivity::class.java)
                }
                else -> {
                    when {
                        Build.VERSION.SDK_INT >= 18 -> {
                            hookStartActivity(
                                context = context,
                                subActivityClass = StubAppCompatActivity::class.java,
                                isAppCompat = true
                            )
                        }
                        else -> {
                            mHandler.post {
                                hookStartActivity(
                                    context = context,
                                    subActivityClass = StubAppCompatActivity::class.java,
                                    isAppCompat = true
                                )
                            }
                        }
                    }
                }
            }
        }
        mSingleThreadExecutor.execute(patchClassLoaderRunnable)
    }
}