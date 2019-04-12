package com.malin.hook;

import android.app.Application;
import android.content.Context;

public class MApplication extends Application {

    //为了重置,否则第二次之后的启动都是已经注册的Activity
    private static Object mIActivityManagerObj;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        try {
            mIActivityManagerObj = HookAMS.getIActivityManagerObj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        try {
            HookAMS.resetIActivityManager(mIActivityManagerObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
