package com.malin.hook;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

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
     * 把Assets里面的文件复制到 /data/data/files 目录下
     */
    static void extractAssets(Context context, String sourceName) {
        extractAssets(context, sourceName, null);
    }

    /**
     * 把Assets里面的文件复制到 /data/data/files 目录下
     * https://juejin.im/post/5be3da465188254ad2138885
     */
    static void extractAssets(Context context, String sourceName, CopyCallback copyCallback) {
        AssetManager assets = context.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assets.open(sourceName);
            Source source = Okio.source(inputStream);
            BufferedSource buffer = Okio.buffer(source);
            buffer.readAll(Okio.sink(context.getFileStreamPath(sourceName)));
            if (copyCallback != null) {
                copyCallback.onSuccess();
            }
        } catch (Throwable e) {
            e.printStackTrace();
            if (copyCallback != null) {
                copyCallback.onFail();
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 待加载插件经过opt优化之后存放odex的路径
     */
    static File getPluginOptDexDir(String packageName) {
        return enforceDirExists(new File(getPluginBaseDir(packageName), "odex"));
    }

    /**
     * 插件的lib库路径, 这个demo里面没有用
     */
    static File getPluginLibDir(String packageName) {
        return enforceDirExists(new File(getPluginBaseDir(packageName), "lib"));
    }

    /**
     * 需要加载的插件的基本目录 /data/data/<package>/files/plugin/
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
