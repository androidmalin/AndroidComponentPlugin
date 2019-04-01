package com.malin.hook;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * malin
 * 反射
 * https://www.cnblogs.com/chanshuyi/p/head_first_of_reflection.html
 * >=android 8.0以上的Hook
 */
@SuppressLint("PrivateApi")
public class HookActivity8 {
    private static final String TAG = "HookActivityUtils8";


    public static void hookStartActivity() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Field singletonIActivityManagerField;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //1.获取ActivityManager的Class对象
            //package android.app
            //public class ActivityManager
            Class<?> activityManagerClass = Class.forName("android.app.ActivityManager");

            //2.获取ActivityManager的私有属性IActivityManagerSingleton
            //private static final Singleton<IActivityManager> IActivityManagerSingleton
            singletonIActivityManagerField = activityManagerClass.getDeclaredField("IActivityManagerSingleton");
            singletonIActivityManagerField.setAccessible(true);

            //3.Singleton<IActivityManager> IActivityManagerSingleton
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
                    new IActivityInvocationHandler(mInstanceIActivityManager)
            );

            //7.从新赋值
            //给mInstance属性,赋新值
            // Singleton<IActivityManager> IActivityManagerSingleton对象的属性private T mInstance赋新值
            mInstanceField.set(IActivityManagerSingletonObj, iActivityManagerProxy);

        }

    }


    private static class IActivityInvocationHandler implements InvocationHandler {

        private Object mObject;

        public IActivityInvocationHandler(Object object) {
            this.mObject = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.d(TAG, "invoke :" + method.getName() + " args:" + Arrays.toString(args));
            if (method.getName().equals("startActivity")) {
                Log.d(TAG, "startActivity hook");
            }
            return method.invoke(mObject, args);
        }
    }
}
