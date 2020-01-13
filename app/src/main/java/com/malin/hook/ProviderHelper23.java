package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("PrivateApi")
class ProviderHelper23 {

    private static final String TAG = "ProviderHelper";

    /**
     * 在进程内部安装provider, 也就是调用 ActivityThread.installContentProviders方法
     */
    @SuppressLint("DiscouragedPrivateApi")
    static void installProviders(Context context, File apkFile) {
        try {
            List<ProviderInfo> providerInfoList = parseProviders(apkFile);
            if (providerInfoList == null) {
                Log.e(TAG, "providerInfoList==null");
                return;
            }

            for (ProviderInfo providerInfo : providerInfoList) {
                providerInfo.applicationInfo.packageName = context.getPackageName();
            }
            Log.d(TAG, providerInfoList.toString());

            Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);

            Object currentActivityThread = currentActivityThreadMethod.invoke(null);

            //private void installContentProviders(Context context, List<ProviderInfo> providers) {
            Method installProvidersMethod = activityThreadClass.getDeclaredMethod("installContentProviders", Context.class, List.class);
            installProvidersMethod.setAccessible(true);

            installProvidersMethod.invoke(currentActivityThread, context, providerInfoList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析Apk文件中的 <provider>, 并存储起来
     * 主要是调用PackageParser类的generateProviderInfo方法
     *
     * @param apkFile 插件对应的apk文件
     */
    @SuppressLint("DiscouragedPrivateApi")
    @SuppressWarnings("JavaReflectionMemberAccess")
    private static List<ProviderInfo> parseProviders(File apkFile) {
        try {
            Class<?> packageParserClass = Class.forName("android.content.pm.PackageParser");

            // public Package parsePackage(File packageFile, int flags){}//api-23
            Method parsePackageMethod = packageParserClass.getDeclaredMethod("parsePackage", File.class, int.class);
            parsePackageMethod.setAccessible(true);

            //public PackageParser() {}//api-23默认构造方法
            Object packageParser = packageParserClass.newInstance();

            // 首先调用parsePackage获取到apk对象对应的Package对象
            Object packageObj = parsePackageMethod.invoke(packageParser, apkFile, PackageManager.GET_PROVIDERS);
            if (packageObj == null) return null;

            //android.content.pm.PackageParser$Package
            // 读取Package对象里面的services字段
            // 接下来要做的就是根据这个List<Provider> 获取到Provider对应的ProviderInfo
            //public final ArrayList<Provider> providers = new ArrayList<Provider>(0);
            Field providersField = packageObj.getClass().getDeclaredField("providers");
            List<?> providers = (List<?>) providersField.get(packageObj);

            if (providers == null) {
                Log.e(TAG, "providers == null");
                return null;
            }

            // 调用generateProviderInfo 方法, 把PackageParser.Provider转换成ProviderInfo
            Class<?> packageParser$ProviderClass = Class.forName("android.content.pm.PackageParser$Provider");
            Class<?> packageUserStateClass = Class.forName("android.content.pm.PackageUserState");
            Class<?> userHandler = Class.forName("android.os.UserHandle");

            //public static final int getCallingUserId(){}
            Method getCallingUserIdMethod = userHandler.getDeclaredMethod("getCallingUserId");
            getCallingUserIdMethod.setAccessible(true);

            Object userIdObj = getCallingUserIdMethod.invoke(null);
            if (!(userIdObj instanceof Integer)) return null;
            int userId = (Integer) userIdObj;

            //public PackageUserState() {}//api-23默认构造方法
            Object defaultUserState = packageUserStateClass.newInstance();
            // 需要调用 android.content.pm.PackageParser#generateProviderInfo
            //public static final ProviderInfo generateProviderInfo(Provider p, int flags,PackageUserState state, int userId) {}//api-23
            Method generateProviderInfo = packageParserClass.getDeclaredMethod(
                    "generateProviderInfo", packageParser$ProviderClass, int.class, packageUserStateClass, int.class);
            generateProviderInfo.setAccessible(true);

            List<ProviderInfo> ret = new ArrayList<>();
            // 解析出intent对应的Provider组件
            for (Object service : providers) {
                ProviderInfo info = (ProviderInfo) generateProviderInfo.invoke(packageParser, service, 0, defaultUserState, userId);
                ret.add(info);
            }
            return ret;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}