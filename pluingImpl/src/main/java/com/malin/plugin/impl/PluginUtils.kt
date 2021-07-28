package com.malin.plugin.impl

import android.content.Context
import java.io.*


object PluginUtils {

    /**
     * 把Assets里面得文件复制到 /data/data/files 目录下
     */
    fun extractAssets(context: Context, sourceName: String) {
        val assetManager = context.assets
        var inputStream: InputStream? = null
        var outputStream: FileOutputStream? = null
        try {
            inputStream = assetManager.open(sourceName)
            val extractFile = context.getFileStreamPath(sourceName)
            outputStream = FileOutputStream(extractFile)
            val buffer = ByteArray(1024)
            var count: Int
            while (inputStream.read(buffer).also { count = it } > 0) {
                outputStream.write(buffer, 0, count)
            }
            outputStream.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            closeSilently(inputStream)
            closeSilently(outputStream)
        }
    }

    /**
     * 待加载插件经过opt优化之后存放odex得路径
     */
    fun getPluginOptDexDir(context: Context, packageName: String): File {
        return enforceDirExists(File(getPluginBaseDir(context, packageName), "odex"))
    }

    /**
     * 插件得lib库路径, 这个demo里面没有用
     */
    fun getPluginLibDir(context: Context, packageName: String): File {
        return enforceDirExists(File(getPluginBaseDir(context, packageName), "lib"))
    }

    private fun closeSilently(closeable: Closeable?) {
        try {
            closeable?.close() ?: return
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 需要加载得插件得基本目录 /data/data/<package>/files/plugin/</package>
     */
    private fun getPluginBaseDir(context: Context, packageName: String): File {
        val sBaseDir = enforceDirExists(context.getFileStreamPath("plugin"))
        return enforceDirExists(File(sBaseDir, packageName))
    }

    @Synchronized
    private fun enforceDirExists(sBaseDir: File): File {
        if (!sBaseDir.exists()) {
            val ret = sBaseDir.mkdir()
            if (!ret) {
                throw RuntimeException("create dir " + sBaseDir + "failed")
            }
        }
        return sBaseDir
    }
}