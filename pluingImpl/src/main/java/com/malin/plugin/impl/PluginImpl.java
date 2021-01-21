package com.malin.plugin.impl;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.chickenhook.restrictionbypass.Unseal;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PluginImpl {

    public static final String PLUGIN_APK_NAME = "pluginapk-debug.apk";
    private static final String PLUGIN_DEX_NAME = "pluginapk-debug.dex";

    private final ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();
    private final Handler mHandler = new Handler(Looper.getMainLooper());


    private static class Holder {
        private static final PluginImpl instance = new PluginImpl();
    }

    public static PluginImpl getInstance() {
        return Holder.instance;
    }


    public void init(Context context, boolean instrumentation) {
        unseal();
        if (instrumentation) {
            HookInstrumentation.hookInstrumentation(context);
        }
        installActivity(context, instrumentation);
    }

    private void unseal() {
        try {
            Unseal.unseal();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(PluginImpl.class.getSimpleName(), "Unable to unseal hidden api access", e);
        }
    }

    private void installActivity(Context context, boolean instrumentation) {
        Runnable patchClassLoaderRunnable = () -> {
            //插件使用宿主的ClassLoader加载
            PluginUtils.extractAssets(context, PLUGIN_APK_NAME);
            File dexFile = context.getFileStreamPath(PLUGIN_APK_NAME);
            File optDexFile = context.getFileStreamPath(PLUGIN_DEX_NAME);
            BaseDexClassLoaderHookHelper.patchClassLoader(context.getClassLoader(), dexFile, optDexFile);
            if (instrumentation) {
                HookActivity.hookPackageManager(context, StubAppCompatActivity.class);
            } else {
                if (Build.VERSION.SDK_INT >= 18) {
                    HookActivityWrapper.hookStartActivity(context, StubAppCompatActivity.class, true);
                } else {
                    mHandler.post(() -> HookActivityWrapper.hookStartActivity(context, StubAppCompatActivity.class, true));
                }
            }
        };
        mSingleThreadExecutor.execute(patchClassLoaderRunnable);
    }
}
