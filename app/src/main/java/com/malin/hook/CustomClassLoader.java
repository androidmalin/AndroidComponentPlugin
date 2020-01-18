package com.malin.hook;

import android.util.Log;

import java.io.File;

import dalvik.system.DexClassLoader;

class CustomClassLoader extends DexClassLoader {
    private static final String TAG = CustomClassLoader.class.getSimpleName();

    private CustomClassLoader(String dexPath, String optimizedDirectory, String libraryPath, ClassLoader parent) {
        super(dexPath, optimizedDirectory, libraryPath, parent);
    }

    /**
     * 便利方法: 获取插件的ClassLoader, 能够加载指定的插件中的类
     */
    static CustomClassLoader getPluginClassLoader(File plugin, String packageName) {
        //String dexPath, String optimizedDirectory, String librarySearchPath, ClassLoader parent
        Log.d(TAG, "dexPath:" + plugin.getPath());
        Log.d(TAG, "optimizedDirectory:" + PluginUtils.getPluginOptDexDir(packageName).getPath());
        Log.d(TAG, "librarySearchPath:" + PluginUtils.getPluginLibDir(packageName).getPath());
        Log.d(TAG, "parent ClassLoader:" + MApplication.getInstance().getClassLoader().getClass().getCanonicalName());
        return new CustomClassLoader(plugin.getPath(),
                PluginUtils.getPluginOptDexDir(packageName).getPath(),
                PluginUtils.getPluginLibDir(packageName).getPath(),
                MApplication.getInstance().getClassLoader());
    }

}
