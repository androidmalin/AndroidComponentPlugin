package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 启动插件中的Service,需要Hook AMS, 拦截startService,stopService方法,进行代理转发
 */
@SuppressLint("PrivateApi")
class HookAMSForServicePlugin {

    static final String EXTRA_TARGET_INTENT = "service_extra_target_intent";

    /**
     * Hook AMS
     * 主要完成的操作是  "把真正要启动的Service临时替换为在AndroidManifest.xml中声明的替身Service"
     * 进而骗过AMS
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    static void hookActivityManager() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field iActivityManagerSingletonFiled;
        if (Build.VERSION.SDK_INT >= 26) {
            Class<?> activityManagerClazz = Class.forName("android.app.ActivityManager");
            iActivityManagerSingletonFiled = activityManagerClazz.getDeclaredField("IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNativeClazz = Class.forName("android.app.ActivityManagerNative");
            iActivityManagerSingletonFiled = activityManagerNativeClazz.getDeclaredField("gDefault");
        }
        iActivityManagerSingletonFiled.setAccessible(true);

        //private static final Singleton<IActivityManager> IActivityManagerSingleton
        Object iActivityManagerSingletonObj = iActivityManagerSingletonFiled.get(null);

        Class<?> singletonClazz = Class.forName("android.util.Singleton");
        Field mInstanceField = singletonClazz.getDeclaredField("mInstance");
        mInstanceField.setAccessible(true);

        Object rawIActivityManager = mInstanceField.get(iActivityManagerSingletonObj);

        // 创建一个这个对象的代理对象, 然后替换这个字段, 让我们的代理对象帮忙干活
        Class<?> iActivityManagerClazz = Class.forName("android.app.IActivityManager");
        Object iActivityManagerProxy = Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{iActivityManagerClazz},
                new IActivityManagerHandler(rawIActivityManager));
        mInstanceField.set(iActivityManagerSingletonObj, iActivityManagerProxy);
    }

    private static class IActivityManagerHandler implements InvocationHandler {
        private static final String TAG = "IActivityManagerHandler";

        private final Object mIActivityManagerBase;

        IActivityManagerHandler(Object base) {
            mIActivityManagerBase = base;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if ("startService".equals(method.getName())) {
                // 只拦截这个方法
                // public ComponentName startService(IApplicationThread caller, Intent service,String resolvedType, int userId) throws RemoteException

                // 找到参数里面的第一个Intent 对象,返回该Intent的索引和该Intent对象
                Pair<Integer, Intent> integerIntentPair = foundFirstIntentOfArgs(args);
                Intent proxyIntent = new Intent();

                // 代理Service的包名, 也就是我们自己的包名
                String proxyPackage = MApplication.getInstance().getPackageName();

                // 这里我们把启动的Service替换为ProxyService, 让ProxyService接收生命周期回调
                ComponentName proxyComponentName = new ComponentName(proxyPackage, PluginProxyService.class.getName());
                proxyIntent.setComponent(proxyComponentName);

                // 把我们原始要启动的TargetService先存起来
                proxyIntent.putExtra(HookAMSForServicePlugin.EXTRA_TARGET_INTENT, integerIntentPair.second);

                // 替换掉Intent, 达到欺骗AMS的目的
                args[integerIntentPair.first] = proxyIntent;

                Log.d(TAG, "hook method startService success");
                return method.invoke(mIActivityManagerBase, args);
            }

            // public int stopService(IApplicationThread caller, Intent service,String resolvedType, int userId) throws RemoteException
            if ("stopService".equals(method.getName())) {
                Intent raw = foundFirstIntentOfArgs(args).second;
                if (raw != null && raw.getComponent() != null &&
                        !TextUtils.equals(MApplication.getInstance().getPackageName(), raw.getComponent().getPackageName())) {
                    // 插件的intent才做hook
                    Log.d(TAG, "hook method stopService success");
                    return ServiceManager.getInstance().stopService(raw);
                }
            }
            return method.invoke(mIActivityManagerBase, args);
        }

        /**
         * 找到参数里面的第一个Intent 对象,返回该Intent的索引和该Intent对象
         */
        private Pair<Integer, Intent> foundFirstIntentOfArgs(Object... args) {
            int index = 0;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Intent) {
                    index = i;
                    break;
                }
            }
            if (args[index] instanceof Intent) {
                return Pair.create(index, (Intent) args[index]);
            } else {
                return Pair.create(index, null);
            }
        }
    }
}
