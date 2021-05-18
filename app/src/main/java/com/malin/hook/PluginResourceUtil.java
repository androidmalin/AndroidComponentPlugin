package com.malin.hook;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;

import androidx.core.content.res.ResourcesCompat;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class PluginResourceUtil {

    ///data/user/0/com.malin.hook/files/pluginapk-debug.apk
    public static Drawable getPluginDrawableByName(Context context, String pluginApkName, String pluginPackageName, String sourceName) {
        String plugin_apk_path = context.getFileStreamPath(pluginApkName).getAbsolutePath();
        Resources resources = getPluginResources(context, plugin_apk_path);
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
                resId = getResId3(context, plugin_apk_path, pluginPackageName, sourceName);
                break;
            }

            case 4: {
                resId = getResId4(context, pluginPackageName, sourceName);
                break;
            }
        }
        if (resources != null) {
            return ResourcesCompat.getDrawable(resources, resId, context.getTheme());
        }
        return null;
    }


    @SuppressWarnings({"JavaReflectionMemberAccess", "PrivateApi", "deprecation"})
    public static Resources getPluginResources(Context context, String pluginPath) {
        try {
            //1.调用assetManager.addAssetPath(pluginPath);
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            addAssetPathMethod.invoke(assetManager, pluginPath);

            Resources superRes = context.getResources();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //Resources#public void setImpl(ResourcesImpl impl) {}
                Class<?> displayAdjustmentsClazz = Class.forName("android.view.DisplayAdjustments");
                Constructor<?> displayAdjustmentsConstructor = displayAdjustmentsClazz.getDeclaredConstructor();
                displayAdjustmentsConstructor.setAccessible(true);
                Object displayAdjustmentsObj = displayAdjustmentsConstructor.newInstance();

                //new ResourcesImpl(AssetManager assets,DisplayMetrics metrics,
                // Configuration config, DisplayAdjustments displayAdjustments) {}
                Class<?> resourcesImplClazz = Class.forName("android.content.res.ResourcesImpl");
                Constructor<?> resourcesImplConstructor = resourcesImplClazz.getDeclaredConstructor(AssetManager.class, DisplayMetrics.class, Configuration.class, displayAdjustmentsClazz);
                resourcesImplConstructor.setAccessible(true);
                Object resourcesImplObj = resourcesImplConstructor.newInstance(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration(), displayAdjustmentsObj);

                //private Resources() {}
                Class<?> resourcesClazz = Class.forName("android.content.res.Resources");
                Constructor<?> resourcesConstructor = resourcesClazz.getDeclaredConstructor();
                resourcesConstructor.setAccessible(true);
                Object resourcesObj = resourcesConstructor.newInstance();

                //Resources
                //public void setImpl(ResourcesImpl impl) {}
                Method setImplMethod = resourcesClazz.getDeclaredMethod("setImpl", resourcesImplClazz);
                setImplMethod.setAccessible(true);

                //resources.setImpl(ResourcesImpl impl){}
                setImplMethod.invoke(resourcesObj, resourcesImplObj);
                return (Resources) resourcesObj;
            } else {
                return new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
            }
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

    public static int getResId4(Context context, String pluginPackageName, String resName) {
        int drawableResId = 0;
        try {
            drawableResId = context
                    .getClassLoader()
                    .loadClass(pluginPackageName + ".R$drawable")
                    .getDeclaredField(resName)
                    .getInt(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return drawableResId;
    }
}
