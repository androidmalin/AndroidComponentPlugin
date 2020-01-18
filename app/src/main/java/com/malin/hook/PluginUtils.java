package com.malin.hook;

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
class PluginUtils {

    private static File sBaseDir;

    public interface CopyCallback {
        void onSuccess();

        void onFail();
    }

    /**
     * 把Assets里面得文件复制到 /data/data/files 目录下
     */
    static void extractAssets(Context context, String sourceName) {
        extractAssets(context, sourceName, null);
    }

    /**
     * 把Assets里面得文件复制到 /data/data/files 目录下
     */
    static void extractAssets(Context context, String sourceName, CopyCallback copyCallback) {
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
            if (copyCallback != null) {
                copyCallback.onSuccess();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (copyCallback != null) {
                copyCallback.onFail();
            }
        } finally {
            closeSilently(is);
            closeSilently(fos);
        }
    }

    /**
     * 待加载插件经过opt优化之后存放odex得路径
     */
    static File getPluginOptDexDir(String packageName) {
        return enforceDirExists(new File(getPluginBaseDir(packageName), "odex"));
    }

    /**
     * 插件得lib库路径, 这个demo里面没有用
     */
    static File getPluginLibDir(String packageName) {
        return enforceDirExists(new File(getPluginBaseDir(packageName), "lib"));
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
    private static File getPluginBaseDir(String packageName) {
        if (sBaseDir == null) {
            sBaseDir = MApplication.getInstance().getFileStreamPath("plugin");
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
