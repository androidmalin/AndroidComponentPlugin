package com.malin.hook;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;

import java.lang.reflect.Field;

/**
 * fixApplicationInfo
 * come from DroidPlugin
 * String path = MApplication.getInstance().getFileStreamPath("pluginContentProvider-debug.apk").getPath();
 * ApplicationInfoUtil.fixApplicationInfo(providerInfo.applicationInfo, path);
 * if (TextUtils.isEmpty(providerInfo.processName)) {
 * providerInfo.processName = providerInfo.packageName;
 * }
 */
class ApplicationInfoUtil {

    @SuppressWarnings("JavaReflectionMemberAccess")
    static void fixApplicationInfo(ApplicationInfo applicationInfo, String pluginFilePath) {
        if (applicationInfo.sourceDir == null) applicationInfo.sourceDir = pluginFilePath;
        if (applicationInfo.publicSourceDir == null)
            applicationInfo.publicSourceDir = pluginFilePath;
        if (applicationInfo.dataDir == null)
            applicationInfo.dataDir = MApplication.getInstance().getApplicationInfo().dataDir;

        try {
            Class<?> applicationInfoClazz = Class.forName("android.content.pm.ApplicationInfo");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //1.scanSourceDir
                Field scanSourceDirFiled = applicationInfoClazz.getDeclaredField("scanSourceDir");
                scanSourceDirFiled.setAccessible(true);
                scanSourceDirFiled.set(applicationInfo, applicationInfo.dataDir);

                //2.scanPublicSourceDir
                Field scanPublicSourceDirFiled = applicationInfoClazz.getDeclaredField("scanPublicSourceDir");
                scanPublicSourceDirFiled.setAccessible(true);
                scanPublicSourceDirFiled.set(applicationInfo, applicationInfo.dataDir);


                //3.splitSourceDirs
                if (applicationInfo.splitSourceDirs == null) {
                    applicationInfo.splitSourceDirs = new String[]{pluginFilePath};
                }

                //4.splitPublicSourceDirs
                if (applicationInfo.splitPublicSourceDirs == null) {
                    applicationInfo.splitPublicSourceDirs = new String[]{pluginFilePath};
                }
            }

            applicationInfo.uid = MApplication.getInstance().getApplicationInfo().uid;
            if (applicationInfo.nativeLibraryDir == null) {
                applicationInfo.nativeLibraryDir = MApplication.getInstance().getApplicationInfo().nativeLibraryDir;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                try {
                    if (Build.VERSION.SDK_INT < 26) {
                        //deviceEncryptedDataDir
                        Field deviceEncryptedDataDirFiled = applicationInfoClazz.getDeclaredField("deviceEncryptedDataDir");
                        deviceEncryptedDataDirFiled.setAccessible(true);
                        deviceEncryptedDataDirFiled.set(applicationInfo, applicationInfo.dataDir);

                        //credentialEncryptedDataDir
                        Field credentialEncryptedDataDirFiled = applicationInfoClazz.getDeclaredField("credentialEncryptedDataDir");
                        credentialEncryptedDataDirFiled.setAccessible(true);
                        credentialEncryptedDataDirFiled.set(applicationInfo, applicationInfo.dataDir);
                    }

                    //deviceProtectedDataDir
                    Field deviceProtectedDataDirFiled = applicationInfoClazz.getDeclaredField("deviceProtectedDataDir");
                    deviceProtectedDataDirFiled.setAccessible(true);
                    deviceProtectedDataDirFiled.set(applicationInfo, applicationInfo.dataDir);

                    //credentialProtectedDataDir
                    Field credentialProtectedDataDirFiled = applicationInfoClazz.getDeclaredField("credentialProtectedDataDir");
                    credentialProtectedDataDirFiled.setAccessible(true);
                    credentialProtectedDataDirFiled.set(applicationInfo, applicationInfo.dataDir);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(applicationInfo.processName)) {
                applicationInfo.processName = applicationInfo.packageName;
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
