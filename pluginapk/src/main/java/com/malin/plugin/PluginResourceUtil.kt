package com.malin.plugin

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources

object PluginResourceUtil {
    private var mResources: Resources? = null
    fun getResource(context: Context): Resources? {
        if (mResources == null) {
            mResources = loadResource(context)
            if (mResources == null) {
                throw NullPointerException("plugin Resources==null")
            }
        }
        return mResources
    }

    @SuppressLint("DiscouragedPrivateApi")
    private fun loadResource(context: Context): Resources? {
        try {
            val dexFile = context.getFileStreamPath("pluginapk-debug.apk")
            // 执行此addAssetPath(String path) 方法，能把插件的路径添加进去
            val assetManager = AssetManager::class.java.newInstance()
            val addAssetPathMethod =
                assetManager.javaClass.getDeclaredMethod("addAssetPath", String::class.java)
            addAssetPathMethod.isAccessible = true
            addAssetPathMethod.invoke(assetManager, dexFile.absolutePath)
            val resources = context.resources
            @Suppress("DEPRECATION")
            return Resources(assetManager, resources.displayMetrics, resources.configuration)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}