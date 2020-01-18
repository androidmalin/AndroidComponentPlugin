package com.malin.hook;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代码参考《Android进阶解密》
 */
@SuppressWarnings("JavaReflectionMemberAccess")
@SuppressLint("PrivateApi")
class HookService {

    static void hookAMSForService(Context context) {
        try {
            Object IActivityManagerSingletonObj;
            //1.IActivityManagerSingleton
            if (Build.VERSION.SDK_INT >= 26) {
                Class<?> activityManagerClass = Class.forName("android.app.ActivityManager");
                Field iActivityManagerSingletonField = activityManagerClass.getDeclaredField("IActivityManagerSingleton");
                iActivityManagerSingletonField.setAccessible(true);
                IActivityManagerSingletonObj = iActivityManagerSingletonField.get(null);
            } else {
                Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
                Field gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
                gDefaultField.setAccessible(true);
                IActivityManagerSingletonObj = gDefaultField.get(null);
            }

            //2.IActivityManager
            Class<?> singletonClass = Class.forName("android.util.Singleton");
            Field mInstanceField = singletonClass.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);
            Object iActivityManagerObj = mInstanceField.get(IActivityManagerSingletonObj);


            //3. IActivityManagerProxy
            Class<?> iActivityManagerClass = Class.forName("android.app.IActivityManager");

            Object proxy = Proxy.newProxyInstance(
                    Thread.currentThread().getContextClassLoader(),
                    new Class<?>[]{iActivityManagerClass},
                    new IActivityManagerProxy(context, iActivityManagerObj, ProxyService.class)
            );

            //4.重新设置新值
            mInstanceField.set(IActivityManagerSingletonObj, proxy);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static class IActivityManagerProxy implements InvocationHandler {
        private Context mContext;
        private Object mActivityManager;
        private Class<?> mStubServiceClass;

        IActivityManagerProxy(Context context, Object activityManager, Class<?> proxyServiceClass) {
            mContext = context;
            mActivityManager = activityManager;
            mStubServiceClass = proxyServiceClass;
        }

        @SuppressWarnings("ConstantConditions")
        @Override
        public Object invoke(Object o, Method method, Object[] args) throws Throwable {
            //public android.content.ComponentName startService(android.app.IApplicationThread caller, android.content.Intent service, java.lang.String resolvedType, boolean requireForeground, java.lang.String callingPackage, int userId) throws android.os.RemoteException;
            if ("startService".equals(method.getName())) {
                Intent intent;
                int index = 1;
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof Intent) {
                        index = i;
                        break;
                    }
                }
                intent = (Intent) args[index];
                Intent proxyIntent = new Intent(mContext, mStubServiceClass);
                proxyIntent.putExtra(ProxyService.TARGET_SERVICE, intent.getComponent().getClassName());
                args[index] = proxyIntent;
            }
            return method.invoke(mActivityManager, args);
        }
    }
}
