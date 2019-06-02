package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.malin.hook.service.HookService;
import com.malin.hook.service.ProxyService;

import me.weishu.reflection.Reflection;

public class MApplication extends Application {

    private static MApplication mApplication;

    //为了重置,否则第二次之后的启动都是已经注册的Activity
    private static Object mIActivityManagerObj;


    /**
     * 是否是Hook Instrumentation
     * true:Hook Instrumentation
     * false:Hook AMS and PMS
     */
    private final boolean mHookInstrumentation = false;

    /**
     * Hook Instrumentation的方式下,是否启动appcompatActivity类型的Activity.
     */
    private final boolean mHookInstrumentation_is_appcompatActivity = false;


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mApplication = this;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Reflection.unseal(context);
            }
            HookService.hookAMSForService(context, ProxyService.class);
            if (mHookInstrumentation) {
                if (mHookInstrumentation_is_appcompatActivity) {
                    HookInstrumentation.hookInstrumentation(context, StubAppCompatActivity.class.getCanonicalName());
                } else {
                    HookInstrumentation.hookInstrumentation(context, StubActivity.class.getCanonicalName());
                }
            } else {
                mIActivityManagerObj = HookAMS.getIActivityManagerObj();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        try {
            if (mIActivityManagerObj != null) {
                HookAMS.resetIActivityManager(mIActivityManagerObj);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
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
}
