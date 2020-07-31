package com.malin.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;


public class PluginResourceUtil {

    private static Resources mResources;

    public static Resources getResource(Context context) {
        if (mResources == null) {
            mResources = loadResource(context);
        }
        return mResources;
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    private static Resources loadResource(Context context) {
        try {
            File dexFile = context.getFileStreamPath("pluginapk-debug.apk");

            // 执行此addAssetPath(String path) 方法，能把插件的路径添加进去
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            addAssetPathMethod.invoke(assetManager, dexFile.getAbsolutePath());

            // ensureStringBlocks  初始化 string.xml  color.xml  anim.xml 等文件
            Method ensureStringBlocksMethod = assetManager.getClass().getDeclaredMethod("ensureStringBlocks");
            ensureStringBlocksMethod.setAccessible(true);
            ensureStringBlocksMethod.invoke(assetManager);

            Resources resources = context.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
