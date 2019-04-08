package com.malin.hook;

import android.app.Application;
import android.content.Context;

public class MApplication extends Application {

    //为了重置,否则第二次之后的启动都是启动的注册的Activity
    private static Object mObject;
    private static Object mHandler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
            mObject = HookAMS.getIActivityManagerObj();
            mHandler = HookAMS.getActivityThreadInnerHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        try {
            HookAMS.resetIActivityManager(mObject);
            HookAMS.resetActivityThreadInnerHandler(mHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
