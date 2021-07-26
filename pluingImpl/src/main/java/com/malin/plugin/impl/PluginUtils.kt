package com.malin.plugin.impl

import android.content.Context
import java.io.*


object PluginUtils {
    private var sBaseDir: File? = null

    /**
     * 把Assets里面得文件复制到 /data/data/files 目录下
     */
    fun extractAssets(context: Context, sourceName: String?) {
        val am = context.assets
        var `is`: InputStream? = null
        var fos: FileOutputStream? = null
        try {
            `is` = am.open(sourceName!!)
            val extractFile = context.getFileStreamPath(sourceName)
            fos = FileOutputStream(extractFile)
            val buffer = ByteArray(1024)
            var count: Int
            while (`is`.read(buffer).also { count = it } > 0) {
                fos.write(buffer, 0, count)
            }
            fos.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            closeSilently(`is`)
            closeSilently(fos)
        }
    }

    /**
     * 待加载插件经过opt优化之后存放odex得路径
     */
    fun getPluginOptDexDir(context: Context?, packageName: String): File {
        return enforceDirExists(File(getPluginBaseDir(context, packageName), "odex"))
    }

    /**
     * 插件得lib库路径, 这个demo里面没有用
     */
    fun getPluginLibDir(context: Context, packageName: String): File {
        return enforceDirExists(File(getPluginBaseDir(context, packageName), "lib"))
    }

    private fun closeSilently(closeable: Closeable?) {
        if (closeable == null) return
        try {
            closeable.close()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 需要加载得插件得基本目录 /data/data/<package>/files/plugin/</package>
     */
    private fun getPluginBaseDir(context: Context?, packageName: String): File {
        if (sBaseDir == null) {
            sBaseDir = context?.getFileStreamPath("plugin")
            enforceDirExists(sBaseDir)
        }
        return enforceDirExists(File(sBaseDir, packageName))
    }

    @Synchronized
    private fun enforceDirExists(sBaseDir: File?): File {
        if (!sBaseDir!!.exists()) {
            val ret = sBaseDir.mkdir()
            if (!ret) {
                throw RuntimeException("create dir " + sBaseDir + "failed")
            }
        }
        return sBaseDir
    }
}