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
     * 主要完成的操作是  "把真正要启动的Activity临时替换为在AndroidManifest.xml中声明的替身Activity"
     * 进而骗过AMS
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    static void hookActivityManagerNative() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field gDefaultField;
        if (Build.VERSION.SDK_INT >= 26) {
            Class<?> activityManager = Class.forName("android.app.ActivityManager");
            gDefaultField = activityManager.getDeclaredField("IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
            gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        }
        gDefaultField.setAccessible(true);

        Object gDefault = gDefaultField.get(null);

        // gDefault是一个 android.util.Singleton对象; 我们取出这个单例里面的字段
        Class<?> singleton = Class.forName("android.util.Singleton");
        Field mInstanceField = singleton.getDeclaredField("mInstance");
        mInstanceField.setAccessible(true);

        // ActivityManagerNative 的gDefault对象里面原始的 IActivityManager对象
        Object rawIActivityManager = mInstanceField.get(gDefault);

        // 创建一个这个对象的代理对象, 然后替换这个字段, 让我们的代理对象帮忙干活
        Class<?> iActivityManagerInterface = Class.forName("android.app.IActivityManager");
        Object proxy = Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{iActivityManagerInterface},
                new IActivityManagerHandler(rawIActivityManager));
        mInstanceField.set(gDefault, proxy);
    }

    private static class IActivityManagerHandler implements InvocationHandler {
        private static final String TAG = "IActivityManagerHandler";

        private Object mBase;

        IActivityManagerHandler(Object base) {
            mBase = base;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if ("startService".equals(method.getName())) {
                // 只拦截这个方法
                // API 23:
                // public ComponentName startService(IApplicationThread caller, Intent service,String resolvedType, int userId) throws RemoteException

                // 找到参数里面的第一个Intent 对象
                Pair<Integer, Intent> integerIntentPair = foundFirstIntentOfArgs(args);
                Intent newIntent = new Intent();

                // 代理Service的包名, 也就是我们自己的包名
                String stubPackage = MApplication.getInstance().getPackageName();

                // 这里我们把启动的Service替换为ProxyService, 让ProxyService接收生命周期回调
                ComponentName componentName = new ComponentName(stubPackage, PluginProxyService.class.getName());
                newIntent.setComponent(componentName);

                // 把我们原始要启动的TargetService先存起来
                newIntent.putExtra(HookAMSForServicePlugin.EXTRA_TARGET_INTENT, integerIntentPair.second);

                // 替换掉Intent, 达到欺骗AMS的目的
                args[integerIntentPair.first] = newIntent;

                Log.v(TAG, "hook method startService success");
                return method.invoke(mBase, args);
            }

            // public int stopService(IApplicationThread caller, Intent service,String resolvedType, int userId) throws RemoteException
            if ("stopService".equals(method.getName())) {
                Intent raw = foundFirstIntentOfArgs(args).second;
                if (!TextUtils.equals(MApplication.getInstance().getPackageName(), raw.getComponent().getPackageName())) {
                    // 插件的intent才做hook
                    Log.v(TAG, "hook method stopService success");
                    return ServiceManager.getInstance().stopService(raw);
                }
            }
            return method.invoke(mBase, args);
        }

        private Pair<Integer, Intent> foundFirstIntentOfArgs(Object... args) {
            int index = 0;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Intent) {
                    index = i;
                    break;
                }
            }
            return Pair.create(index, (Intent) args[index]);
        }
    }
}
