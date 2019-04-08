package com.malin.hook;

import android.app.Application;
import android.content.Context;

public class MApplication extends Application {

    //为了重置,否则第二次之后的启动都是启动的注册的Activity
    private static Object mIActivityManagerObj;
    private static Object mHandlerObj;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
            mIActivityManagerObj = HookAMS.getIActivityManagerObj();
            mHandlerObj = HookAMS.getActivityThreadInnerHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        try {
            HookAMS.resetIActivityManager(mIActivityManagerObj);
            HookAMS.resetActivityThreadInnerHandler(mHandlerObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
