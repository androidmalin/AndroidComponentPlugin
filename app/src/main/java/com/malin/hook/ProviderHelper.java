package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.PatternMatcher;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 目前的bug是:
 * 当target>=26时, java.lang.SecurityException: Failed to find provider com.malin.auth.xx for user 0; expected to find a valid ContentProvider for this authority
 * target>=26;崩溃的问题;调试方法
 * 在ComponentResolver类的ProviderInfo queryProvider(String authority, int flags, int userId) {}方法增加断点;
 * 在模拟器上运行,给system_server进程断点;查看发现;调用方法queryProvider时全局变量mProvidersByAuthority中没有插件的Authority;
 * 方法返回值为null;在外层调用处,进行了版本判断,target>=26;就异常了;
 * mProvidersByAuthority变量的赋值在系统进程中;目前没有解决办法了;
 */
@SuppressLint("PrivateApi")
class ProviderHelper {

    private static final String TAG = "ProviderHelper";

    /**
     * 在进程内部安装provider, 也就是调用 ActivityThread.installContentProviders方法
     */
    @SuppressLint("DiscouragedPrivateApi")
    static void installProviders(Context context, File apkFile) {
        try {

            //1.get ProviderInfo
            List<ProviderInfo> providerInfoList = parseProviders(apkFile);
            if (providerInfoList == null) {
                Log.d(TAG, "providerInfoList==null");
                return;
            }

            int i = 0;
            //2.set packageName
            for (ProviderInfo providerInfo : providerInfoList) {
                providerInfo.applicationInfo.packageName = context.getPackageName();
                printProviderInfo(providerInfo, i);
                i++;
            }
            Log.d(TAG, providerInfoList.toString());

            //3.get currentActivityThread
            Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadMethod = activityThreadClazz.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);
            Object currentActivityThread = currentActivityThreadMethod.invoke(null);


            //4.call ActivityThread#installContentProviders()
            //private void installContentProviders(Context context, List<ProviderInfo> providers) {}//15=<api<=29
            Method installContentProvidersMethod = activityThreadClazz.getDeclaredMethod("installContentProviders", Context.class, List.class);
            installContentProvidersMethod.setAccessible(true);
            installContentProvidersMethod.invoke(currentActivityThread, context, providerInfoList);
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
            int version = Build.VERSION.SDK_INT;
            if (version < 15) return null;
            //1.获取PackageParser的Class对象
            //package android.content.pm
            //public class PackageParser
            Class<?> packageParserClazz = Class.forName("android.content.pm.PackageParser");

            //2.获取parsePackage()方法的Method
            Method parsePackageMethod;
            if (Build.VERSION.SDK_INT >= 20) {
                //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//21=<api<=29
                parsePackageMethod = packageParserClazz.getDeclaredMethod("parsePackage", File.class, int.class);
            } else {
                //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//15=<api<=19
                // 15<=Build.VERSION.SDK_INT <=19
                parsePackageMethod = packageParserClazz.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, int.class);
            }
            parsePackageMethod.setAccessible(true);

            //3.生成PackageParser对象实例
            Object packageParser;
            if (Build.VERSION.SDK_INT >= 20) {
                packageParser = packageParserClazz.newInstance();
            } else {
                // 15<=Build.VERSION.SDK_INT <=19
                //public PackageParser(String archiveSourcePath) {}//15=<api<=19
                Constructor<?> constructor = packageParserClazz.getDeclaredConstructor(String.class);
                constructor.setAccessible(true);
                String archiveSourcePath = apkFile.getCanonicalPath();
                packageParser = constructor.newInstance(archiveSourcePath);
            }

            //4.调用parsePackage获取到apk对象对应的Package对象(return information about intent receivers in the package)
            //Package为PackageParser的内部类;public final static class Package implements Parcelable {}
            Object packageObj;
            if (Build.VERSION.SDK_INT >= 20) {
                //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//21=<api<=29
                packageObj = parsePackageMethod.invoke(packageParser, apkFile, PackageManager.GET_PROVIDERS);
            } else {
                // 15<=Build.VERSION.SDK_INT <=19
                String destCodePath = apkFile.getCanonicalPath();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayMetrics.setToDefaults();

                //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//15=<api<=19
                packageObj = parsePackageMethod.invoke(packageParser, apkFile, destCodePath, displayMetrics, PackageManager.GET_PROVIDERS);
            }

            if (packageObj == null) return null;

            //android.content.pm.PackageParser$Package
            // 读取Package对象里面的providers字段
            // 接下来要做的就是根据这个List<Provider> 获取到Provider对应的ProviderInfo
            //public final ArrayList<Provider> providers = new ArrayList<Provider>(0);
            Field providersField = packageObj.getClass().getDeclaredField("providers");
            List<?> providers = (List<?>) providersField.get(packageObj);

            if (providers == null) {
                Log.d(TAG, "providers == null");
                return null;
            }


            Class<?> packageParser$ProviderClazz = Class.forName("android.content.pm.PackageParser$Provider");


            //5.call generateProviderInfo()
            //public static final ProviderInfo generateProviderInfo(Provider p, int flags, PackageUserState state, int userId) {}//api-29
            //...
            //public static final ProviderInfo generateProviderInfo(Provider p, int flags, PackageUserState state, int userId) {}//api-17
            //public static final ProviderInfo generateProviderInfo(Provider p, int flags, boolean stopped,int enabledState, int userId) {}//api-16
            //public static final ProviderInfo generateProviderInfo(Provider p,int flags) {}//api-15

            Method generateProviderInfo;
            if (Build.VERSION.SDK_INT >= 17) {
                // 调用generateProviderInfo 方法, 把PackageParser.Provider转换成ProviderInfo
                Class<?> packageUserStateClazz = Class.forName("android.content.pm.PackageUserState");
                Class<?> userHandlerClazz = Class.forName("android.os.UserHandle");

                //public static final int getCallingUserId(){}
                Method getCallingUserIdMethod = userHandlerClazz.getDeclaredMethod("getCallingUserId");
                getCallingUserIdMethod.setAccessible(true);

                Object userIdObj = getCallingUserIdMethod.invoke(null);
                if (!(userIdObj instanceof Integer)) return null;
                int userId = (Integer) userIdObj;

                //public PackageUserState() {}//api-23默认构造方法
                Object defaultUserState = packageUserStateClazz.newInstance();
                // 需要调用 android.content.pm.PackageParser#generateProviderInfo


                //public static final ProviderInfo generateProviderInfo(Provider p, int flags, PackageUserState state, int userId) {}//17=<api<=29
                //public static final ProviderInfo generateProviderInfo(Provider p, int flags, boolean stopped,int enabledState, int userId) {}//api-16
                //public static final ProviderInfo generateProviderInfo(Provider p,int flags) {}//api-15
                generateProviderInfo = packageParserClazz.getDeclaredMethod(
                        "generateProviderInfo", packageParser$ProviderClazz, int.class, packageUserStateClazz, int.class);
                generateProviderInfo.setAccessible(true);

                List<ProviderInfo> ret = new ArrayList<>();
                // 解析出intent对应的Provider组件
                for (Object provider : providers) {
                    ProviderInfo info = (ProviderInfo) generateProviderInfo.invoke(packageParser, provider, 0, defaultUserState, userId);
                    ret.add(info);
                }
                return ret;
            } else if (Build.VERSION.SDK_INT == 16) {

                Class<?> userIdClazz = Class.forName("android.os.UserId");
                // public static final int getCallingUserId(){}
                Method getCallingUserIdMethod = userIdClazz.getDeclaredMethod("getCallingUserId");
                getCallingUserIdMethod.setAccessible(true);

                Object userIdObj = getCallingUserIdMethod.invoke(null);
                if (!(userIdObj instanceof Integer)) return null;
                int userId = (Integer) userIdObj;

                //public static final ProviderInfo generateProviderInfo(Provider p, int flags, boolean stopped,int enabledState, int userId) {}//api-16
                generateProviderInfo = packageParserClazz.getDeclaredMethod(
                        "generateProviderInfo", packageParser$ProviderClazz, int.class, boolean.class, int.class, int.class);
                generateProviderInfo.setAccessible(true);

                List<ProviderInfo> ret = new ArrayList<>();
                // 解析出intent对应的Provider组件
                for (Object provider : providers) {
                    int enabledState = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
                    ProviderInfo info = (ProviderInfo) generateProviderInfo.invoke(packageParser, provider, 0, false, enabledState, userId);
                    ret.add(info);
                }
                return ret;
            } else {
                //Build.VERSION.SDK_INT==15

                //public static final ProviderInfo generateProviderInfo(Provider p,int flags) {}//api-15
                generateProviderInfo = packageParserClazz.getDeclaredMethod("generateProviderInfo", packageParser$ProviderClazz, int.class);
                generateProviderInfo.setAccessible(true);

                List<ProviderInfo> ret = new ArrayList<>();
                // 解析出intent对应的Provider组件
                for (Object provider : providers) {
                    ProviderInfo info = (ProviderInfo) generateProviderInfo.invoke(packageParser, provider, 0);
                    ret.add(info);
                }
                return ret;
            }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void printProviderInfo(ProviderInfo providerInfo, int i) {
        String name = providerInfo.name;
        String authority = providerInfo.authority;
        String readPermission = providerInfo.readPermission;
        String writePermission = providerInfo.writePermission;
        boolean grantUriPermissions = providerInfo.grantUriPermissions;
        boolean multiProcess = providerInfo.multiprocess;
        int initOrder = providerInfo.initOrder;
        PatternMatcher[] uriPermissionPatterns = providerInfo.uriPermissionPatterns;
        PathPermission[] pathPermissions = providerInfo.pathPermissions;
        Log.d(TAG, i + "==============");
        Log.d(TAG, "name:" + name);
        Log.d(TAG, "authority:" + authority);
        Log.d(TAG, "readPermission:" + readPermission);
        Log.d(TAG, "writePermission:" + writePermission);
        Log.d(TAG, "grantUriPermissions:" + grantUriPermissions);
        Log.d(TAG, "multiprocess:" + multiProcess);
        Log.d(TAG, "initOrder:" + initOrder);
        Log.d(TAG, "uriPermissionPatterns:" + Arrays.toString(uriPermissionPatterns));
        Log.d(TAG, "pathPermissions:" + Arrays.toString(pathPermissions));
        Log.d(TAG, "applicationInfo.packageName:" + providerInfo.applicationInfo.packageName);
        Log.d(TAG, "applicationInfo.name:" + providerInfo.applicationInfo.name);
        Log.d(TAG, i + "==============");
    }

}
