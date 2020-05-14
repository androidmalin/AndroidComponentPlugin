package com.malin.hook;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dalvik.system.BaseDexClassLoader;

/**
 * author: androidmalin
 * date: 2020.5.3 17:00
 * https://developer.android.com/reference/java/lang/reflect/Proxy
 * https://medium.com/@setu677/instantiating-interfaces-in-java-94a22dcf37f
 */
public class BaseDexClassLoaderReporter {

    @SuppressWarnings("JavaReflectionMemberAccess")
    public static void setReporterHook() {

        try {
            //0.Reporter class
            Class<?> reporterClazz = Class.forName("dalvik.system.BaseDexClassLoader$Reporter");

            //1.setReporter
            //public static void setReporter(Reporter newReporter) {}
            Method setReporterMethod = BaseDexClassLoader.class.getDeclaredMethod("setReporter", reporterClazz);
            setReporterMethod.setAccessible(true);

            //2.make a proxy Reporter
            // newProxyInstance:返回指定接口的代理类的实例,将方法调用分派到指定的调用处理程序。
            // ClassLoader loader: 定义代理类的classLoader
            // Class<?>[] interfaces: 代理类要实现的接口列表
            // InvocationHandler h: 帮助proxy的类,proxy会把调用转发给它处理.
            Object reportProxy = Proxy.newProxyInstance(
                    Thread.currentThread().getContextClassLoader(),
                    new Class[]{reporterClazz},
                    new ReportInvocationHandler()
            );

            //3.invoke
            setReporterMethod.invoke(null, reportProxy);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static class ReportInvocationHandler implements InvocationHandler {

        ReportInvocationHandler() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            String TAG = "ReportInvocationHandler";
            Log.d(TAG, "method:" + method.toString());
            Log.d(TAG, "List<ClassLoader> classLoadersChain:" + args[0]);
            Log.d(TAG, "List<String> classPaths:" + args[1]);
            return null;
        }
    }

    //method:
    //public abstract void dalvik.system.BaseDexClassLoader$Reporter.report(java.util.List,java.util.List)

    //CustomClassLoader-->DexClassLoader-->BaseDexClassLoader-->ClassLoader
    //------------------>PathClassLoader-->BaseDexClassLoader-->ClassLoaders

    //args1:
    //[
    //    com.malin.hook.CustomClassLoader[
    //        DexPathList[
    //            [
    //                zipfile"/data/user/0/com.malin.hook/files/pluginBroadcastReceiver-debug-1.0.apk"
    //            ],
    //            nativeLibraryDirectories=[
    //                /data/user/0/com.malin.hook/files/plugin/com.malin.receiver.plugin/lib,
    //                /system/lib64,
    //                /product/lib64
    //            ]
    //        ]
    //    ],
    //    dalvik.system.PathClassLoader[
    //        DexPathList[
    //            [
    //                zipfile"/data/app/com.malin.hook-uAmYjE3L9KLgAaIVQcHlLQ==/base.apk"
    //            ],
    //            nativeLibraryDirectories=[
    //                /data/app/com.malin.hook-uAmYjE3L9KLgAaIVQcHlLQ==/lib/arm64,
    //                /system/lib64,
    //                /product/lib64
    //            ]
    //        ]
    //    ]
    //]

    //args2:
    //[
    //    /data/user/0/com.malin.hook/files/pluginBroadcastReceiver-debug-1.0.apk,
    //    /data/app/com.malin.hook-uAmYjE3L9KLgAaIVQcHlLQ==/base.apk
    //]
}
