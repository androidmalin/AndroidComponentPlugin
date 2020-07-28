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

}
