package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.chickenhook.restrictionbypass.Unseal;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MApplication extends Application {

    private static MApplication mApplication;
    private final ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mApplication = this;
        installActivity();
    }

    private void unseal() {
        try {
            Unseal.unseal();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(MApplication.class.getSimpleName(), "Unable to unseal hidden api access", e);
        }
    }

    public static MApplication getInstance() {
        return mApplication;
    }

    private void installActivity() {
        Runnable patchClassLoaderRunnable = new Runnable() {
            @Override
            public void run() {
                unseal();
                //插件使用宿主的ClassLoader加载
                PluginUtils.extractAssets(MApplication.getInstance(), "pluginapk-debug.apk");
                File dexFile = getFileStreamPath("pluginapk-debug.apk");
                File optDexFile = getFileStreamPath("pluginapk-debug.dex");
                BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
                if (Build.VERSION.SDK_INT >= 18) {
                    HookActivityWrapper.hookStartActivity(mApplication, StubAppCompatActivity.class, true);
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            HookActivityWrapper.hookStartActivity(mApplication, StubAppCompatActivity.class, true);
                        }
                    });
                }
            }
        };
        mSingleThreadExecutor.execute(patchClassLoaderRunnable);
    }
}
