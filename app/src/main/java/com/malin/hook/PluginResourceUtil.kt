package com.malin.hook

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.DisplayMetrics
import androidx.core.content.res.ResourcesCompat
import dalvik.system.DexClassLoader

object PluginResourceUtil {

    fun getPluginDrawableByName(
        context: Context,
        pluginApkFileName: String,
        pluginPackageName: String,
        resourceName: String,
        loadResourceType: Int
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

    @SuppressLint("DiscouragedPrivateApi", "PrivateApi")
    private fun getPluginResources(context: Context, pluginPath: String?): Resources? {
        try {
            // 1.调用assetManager.addAssetPath(pluginPath);
            val assetManager = AssetManager::class.java.newInstance()
            val addAssetPathMethod =
                assetManager.javaClass.getDeclaredMethod("addAssetPath", String::class.java)
            addAssetPathMethod.isAccessible = true
            addAssetPathMethod.invoke(assetManager, pluginPath)
            val superRes = context.resources
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // Resources#public void setImpl(ResourcesImpl impl) {}
                val displayAdjustmentsClazz = Class.forName("android.view.DisplayAdjustments")
                val displayAdjustmentsConstructor = displayAdjustmentsClazz.getDeclaredConstructor()
                displayAdjustmentsConstructor.isAccessible = true
                val displayAdjustmentsObj = displayAdjustmentsConstructor.newInstance()

                // new ResourcesImpl(AssetManager assets,DisplayMetrics metrics,
                // Configuration config, DisplayAdjustments displayAdjustments) {}
                val resourcesImplClazz = Class.forName("android.content.res.ResourcesImpl")
                val resourcesImplConstructor = resourcesImplClazz.getDeclaredConstructor(
                    AssetManager::class.java,
                    DisplayMetrics::class.java,
                    Configuration::class.java,
                    displayAdjustmentsClazz
                )
                resourcesImplConstructor.isAccessible = true
                val resourcesImplObj = resourcesImplConstructor.newInstance(
                    assetManager,
                    superRes.displayMetrics,
                    superRes.configuration,
                    displayAdjustmentsObj
                )

                // private Resources() {}
                val resourcesClazz = Class.forName("android.content.res.Resources")
                val resourcesConstructor = resourcesClazz.getDeclaredConstructor()
                resourcesConstructor.isAccessible = true
                val resourcesObj = resourcesConstructor.newInstance()

                // Resources
                // public void setImpl(ResourcesImpl impl) {}
                val setImplMethod = resourcesClazz.getDeclaredMethod("setImpl", resourcesImplClazz)
                setImplMethod.isAccessible = true

                // resources.setImpl(ResourcesImpl impl){}
                setImplMethod.invoke(resourcesObj, resourcesImplObj)
                resourcesObj as Resources
            } else {
                Resources(assetManager, superRes.displayMetrics, superRes.configuration)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return null
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
        resName: String
    ): Int {
        return resources.getIdentifier(resName, "drawable", pluginPackageName)
    }

    private fun getResId3(
        context: Context,
        pluginPath: String,
        pluginPackageName: String,
        resName: String
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
