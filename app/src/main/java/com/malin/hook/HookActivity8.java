package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * malin
 * 反射
 * https://www.cnblogs.com/chanshuyi/p/head_first_of_reflection.html
 * >=android 8.0以上的Hook
 */
@SuppressWarnings("JavaReflectionMemberAccess")
@SuppressLint("PrivateApi")
public class HookActivity8 {
    private static final String TAG = "HookActivityUtils8";
    private static final String EXTRA_ORIGIN_INTENT = "EXTRA_ORIGIN_INTENT";


    public static void hookStartActivity(Context context, Class<?> aClass) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Field singletonIActivityManagerField;

        //1.获取ActivityManager的Class对象
        //package android.app
        //public class ActivityManager
        Class<?> activityManagerClass = Class.forName("android.app.ActivityManager");

        //2.获取ActivityManager的私有属性IActivityManagerSingleton
        //private static final Singleton<IActivityManager> IActivityManagerSingleton
        singletonIActivityManagerField = activityManagerClass.getDeclaredField("IActivityManagerSingleton");
        singletonIActivityManagerField.setAccessible(true);

        //3.Singleton<IActivityManager> IActivityManagerSingleton
        //所有静态对象的反射可以通过传null获取。如果是实列必须传实例
        Object IActivityManagerSingletonObj = singletonIActivityManagerField.get(null);


        //4.获取Singleton<IActivityManager> IActivityManagerSingleton对象中的属性private T mInstance;

        //5.拿到该属性

        //获取Singleton类对象
        //package android.util
        //public abstract class Singleton<T> ,既class Singleton<IActivityManager>
        Class<?> singletonClass = Class.forName("android.util.Singleton");

        //获取mInstance属性
        //private T mInstance; 既IActivityManager mInstance
        Field mInstanceField = singletonClass.getDeclaredField("mInstance");

        //设置不检查
        mInstanceField.setAccessible(true);

        //从Singleton<IActivityManager> IActivityManagerSingleton对象中获取mInstance属性对应的值,既IActivityManager
        Object mInstanceIActivityManager = mInstanceField.get(IActivityManagerSingletonObj);


        //6.获取IActivityManager接口的类对象
        //package android.app
        //public interface IActivityManager

        Class<?> iActivityManagerClass = Class.forName("android.app.IActivityManager");

        Object iActivityManagerProxy = Proxy.newProxyInstance(
                HookAMS.class.getClassLoader(),
                new Class[]{iActivityManagerClass},
                new IActivityInvocationHandler(mInstanceIActivityManager, context, aClass)
        );

        //7.从新赋值
        //给mInstance属性,赋新值
        // Singleton<IActivityManager> IActivityManagerSingleton对象的属性private T mInstance赋新值
        mInstanceField.set(IActivityManagerSingletonObj, iActivityManagerProxy);


    }


    private static class IActivityInvocationHandler implements InvocationHandler {

        private Object mObject;
        private Class<?> aClass;
        private Context mContext;


        public IActivityInvocationHandler(Object object, Context context, Class<?> aClass) {
            this.mObject = object;
            this.aClass = aClass;
            this.mContext = context;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.d(TAG, "invoke :" + method.getName() + " args:" + Arrays.toString(args));
            if (method.getName().equals("startActivity")) {
                Log.d(TAG, "startActivity hook");
                // public int startActivity(IApplicationThread caller, String callingPackage, Intent intent,
                //            String resolvedType, IBinder resultTo, String resultWho, int requestCode, int flags,
                //            ProfilerInfo profilerInfo, Bundle options) throws RemoteException;

                //1.将启动的没有配置的Activity Intent,改为安全的Intent,就是配置了Activity的Intent
                Intent originIntent = (Intent) args[2];

                Intent safeIntent = new Intent(mContext, aClass);
                safeIntent.putExtra(EXTRA_ORIGIN_INTENT, originIntent);
                args[2] = safeIntent;

                //final H mH = new H();
                //hook Handler消息的处理,给Handler增加mCallback


            }
            return method.invoke(mObject, args);
        }
    }


    /**
     * 启动未注册的Activity
     */
    public static void hookLauncherActivity(Context context, Class<?> aClass, boolean isAppCompat) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //1.ActivityThread的Class对象
        //package android.app
        // public final class ActivityThread
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

        //2.获取ActivityThread 的属性mH
        //final H mH = new H();
        Field mHField = activityThreadClass.getDeclaredField("mH");
        mHField.setAccessible(true);

        //3.获取ActivityThread对象属性sCurrentActivityThread
        //private static ActivityThread sCurrentActivityThread;
        Field currentActivityThreadField = activityThreadClass.getDeclaredField("sCurrentActivityThread");
        currentActivityThreadField.setAccessible(true);

        //4.获取ActivityThread的对象(sCurrentActivityThread的值)
        Object activityThreadObj = currentActivityThreadField.get(null);


        //5.获取mH的值
        Object mHObject = mHField.get(activityThreadObj);


        //6.获取Handler的Class对象
        //package android.os
        //public class Handler
        Class<?> handlerClass = Class.forName("android.os.Handler");


        //7.获取mCallback属性
        //final Callback mCallback;
        Field mCallbackField = handlerClass.getDeclaredField("mCallback");
        mCallbackField.setAccessible(true);


        //8.给mH增加mCallback
        mCallbackField.set(mHObject, new HandlerCallback(context, aClass, isAppCompat));


    }

    private static class HandlerCallback implements Handler.Callback {
        private Context context;
        private Class<?> aClass;
        private boolean isAppCompat;

        public HandlerCallback(Context context, Class<?> aClass, boolean isAppCompat) {
            this.context = context;
            this.aClass = aClass;
            this.isAppCompat = isAppCompat;
        }

        @Override
        public boolean handleMessage(Message msg) {
            int what = msg.what;

            //ActivityThread.H.LAUNCH_ACTIVITY==100
            if (what == 100) {
                //final ActivityClientRecord r = (ActivityClientRecord) msg.obj;

                //1.从msg中获取ActivityClientRecord对象
                Object recordObj = msg.obj;


                try {
                    //2.获取ActivityClientRecord的intent属性
                    Field safeIntentField = recordObj.getClass().getDeclaredField("intent");
                    safeIntentField.setAccessible(true);

                    //3.获取ActivityClientRecord的intent属性的值,既安全的Intent
                    Intent safeIntent = (Intent) safeIntentField.get(recordObj);

                    //4.获取原始的Intent
                    Intent originIntent = safeIntent.getParcelableExtra(EXTRA_ORIGIN_INTENT);

                    if (originIntent == null) return false;

                    //5.将安全的Intent,替换为原始的Intent
                    //给ActivityClientRecord对象的intent属性,赋值为原始的Intent(originIntent)
                    safeIntentField.set(recordObj, originIntent);
                    try {
                        if (isAppCompat) {
                            hookPM(context, aClass);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }

            return false;
        }
    }

    private static void hookPM(Context context, Class<?> aClass) throws ClassNotFoundException, NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String pmName = getPMName(context);
        String hostClzName = aClass.getName();

        //1.获取ActivityThread的值
        Class<?> forName = Class.forName("android.app.ActivityThread");
        Field field = forName.getDeclaredField("sCurrentActivityThread");
        field.setAccessible(true);
        Object activityThread = field.get(null);


        //2.Hook getPackageManager方法
        //public static IPackageManager getPackageManager() {}
        Method getPackageManager = activityThread.getClass().getDeclaredMethod("getPackageManager");

        //3.获取getPackageManager方法的返回值IPackageManager
        Object iPackageManager = getPackageManager.invoke(activityThread);


        Class<?> iPackageManagerIntercept = Class.forName("android.content.pm.IPackageManager");

        Object iPackageManagerProxy = Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{iPackageManagerIntercept},
                new PackageManagerHandler(iPackageManager, pmName, hostClzName));

        //4.获取 sPackageManager 属性的Field
        //static volatile IPackageManager sPackageManager;
        Field iPackageManagerField = activityThread.getClass().getDeclaredField("sPackageManager");
        iPackageManagerField.setAccessible(true);

        //5.给ActivityThread的属性sPackageManager设置新的值
        iPackageManagerField.set(activityThread, iPackageManagerProxy);
    }

    private static class PackageManagerHandler implements InvocationHandler {
        private final String mPmName;
        private final String mHostClzName;
        private Object mActivityManagerObject;

        PackageManagerHandler(Object mActivityManagerObject, String pmName, String hostClzName) {
            this.mActivityManagerObject = mActivityManagerObject;
            mPmName = pmName;
            mHostClzName = hostClzName;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("getActivityInfo")) {
                ComponentName componentName = new ComponentName(mPmName, mHostClzName);
                args[0] = componentName;
            }
            return method.invoke(mActivityManagerObject, args);
        }
    }

    /**
     * 获取包名
     */
    private static String getPMName(Context context) {
        // 获取当前进程已经注册的 activity
        Context applicationContext = context.getApplicationContext();
        return applicationContext.getPackageName();
    }
}
