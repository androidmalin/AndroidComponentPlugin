package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;

import java.lang.reflect.Method;
import java.util.List;

public class ProcessUtil {


    private static String currentProcessName;

    /**
     * 当前进程名
     */
    public static String getCurrentProcessName(Context context) {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }

        //1.通过Application的API获取当前进程名
        currentProcessName = getCurrentProcessNameByApplication();
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }

        //2.通过反射ActivityThread获取当前进程名
        currentProcessName = getCurrentProcessNameByActivityThread();
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }

        //3.通过ActivityManager获取当前进程名
        currentProcessName = getCurrentProcessNameByActivityManager(context);

        return currentProcessName;
    }


    /**
     * 通过Application新的API获取进程名，无需反射，无需IPC，效率最高。
     */
    public static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            return Application.getProcessName();
        }
        return null;
    }

    /**
     * 通过反射ActivityThread获取进程名，避免了ipc
     * <p>
     * 4.3.1开始有这个方法
     * https://cs.android.com/android/platform/superproject/+/android-4.3.1_r1:frameworks/base/core/java/android/app/ActivityThread.java;l=1601
     * <p>
     * 11.0.0
     * https://cs.android.com/android/platform/superproject/+/android-11.0.0_r9:frameworks/base/core/java/android/app/ActivityThread.java;l=2171
     */
    @SuppressLint("DiscouragedPrivateApi,PrivateApi")
    public static String getCurrentProcessNameByActivityThread() {
        String processName = null;
        try {
            final Method currentProcessNameMethod = Class.forName(
                    "android.app.ActivityThread",
                    false,
                    Application.class.getClassLoader()
            ).getDeclaredMethod("currentProcessName");
            currentProcessNameMethod.setAccessible(true);
            final Object processNameObj = currentProcessNameMethod.invoke(null);
            if (processNameObj instanceof String) {
                processName = (String) processNameObj;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return processName;
    }

    /**
     * 通过ActivityManager 获取进程名，需要IPC通信
     */
    public static String getCurrentProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        int pid = Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) return null;
        List<ActivityManager.RunningAppProcessInfo> runningAppList = am.getRunningAppProcesses();
        if (runningAppList == null || runningAppList.isEmpty()) return null;
        for (ActivityManager.RunningAppProcessInfo processInfo : runningAppList) {
            if (processInfo.pid == pid) {
                return processInfo.processName;
            }
        }
        return null;
    }
}
