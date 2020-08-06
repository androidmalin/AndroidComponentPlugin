package com.malin.hook;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class PluginResourceUtil {

    public static Drawable getPluginDrawableByName(Context context, String pluginApkName, String pluginPackageName, String sourceName) {
        String PATH = context.getFileStreamPath(pluginApkName).getAbsolutePath();
        Resources resources = getPluginResources(context, PATH);
        int resId = 0;
        int mode = 1;
        switch (mode) {
            case 1: {
                resId = getResId(pluginPackageName, sourceName);
                break;
            }
            case 2: {
                resId = getResId2(resources, pluginPackageName, sourceName);
                break;
            }

            case 3: {
                resId = getResId3(context, PATH, pluginPackageName, sourceName);
                break;
            }
        }
        return resources.getDrawable(resId);
    }


    @SuppressWarnings("JavaReflectionMemberAccess")
    public static Resources getPluginResources(Context context, String pluginPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPathMethod.invoke(assetManager, pluginPath);
            Resources superRes = context.getResources();
            return new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getResId(String pluginPackageName, String resName) {
        try {
            Class<?> r$DrawableClazz = Class.forName(pluginPackageName + ".R$drawable");
            Field resField = r$DrawableClazz.getDeclaredField(resName);
            return resField.getInt(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getResId2(Resources resources, String pluginPackageName, String resName) {
        return resources.getIdentifier(resName, "drawable", pluginPackageName);
    }

    public static int getResId3(Context context, String pluginPath, String pluginPackageName, String resName) {
        try {
            File optimizedDirectoryFile = context.getDir("dex", Context.MODE_PRIVATE);
            DexClassLoader dexClassLoader = new DexClassLoader(pluginPath, optimizedDirectoryFile.getPath(), null, ClassLoader.getSystemClassLoader());
            Class<?> r$DrawableClazz = dexClassLoader.loadClass(pluginPackageName + ".R$drawable");
            Field resField = r$DrawableClazz.getDeclaredField(resName);
            return resField.getInt(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }
}
