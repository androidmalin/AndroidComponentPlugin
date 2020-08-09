package com.malin.plugin.impl;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author weishu
 * 16/3/29
 */
public class PluginUtils {

    private static File sBaseDir;

    /**
     * 把Assets里面得文件复制到 /data/data/files 目录下
     */
    public static void extractAssets(Context context, String sourceName) {
        AssetManager am = context.getAssets();
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = am.open(sourceName);
            File extractFile = context.getFileStreamPath(sourceName);
            fos = new FileOutputStream(extractFile);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = is.read(buffer)) > 0) {
                fos.write(buffer, 0, count);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSilently(is);
            closeSilently(fos);
        }

    }

    /**
     * 待加载插件经过opt优化之后存放odex得路径
     */
    public static File getPluginOptDexDir(Context context, String packageName) {
        return enforceDirExists(new File(getPluginBaseDir(context, packageName), "odex"));
    }

    /**
     * 插件得lib库路径, 这个demo里面没有用
     */
    public static File getPluginLibDir(Context context, String packageName) {
        return enforceDirExists(new File(getPluginBaseDir(context, packageName), "lib"));
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    /**
     * 需要加载得插件得基本目录 /data/data/<package>/files/plugin/
     */
    private static File getPluginBaseDir(Context context, String packageName) {
        if (sBaseDir == null) {
            sBaseDir = context.getFileStreamPath("plugin");
            enforceDirExists(sBaseDir);
        }
        return enforceDirExists(new File(sBaseDir, packageName));
    }

    private static synchronized File enforceDirExists(File sBaseDir) {
        if (!sBaseDir.exists()) {
            boolean ret = sBaseDir.mkdir();
            if (!ret) {
                throw new RuntimeException("create dir " + sBaseDir + "failed");
            }
        }
        return sBaseDir;
    }
}
