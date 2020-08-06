package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.chickenhook.restrictionbypass.Unseal;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MApplication extends Application {

    private static MApplication mApplication;

    /**
     * 前提:每次启动插件Activity时都进行了hook.
     * 第二次之后的启动都是已经注册的Activity bug的解决方案
     * 1.重置
     * 2.在HookActivity中设置IActivityInvocationHandler时,不是每次都new出一个, 而是复用上次生产的IActivityInvocationHandler
     */
    private static Object mIActivityManagerObj;
    private static Object msPackageManager;
    private static Object mmPM;
    private final ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mApplication = this;
        unseal();
        getIActivityManager();
        getPackageManager(context);
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

    private void getIActivityManager() {
        mIActivityManagerObj = HookAMS.getIActivityManager();
    }

    public static void resetAms() {
        if (mIActivityManagerObj == null) return;
        HookAMS.resetIActivityManager(mIActivityManagerObj);
    }

    private void getPackageManager(Context context) {
        mmPM = HookPMS.getApplicationPackageManager(context);
        msPackageManager = HookPMS.getPackageManager();
    }

    public static void resetPms() {
        if (mmPM == null) return;
        HookPMS.resetApplicationPackageManager(getInstance(), mmPM);
        if (msPackageManager == null) return;
        HookPMS.resetPackageManager(msPackageManager);
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
