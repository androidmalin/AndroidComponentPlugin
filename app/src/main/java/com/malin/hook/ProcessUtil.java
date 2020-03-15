package com.malin.hook;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import java.util.List;

public final class ProcessUtil {

    private static String processName = null;
    private static String mPackageName = null;
    private static final String PACKAGE_NAME = "com.malin.hook";

    public static boolean isMainProcess(Context context) {
        String processName = getAppMainProcessName(context);
        String packageName = getAppPackageName(context);
        return !TextUtils.isEmpty(processName) && !TextUtils.isEmpty(packageName) && packageName.equals(processName);
    }

    /**
     * 获取APP的包名
     *
     * @return AppPackageName
     */
    private static String getAppPackageName(Context context) {
        if (!TextUtils.isEmpty(mPackageName)) return mPackageName;
        mPackageName = context.getPackageName();
        if (!TextUtils.isEmpty(mPackageName)) return mPackageName;
        mPackageName = PACKAGE_NAME;
        return context.getPackageName();
    }

    /**
     * 获取APP主进程的Name
     *
     * @return APP主进程的Name
     */
    private static String getAppMainProcessName(Context context) {
        if (processName != null) return processName;
        processName = getProcessNameViaManager(context);
        if (!TextUtils.isEmpty(processName)) return processName;
        return null;
    }

    /**
     * 获取进程名
     *
     * @return APP主进程的Name
     */
    public static String getProcessNameViaManager(Context context) {
        int myPid = android.os.Process.myPid();
        if (myPid <= 0) return null;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) return null;
        List<ActivityManager.RunningAppProcessInfo> runningApps = activityManager.getRunningAppProcesses();
        if (runningApps == null || runningApps.isEmpty()) return null;
        try {
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo != null && procInfo.pid == myPid) {
                    return procInfo.processName;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}