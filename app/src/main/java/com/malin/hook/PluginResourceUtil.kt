package com.malin.hook

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import dalvik.system.DexClassLoader

object PluginResourceUtil {

    fun getPluginDrawableByName(
        context: Context,
        pluginApkFileName: String,
        pluginPackageName: String,
        resourceName: String,
        loadResourceType: Int,
    ): Drawable? {
        val pluginApkPath = context.getFileStreamPath(pluginApkFileName).absolutePath
        val resources = ResourceUtil.createResources(context, pluginApkPath) ?: return null
        var resId = 0
        when (loadResourceType) {
            1 -> {
                resId = getResId(pluginPackageName = pluginPackageName, resName = resourceName)
            }
            2 -> {
                resId = getResId2(
                    resources = resources,
                    pluginPackageName = pluginPackageName,
                    resName = resourceName
                )
            }
            3 -> {
                resId = getResId3(
                    context = context,
                    pluginPath = pluginApkPath,
                    pluginPackageName = pluginPackageName,
                    resName = resourceName
                )
            }
            4 -> {
                resId =
                    getResId4(
                        context = context,
                        pluginPackageName = pluginPackageName,
                        resName = resourceName
                    )
            }
        }
        return ResourcesCompat.getDrawable(resources, resId, context.theme)
    }

    private fun getResId(pluginPackageName: String, resName: String): Int {
        try {
            val rDrawableClazz = Class.forName("$pluginPackageName.R\$drawable")
            val resField = rDrawableClazz.getDeclaredField(resName)
            return resField.getInt(null)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return 0
    }

    private fun getResId2(
        resources: Resources,
        pluginPackageName: String,
        resName: String,
    ): Int {
        return resources.getIdentifier(resName, "drawable", pluginPackageName)
    }

    private fun getResId3(
        context: Context,
        pluginPath: String,
        pluginPackageName: String,
        resName: String,
    ): Int {
        try {
            val optimizedDirectoryFile = context.getDir("dex", Context.MODE_PRIVATE)
            val dexClassLoader = DexClassLoader(
                pluginPath,
                optimizedDirectoryFile.path,
                null,
                ClassLoader.getSystemClassLoader()
            )
            val rDrawableClazz = dexClassLoader.loadClass("$pluginPackageName.R\$drawable")
            val resField = rDrawableClazz.getDeclaredField(resName)
            return resField.getInt(null)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return 0
    }

    private fun getResId4(context: Context, pluginPackageName: String, resName: String): Int {
        var drawableResId = 0
        try {
            drawableResId = context
                .classLoader
                .loadClass("$pluginPackageName.R\$drawable")
                .getDeclaredField(resName)
                .getInt(null)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return drawableResId
    }
}
