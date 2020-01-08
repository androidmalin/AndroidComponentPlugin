package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
@SuppressWarnings({"JavaReflectionMemberAccess", "JavaReflectionInvocation"})
public class ProxyService extends Service {
    private static final String TAG = "ProxyService";
    public static final String TARGET_SERVICE = "target_service";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        if (null == intent || !intent.hasExtra(TARGET_SERVICE)) {
            return START_STICKY;
        }
        String serviceName = intent.getStringExtra(TARGET_SERVICE);
        if (null == serviceName) {
            return START_STICKY;
        }
        Service targetService;
        try {
            //1.ActivityThread实例
            Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");

            //public static ActivityThread currentActivityThread() {return sCurrentActivityThread;}
            Method currentActivityThreadMethod = activityThreadClazz.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);


            //2.activityThread 实例
            Object activityThread = currentActivityThreadMethod.invoke(null);


            //3.applicationThread 实例
            //public ApplicationThread getApplicationThread(){return mAppThread;}
            Method getActivityThreadMethod = activityThreadClazz.getDeclaredMethod("getApplicationThread");
            getActivityThreadMethod.setAccessible(true);
            Object applicationThread = getActivityThreadMethod.invoke(activityThread);


            //4.token
            Class<?> iInterfaceClazz = Class.forName("android.os.IInterface");
            Method asBinderMethod = iInterfaceClazz.getDeclaredMethod("asBinder");
            asBinderMethod.setAccessible(true);
            Object token = asBinderMethod.invoke(applicationThread);

            Class<?> serviceClazz = Class.forName("android.app.Service");
            //public final void attach(Context context,ActivityThread thread, String className, IBinder token, Application application, Object activityManager)
            Method attachMethod = serviceClazz.getDeclaredMethod("attach", Context.class, activityThreadClazz, String.class, IBinder.class, Application.class, Object.class);
            attachMethod.setAccessible(true);


            //5.get IActivityManager实例
            Object defaultSingleton;
            if (Build.VERSION.SDK_INT >= 26) {
                Class<?> activityManageClazz = Class.forName("android.app.ActivityManager");
                Field IActivityManagerSingletonField = activityManageClazz.getDeclaredField("IActivityManagerSingleton");
                IActivityManagerSingletonField.setAccessible(true);
                defaultSingleton = IActivityManagerSingletonField.get(null);
            } else {
                Class<?> activityManagerNativeClazz = Class.forName("android.app.ActivityManagerNative");
                Field gDefaultField = activityManagerNativeClazz.getDeclaredField("gDefault");
                gDefaultField.setAccessible(true);
                defaultSingleton = gDefaultField.get(null);
            }
            Class<?> singletonClazz = Class.forName("android.util.Singleton");
            Field mInstanceField = singletonClazz.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);
            Object iActivityManagerObj = mInstanceField.get(defaultSingleton);


            //6.反射创建TargetService
            targetService = (Service) Class.forName(serviceName).newInstance();

            ComponentName component = intent.getComponent();
            if (component == null) return START_STICKY;

            //反射调用Service的attach()方法
            attachMethod.invoke(targetService, this, activityThread, component.getClassName(), token, getApplication(), iActivityManagerObj);

            //调用Service的onCreate()方法
            targetService.onCreate();

            //调用Service的onStartCommand()方法
            targetService.onStartCommand(intent, flags, startId);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return START_STICKY;
        }
        return START_STICKY;
    }
}



