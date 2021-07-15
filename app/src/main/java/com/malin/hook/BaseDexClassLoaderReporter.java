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
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String TAG = "ReportInvocationHandler";
            Log.e(TAG, "method:" + method.getName());
            Log.e(TAG, "args1:" + args[0]);
            Log.e(TAG, "args2:" + args[1]);
            return null;
        }
    }

    //args1:
    //[
    //   com.malin.hook.CustomClassLoader
    //       [DexPathList[[zip file "/data/user/0/com.malin.hook/files/pluginBroadcastReceiver-debug-1.0.apk"],
    //       nativeLibraryDirectories=[/data/user/0/com.malin.hook/files/plugin/com.malin.receiver.plugin/lib, /system/lib64, /vendor/lib64]]
    // ],

    // dalvik.system.PathClassLoader
    // [
    //  DexPathList[
    //      [
    //          zip file "/data/user/0/com.malin.hook/files/pluginActivity-debug-1.0.apk",
    //          zip file "/data/user/0/com.malin.hook/files/pluginService-debug-1.0.apk",
    //          zip file "/data/app/com.malin.hook-M1sKKjgi0kgdrmfkM6B4iA==/base.apk"
    //      ],
    //      nativeLibraryDirectories=[/data/app/com.malin.hook-M1sKKjgi0kgdrmfkM6B4iA==/lib/arm64, /system/lib64, /vendor/lib64]
    //          ]
    // ]]

    //args2:
    //[
    // /data/user/0/com.malin.hook/files/pluginBroadcastReceiver-debug-1.0.apk,
    // /data/user/0/com.malin.hook/files/pluginActivity-debug-1.0.apk:
    // /data/user/0/com.malin.hook/files/pluginService-debug-1.0.apk:
    // /data/app/com.malin.hook-M1sKKjgi0kgdrmfkM6B4iA==/base.apk
    // ]
}
