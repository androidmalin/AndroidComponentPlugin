package com.malin.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;


public class PluginResourceUtil {

    private static final String TAG = PluginResourceUtil.class.getSimpleName();
    private static Resources mResources;

    public static Resources getResource(Context context) {
        if (mResources == null) {
            mResources = loadResource(context);
            if (mResources == null) {
                throw new NullPointerException("plugin Resources==null");
            }
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

            Resources resources = context.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void testLayoutId(Context context) {
        int layoutId = 0x7f020000;
        try {
            int activity_layout = context
                    .getResources()
                    .getIdentifier("plugin_activity", "layout", "com.malin.plugin");
            int activity_layout2 = context
                    .getClassLoader()
                    .loadClass("com.malin.plugin.R$layout")
                    .getDeclaredField("plugin_activity")
                    .getInt(null);
            Log.d(TAG, "getIdentifier:" + (activity_layout == layoutId));
            Log.d(TAG, "getInt:" + (activity_layout2 == layoutId));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * 在10.0的手机上, 因为没有 ensureStringBlocks方法, 出现异常,最后return null
     * 导致整体失败, 找不见资源.
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    private static Resources loadResourceError(Context context) {
        try {
            File dexFile = context.getFileStreamPath("pluginapk-debug.apk");

            // 执行此addAssetPath(String path) 方法，能把插件的路径添加进去
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            addAssetPathMethod.invoke(assetManager, dexFile.getAbsolutePath());

            //在10.0的手机上, 因为没有 ensureStringBlocks方法, 出现异常,最后return null
            Method ensureStringBlocksMethod = assetManager.getClass().getDeclaredMethod("ensureStringBlocks");
            ensureStringBlocksMethod.setAccessible(true);
            ensureStringBlocksMethod.invoke(assetManager);

            Resources resources = context.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


}
