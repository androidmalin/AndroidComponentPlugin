package com.malin.hook;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
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
        Source source = null;
        BufferedSource buffer = null;
        Sink sink = null;
        try {
            inputStream = assets.open(sourceName);
            source = Okio.source(inputStream);
            buffer = Okio.buffer(source);
            sink = Okio.sink(context.getFileStreamPath(sourceName));
            buffer.readAll(sink);
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

            if (source != null) {
                try {
                    source.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (sink != null) {
                try {
                    sink.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (buffer != null) {
                try {
                    buffer.close();
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
