package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 插件可以访问宿主的资源.
 * 插件调用宿主资源则需要将宿主的APK和插件的APK一起添加到同一个AssetManager里.
 * https://developer.aliyun.com/article/96378?spm=a2c6h.13262185.0.0.c199665bxL977t
 * https://mp.weixin.qq.com/s/7f81xxRjqHu3Nu9xDrqShw?spm=a2c6h.12873639.0.0.43547f9bTVCu1Y
 */
@SuppressWarnings("JavaReflectionMemberAccess")
public class ResourceUtil2 {

    @SuppressLint("PrivateApi")
    public static Resources createResources(Context hostContext, Application application, String apk) {
        Resources hostResources = hostContext.getResources();
        try {
            AssetManager assetManager = hostResources.getAssets();
            Class<?> assetManagerClazz = assetManager.getClass();

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                // 我们需要将应用原来加载的地址取出来，详情见①
                // 由于我们将host的AssetManager已经destroy后，需要还原原来的地址，否则就会发生找不到资源的情况，
                // 此时需要提前将host加载的资源路径全部取出来，理论上，这个过程系统是做了一部分的，当我们调用init方法的时候
                List<String> cookieNames = new ArrayList<>();

                // 1. call assetManager getStringBlockCount()
                // private native final int getStringBlockCount();
                Method getStringBlockCount = assetManagerClazz.getDeclaredMethod("getStringBlockCount");
                getStringBlockCount.setAccessible(true);
                Object stringBlockCountObj = getStringBlockCount.invoke(assetManager);
                if (stringBlockCountObj == null) return null;
                int stringBlockCount = (int) stringBlockCountObj;

                // 2. call assetManager getCookieName() TODO:不同
                Method getCookieNameMethod = AssetManager.class.getDeclaredMethod("getCookieName", Integer.TYPE);
                getCookieNameMethod.setAccessible(true);

                for (int i = 0; i < stringBlockCount; i++) {
                    String cookieName = (String) getCookieNameMethod.invoke(assetManager, new Object[]{i + 1});
                    if (cookieName != null && !cookieName.equals(apk)) {
                        cookieNames.add(cookieName);
                    }
                }

                // 3. call assetManager destroy()
                Method destroyMethod = assetManagerClazz.getDeclaredMethod("destroy");
                destroyMethod.setAccessible(true);
                destroyMethod.invoke(assetManager);

                // 4. set mStringBlocks field null
                // ②③引用：它记录了之前加载过的所有资源包中的String Pool，很多时候访问字符串是从此处来的，如果不重新构造就会导致崩溃
                // private StringBlock mStringBlocks[] = null;
                Field mStringBlocksField = assetManagerClazz.getDeclaredField("mStringBlocks");//②
                mStringBlocksField.setAccessible(true);
                mStringBlocksField.set(assetManager, null);

                // 5. call assetManager init() TODO:不同
                try {
                    Method initMethod = assetManagerClazz.getDeclaredMethod("init");
                    initMethod.setAccessible(true);
                    initMethod.invoke(assetManager);
                } catch (Exception ignore) {
                    Method initMethod = assetManagerClazz.getDeclaredMethod("init", Boolean.TYPE);
                    initMethod.setAccessible(true);
                    initMethod.invoke(assetManager, false);
                }

                // 6. call assetManager addAssetPath()
                // public final int addAssetPath(String path) {...}
                @SuppressLint("DiscouragedPrivateApi")
                Method addAssetPathMethod = assetManagerClazz.getDeclaredMethod("addAssetPath", String.class);
                addAssetPathMethod.setAccessible(true);

                // 将原来的assets添加进去，有了此步骤就不用刻意添加sourceDir了
                for (String path : cookieNames) {
                    addAssetPathMethod.invoke(assetManager, path);
                }

                // 7. call assetManager addAssetPath() add plugin apk
                // 插入插件的资源地址
                addAssetPathMethod.invoke(assetManager, apk);

                // 8. call assetManager ensureStringBlocks()
                // final void ensureStringBlocks() {}
                Method ensureStringBlocksMethod = assetManagerClazz.getDeclaredMethod("ensureStringBlocks");//③
                ensureStringBlocksMethod.setAccessible(true);
                ensureStringBlocksMethod.invoke(assetManager);

                // 9. updateConfiguration
                // 4：过程中很重要的一步，因为后面在资源查找的时候是需要通过一个ResTable_config来获取当前手机的一些配置从而获取到准确的资源，
                // 如果不进行初始化则会出现找不到资源的崩溃
                handleConfiguration(application);
            } else {
                hostResources = getPluginResources(hostContext, apk);
                handleConfiguration(application);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hostResources;
    }

    // Iterate over all known Resources objects
    @SuppressLint("PrivateApi")
    private static void handleConfiguration(Application application) {

        try {
            Collection<WeakReference<Resources>> collection;
            if (Build.VERSION.SDK_INT >= 19) {
                Class<?> resourcesManagerClazz = Class.forName("android.app.ResourcesManager");
                @SuppressLint("DiscouragedPrivateApi")
                Method getInstanceMethod = resourcesManagerClazz.getDeclaredMethod("getInstance");
                getInstanceMethod.setAccessible(true);
                Object resourcesManagerObj = getInstanceMethod.invoke(null);
                try {
                    // 19.20.21.22.23.
                    // api>=19 && api<=23 [19,23]
                    // final ArrayMap<ResourcesKey, WeakReference<Resources> > mActiveResources = new ArrayMap<ResourcesKey, WeakReference<Resources> >();
                    Field mActiveResourcesField = resourcesManagerClazz.getDeclaredField("mActiveResources");
                    mActiveResourcesField.setAccessible(true);

                    @SuppressWarnings("unchecked")
                    ArrayMap<?, WeakReference<Resources>> arrayMap = (ArrayMap<?, WeakReference<Resources>>) mActiveResourcesField.get(resourcesManagerObj);
                    collection = arrayMap.values();
                } catch (NoSuchFieldException e) {
                    // api>=24 && api <=31 [24,31]
                    // private final ArrayList<WeakReference<Resources>> mResourceReferences = new ArrayList<>();
                    @SuppressLint("DiscouragedPrivateApi")
                    Field mResourceReferencesField = resourcesManagerClazz.getDeclaredField("mResourceReferences");
                    mResourceReferencesField.setAccessible(true);
                    //noinspection unchecked
                    collection = (Collection<WeakReference<Resources>>) mResourceReferencesField.get(resourcesManagerObj);
                }
            } else {
                Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
                @SuppressLint("DiscouragedPrivateApi")
                Method currentActivityThreadMethod = activityThreadClazz.getDeclaredMethod("currentActivityThread");
                currentActivityThreadMethod.setAccessible(true);
                Object activityThreadObj = currentActivityThreadMethod.invoke(null);
                if (activityThreadObj == null) {
                    // public LoadedApk mLoadedApk;
                    @SuppressLint("DiscouragedPrivateApi")
                    Field mLoadedApkField = Application.class.getDeclaredField("mLoadedApk");
                    mLoadedApkField.setAccessible(true);
                    Object loadedApk = mLoadedApkField.get(application);

                    Class<?> loadedApkClazz = Class.forName("android.app.LoadedApk");
                    // private final ActivityThread mActivityThread;(LoadedApk.java)
                    @SuppressLint("DiscouragedPrivateApi")
                    Field mActivityThreadField = loadedApkClazz.getDeclaredField("mActivityThread");
                    mActivityThreadField.setAccessible(true);
                    activityThreadObj = mActivityThreadField.get(loadedApk);
                }

                // final HashMap<ResourcesKey, WeakReference<Resources>> mActiveResources = new HashMap<ResourcesKey, WeakReference<Resources> >();
                Field mActiveResourcesField = activityThreadClazz.getDeclaredField("mActiveResources");
                mActiveResourcesField.setAccessible(true);

                @SuppressWarnings("unchecked")
                HashMap<?, WeakReference<Resources>> map = (HashMap<?, WeakReference<Resources>>) mActiveResourcesField.get(activityThreadObj);
                collection = map.values();
            }
            if (collection == null) return;
            for (WeakReference<Resources> weakReference : collection) {
                Resources resources = weakReference.get();
                if (resources != null) {
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                    Log.d("ResourceManager", "update successfully");
                }
            }
        } catch (Throwable ignore) {
            ignore.printStackTrace();
        }
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
}
