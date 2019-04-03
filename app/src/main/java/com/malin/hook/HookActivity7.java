package com.malin.hook;

import android.annotation.SuppressLint;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * malin
 * 反射
 * https://www.cnblogs.com/chanshuyi/p/head_first_of_reflection.html
 * https://blog.csdn.net/jiangwei0910410003/article/details/52550147
 * <android 8.0以下的Hook
 */
@SuppressLint("PrivateApi")
public class HookActivity7 {
    private static final String TAG = "HookActivityUtils";


    public static void hookStartActivity() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        //1.获取ActivityManagerNative的Class对象
        //package android.app
        //public abstract class ActivityManagerNative
        Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");

        //2.获取 ActivityManagerNative的 私有属性gDefault
        // private static final Singleton<IActivityManager> gDefault
        Field singletonField = activityManagerNativeClass.getDeclaredField("gDefault");

        //3.对私有属性gDefault,解除私有限定
        singletonField.setAccessible(true);

        //4.获得gDefaultField中对应的属性值(被static修饰了),既得到Singleton<IActivityManager>对象的实例
        //所有静态对象的反射可以通过传null获取
        //private static final Singleton<IActivityManager> gDefault
        Object singletonObj = singletonField.get(null);


        //Log for test
        Log.d(TAG, "clActivityManagerNative getPackage().getName :" + activityManagerNativeClass.getPackage().getName());
        Log.d(TAG, "clActivityManagerNative getCanonicalName :" + activityManagerNativeClass.getCanonicalName());
        Log.d(TAG, "gDefaultField type:" + singletonField.getType().getCanonicalName());
        Log.d(TAG, "gDefaultField name:" + singletonField.getName());
        Log.d(TAG, "gDefaultField isStatic:" + Modifier.isStatic(singletonField.getModifiers()));


        //获取Singleton<IActivityManager>对象gDefault的属性mInstance的值,既IActivityManager

        //1.获取Singleton的Class对象
        //package android.util
        //public abstract class Singleton<IActivityManager>
        Class<?> singletonClass = Class.forName("android.util.Singleton");

        //2.获取 Singleton的 私有属性mInstance,既IActivityManager
        //private T mInstance;
        Field iActivityManagerField = singletonClass.getDeclaredField("mInstance");

        //3.对私有属性mInstance,解除私有限定
        iActivityManagerField.setAccessible(true);

        //4.从属性mInstance, 获取IActivityManager
        //private IActivityManager mInstance;
        //从gDefault(Singleton<IActivityManager> gDefault)实例中获取属性mInstance对应的值(IActivityManager)
        Object rawIActivityManager = iActivityManagerField.get(singletonObj);

        //5.获取IActivityManager接口的类对象
        Class<?> iActivityManagerClass = Class.forName("android.app.IActivityManager");

        //6.动态代理
        Object iActivityManagerProxy = Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{iActivityManagerClass},
                new ActivityManagerInvocationHandler(rawIActivityManager)
        );

        //7.给gDefault对象的mInstance属性设置值为iActivityManagerProxy
        //给private static final Singleton<IActivityManager> gDefault对象的private T mInstance属性设置值 iActivityManagerProxy
        //field.set(Object obj, Object value)	设置obj中对应属性field的值
        //Field代表类的成员变量（成员变量也称为类的属性）
        iActivityManagerField.set(singletonObj, iActivityManagerProxy);

    }

    private static class ActivityManagerInvocationHandler implements InvocationHandler {

        private Object mObject;

        public ActivityManagerInvocationHandler(Object object) {
            this.mObject = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("startActivity")) {
                Log.d(TAG, "invoke:" + method.getName() + " args:" + Arrays.toString(args));
            }
            return method.invoke(mObject, args);
        }
    }
}
