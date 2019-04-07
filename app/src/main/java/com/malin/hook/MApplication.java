package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class MApplication extends Application {

    //为了重置,否则第二次之后的启动都是启动的注册的Activity
    private static Object mObject;
    private static Handler mHandler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
            mObject = HookAMS.storeAms();
            mHandler = HookAMS.storeActivityLaunch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        try {
            HookAMS.resetAms(mObject);
            HookAMS.resetActivityLaunch(mHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
