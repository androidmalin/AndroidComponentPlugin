package com.malin.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JavaReflectionMemberAccess")
public class ResourceUtil {

    public static Resources create(Context context, String apk) {
        int version = Build.VERSION.SDK_INT;
        if (version < Build.VERSION_CODES.LOLLIPOP) { // 15 <= api < 21
            return getPluginResourceForAndroidL(context, apk);
        } else if (version < Build.VERSION_CODES.N) { // 21 <= api < 24
            return getPluginResourceForAndroidM(context, apk);
        } else { // 24 <= api < 32
            return getPluginResourceForAndroidS(context, apk);
        }
    }


    // 15 <= api < 21
    @SuppressLint("PrivateApi")
    public static Resources getPluginResourceForAndroidL(Context hostContext, String apk) {
        Resources hostResources = hostContext.getResources();
        try {
            AssetManager assetManager = hostResources.getAssets();
            Class<?> assetManagerClazz = assetManager.getClass();

            // 我们需要将应用原来加载的地址取出来，详情见①
            // 由于我们将host的AssetManager已经destroy后，需要还原原来的地址，否则就会发生找不到资源的情况，
            // 此时需要提前将host加载的资源路径全部取出来，理论上，这个过程系统是做了一部分的，当我们调用init方法的时候
            List<String> cookieNames = new ArrayList<>();

            // private native final int getStringBlockCount();
            Method getStringBlockCount = assetManagerClazz.getDeclaredMethod("getStringBlockCount");
            getStringBlockCount.setAccessible(true);
            Object stringBlockCountObj = getStringBlockCount.invoke(assetManager);
            if (stringBlockCountObj == null) return null;
            int stringBlockCount = (int) stringBlockCountObj;

            Method getCookieNameMethod = AssetManager.class.getDeclaredMethod("getCookieName", Integer.TYPE);
            getCookieNameMethod.setAccessible(true);

            for (int i = 0; i < stringBlockCount; i++) {
                String cookieName = (String) getCookieNameMethod.invoke(assetManager, new Object[]{i + 1});
                cookieNames.add(cookieName);
            }

            Method destroyMethod = assetManagerClazz.getDeclaredMethod("destroy");
            destroyMethod.setAccessible(true);
            destroyMethod.invoke(assetManager);

            Method initMethod = assetManagerClazz.getDeclaredMethod("init");
            initMethod.setAccessible(true);
            initMethod.invoke(assetManager);


            // ②③引用：它记录了之前加载过的所有资源包中的String Pool，很多时候访问字符串是从此处来的，如果不重新构造就会导致崩溃
            // private StringBlock mStringBlocks[] = null;
            Field mStringBlocksField = assetManagerClazz.getDeclaredField("mStringBlocks");//②
            mStringBlocksField.setAccessible(true);
            mStringBlocksField.set(assetManager, null);

            // public final int addAssetPath(String path) {...}
            @SuppressLint("DiscouragedPrivateApi") Method addAssetPathMethod = assetManagerClazz.getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            // 将原来的assets添加进去，有了此步骤就不用刻意添加sourceDir了
            for (String path : cookieNames) {
                //ReflectUtil.invoke(AssetManager.class, assetManager, "addAssetPath", path);
                addAssetPathMethod.invoke(assetManager, path);
            }

            // 插入插件的资源地址
            @SuppressLint("DiscouragedPrivateApi") Method addAssetPathMethod1 = assetManagerClazz.getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod1.setAccessible(true);
            addAssetPathMethod1.invoke(assetManager, apk);

            // final void ensureStringBlocks() {}
            Method ensureStringBlocksMethod = assetManagerClazz.getDeclaredMethod("ensureStringBlocks");//③
            ensureStringBlocksMethod.setAccessible(true);
            ensureStringBlocksMethod.invoke(assetManager);

            // 4：过程中很重要的一步，因为后面在资源查找的时候是需要通过一个ResTable_config来获取当前手机的一些配置从而获取到准确的资源，
            // 如果不进行初始化则会出现找不到资源的崩溃
            hostResources.updateConfiguration(hostResources.getConfiguration(), hostResources.getDisplayMetrics());//此行代码非常重要4.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hostResources;
    }


    @SuppressWarnings("JavaReflectionMemberAccess")
    private static Resources getPluginResourceForAndroidM(Context context, String apk) {
        try {
            // 执行此addAssetPath(String path) 方法，能把插件的路径添加进去
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            addAssetPathMethod.invoke(assetManager, apk);
            Resources resources = context.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 24 <= api < 32
    @SuppressWarnings({"JavaReflectionMemberAccess", "PrivateApi"})
    public static Resources getPluginResourceForAndroidS(Context context, String pluginPath) {
        try {
            //1.调用assetManager.addAssetPath(pluginPath);
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            addAssetPathMethod.invoke(assetManager, pluginPath);

            Resources superRes = context.getResources();
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
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
