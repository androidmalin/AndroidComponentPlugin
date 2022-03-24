package com.taobao.sophix.b;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;

import com.taobao.sophix.a.b;
import com.taobao.sophix.e.ReflectUtil;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class d {

    private Class<?> a;
    private Application application = null;

    public d(Application application) {
        try {
            this.a = Class.forName("android.content.res.AssetManager");
            this.application = application;
        } catch (ClassNotFoundException ignore) {
        }
    }


    public void test() throws b {
        String path = "";
        Method addAssetPathMethod = getMethod("addAssetPath", String.class);
        try {
            AssetManager assets = application.getAssets();
            if (Build.VERSION.SDK_INT <= 20) {
                getMethod(assets, addAssetPathMethod, path);

                //7. call addAssetPath  plugin apk
                addAssetPathMethod.invoke(assets, path);

                //8. call ensureStringBlocks
                getMethod("ensureStringBlocks").invoke(assets);
            } else {
                addAssetPathMethod.invoke(assets, path);
            }
            try {
                getMethod();
            } catch (Exception ignore) {

            }
        } catch (Exception e3) {
            System.out.println("新增资源补丁包异常");
        }
    }

    private void getMethod(AssetManager assetManager, Method addAssetPathMethod, String str) throws b, InvocationTargetException, IllegalAccessException {
        Method destroyMethod = getMethod("destroy");
        Method getStringBlockCountMethod = getMethod("getStringBlockCount");
        Method getCookieNameMethod = getMethod("getCookieName", Integer.TYPE);
        Field mStringBlocksField = getField("mStringBlocks");
        List<String> cookieNames = new ArrayList<>();

        //1. call getStringBlockCount
        Object stringBlockCountObj = getStringBlockCountMethod.invoke(assetManager);
        if (stringBlockCountObj == null) return;
        int stringBlockCount = (Integer) stringBlockCountObj;

        //2. call getCookieName
        for (int i = 0; i < stringBlockCount; i++) {
            String cookieName = (String) getCookieNameMethod.invoke(assetManager, new Object[]{i + 1});
            if (cookieName != null && !cookieName.equals(str)) {//TODO:
                cookieNames.add(cookieName);
            }
        }

        //3. call destroy
        destroyMethod.invoke(assetManager);

        //4. mStringBlocks = null;
        mStringBlocksField.set(assetManager, null);

        //5. call int
        try {
            getMethod("init").invoke(assetManager);
        } catch (Exception e) {
            getMethod("init", Boolean.TYPE).invoke(assetManager, false);
        }

        //6. call addAssetPath
        for (String path : cookieNames) {
            addAssetPathMethod.invoke(assetManager, path);
        }
    }

    private Method getMethod(String str, Class<?>... clsArr) throws b {
        try {
            return ReflectUtil.method(this.a, str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new b(84, e);
        }
    }

    private Field getField(String str) throws b {
        try {
            return ReflectUtil.field(this.a, str);
        } catch (Exception e) {
            throw new b(85, e);
        }
    }

    @SuppressLint("PrivateApi")
    private void getMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Collection<WeakReference<?>> collection;
        if (Build.VERSION.SDK_INT >= 19) {
            Class<?> resourcesManagerClazz = Class.forName("android.app.ResourcesManager");
            Object resourcesManagerObj = ReflectUtil.method(resourcesManagerClazz, "getInstance").invoke(null);
            try {
                // 19.20.21.22.23.
                // api>=19 && api<=23 [19,23]
                // final ArrayMap<ResourcesKey, WeakReference<Resources> > mActiveResources = new ArrayMap<ResourcesKey, WeakReference<Resources> >();
                collection = ((ArrayMap) ReflectUtil.field(resourcesManagerClazz, "mActiveResources").get(resourcesManagerObj)).values();
            } catch (NoSuchFieldException e) {
                // api>=24 && api <=31 [24,31]
                // private final ArrayList<WeakReference<Resources>> mResourceReferences = new ArrayList<>();
                collection = (Collection) ReflectUtil.field(resourcesManagerClazz, "mResourceReferences").get(resourcesManagerObj);
            }
        } else {
            Class<?> activityThreadClazz = ReflectUtil.activityTheadClazz;
            Object activityThreadObj = ReflectUtil.method(activityThreadClazz, "currentActivityThread").invoke(null);
            if (activityThreadObj == null) {
                // public LoadedApk mLoadedApk;
                Object loadedApk = ReflectUtil.field(Application.class, "mLoadedApk").get(application);
                // private final ActivityThread mActivityThread;(LoadedApk.java)
                activityThreadObj = ReflectUtil.field(loadedApk.getClass(), "mActivityThread").get(loadedApk);
            }
            // final HashMap<ResourcesKey, WeakReference<Resources>> mActiveResources = new HashMap<ResourcesKey, WeakReference<Resources> >();
            collection = ((HashMap) ReflectUtil.field(activityThreadClazz, "mActiveResources").get(activityThreadObj)).values();
        }
        for (WeakReference<?> weakReference : collection) {
            Resources resources = (Resources) weakReference.get();
            if (resources != null) {
                resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                Log.d("ResourceManager", "update successfully");
            }
        }
    }
}
