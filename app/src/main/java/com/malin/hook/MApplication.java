package com.malin.hook;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import me.weishu.reflection.Reflection;

public class MApplication extends Application {

    private static MApplication mApplication;

    //为了重置,否则第二次之后的启动都是已经注册的Activity
    private static Object mIActivityManagerObj;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mApplication = this;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Reflection.unseal(context);
            }
            HookHelper.replaceInstrumentation();
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

    public static MApplication getInstance() {
        return mApplication;
    }
}
