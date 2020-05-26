package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MApplication extends Application {

    private static MApplication mApplication;

    //为了重置,否则第二次之后的启动都是已经注册的Activity
    private static Object mIActivityManagerObj;
    private static Object mPmsObj;
    private final ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mApplication = this;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Reflection.unseal();
            }
            mPmsObj = HookPMS.getPackageManager();
            mIActivityManagerObj = HookAMS.getIActivityManagerObj();
            installActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resetAms() {
        if (mIActivityManagerObj != null) {
            try {
                HookAMS.resetIActivityManager(mIActivityManagerObj);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetPms() {
        if (mPmsObj != null) {
            try {
                HookPMS.resetPackageManager(mPmsObj);
                HookPMS.resetApplicationPackageManager(getInstance().getApplicationContext(), mPmsObj);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static MApplication getInstance() {
        return mApplication;
    }

    private void installActivity() {
        Runnable patchClassLoaderRunnable = new Runnable() {
            @Override
            public void run() {
                //插件使用宿主的ClassLoader加载
                PluginUtils.extractAssets(MApplication.getInstance(), "pluginapk-debug.apk");
                File dexFile = getFileStreamPath("pluginapk-debug.apk");
                File optDexFile = getFileStreamPath("pluginapk-debug.dex");
                BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
            }
        };
        mSingleThreadExecutor.execute(patchClassLoaderRunnable);
    }
}
