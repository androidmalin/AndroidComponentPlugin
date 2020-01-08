package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

public class MApplication extends Application {

    private static final String TAG = "MApplication";
    private static MApplication mApplication;

    /**
     * 为了重置,否则在HookAMS的情况下第二次之后的启动都是已经注册的Activity
     */
    private static Object mIActivityManagerObj;
    private static Object msPackageManager;
    private static Object mmPM;


    /**
     * 是否是Hook Instrumentation
     * true:Hook Instrumentation
     * false:Hook AMS and PMS
     */
    private final boolean mHookInstrumentation = false;

    /**
     * Hook Instrumentation的方式下,是否启动appcompatActivity类型的Activity.
     */
    private final boolean mHookInstrumentation_is_appcompatActivity = true;


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        unseal();
        init();
        startStrictMode();
        getPM(context);
        handleService(context);
        handleActivity(context);
    }

    private void init() {
        mApplication = this;
    }

    private void unseal() {
        int reflection = Reflection.unseal();
        Log.d(TAG, reflection == 0 ? "hide api 解除成功" : "hide api 解除失败");
    }

    private void handleActivity(Context context) {
        if (mHookInstrumentation) {
            if (mHookInstrumentation_is_appcompatActivity) {
                HookInstrumentation.hookInstrumentation(context, StubAppCompatActivity.class.getCanonicalName());
            } else {
                HookInstrumentation.hookInstrumentation(context, StubActivity.class.getCanonicalName());
            }
        } else {
            mIActivityManagerObj = HookAMS.getIActivityManagerObj();
        }
    }

    private void getPM(Context context) {
        mmPM = HookPMS.getApplicationPackageManager(context);
        msPackageManager = HookPMS.getPackageManager();
    }

    private void handleService(Context context) {
        HookService.hookAMSForService(context, ProxyService.class);
    }


    public static void resetAms() {
        if (mIActivityManagerObj == null) return;
        HookAMS.resetIActivityManager(mIActivityManagerObj);
    }

    public static void resetPms() {
        if (mmPM == null) return;
        HookPMS.resetApplicationPackageManager(getInstance(), mmPM);
        if (msPackageManager == null) return;
        HookPMS.resetPackageManager(msPackageManager);
    }

    public boolean isHookInstrumentation() {
        return mHookInstrumentation;
    }

    public boolean isHookInstrumentationIsAppCompatActivity() {
        return mHookInstrumentation_is_appcompatActivity;
    }


    public static MApplication getInstance() {
        return mApplication;
    }

    private void startStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyDialog()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyDeath()
                .penaltyLog()
                .build());
    }
}
