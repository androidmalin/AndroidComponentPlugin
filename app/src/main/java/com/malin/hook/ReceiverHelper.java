package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ReceiverHelper
 * com from wei shu
 * http://weishu.me/2016/04/12/understand-plugin-framework-receiver/
 * androidmalin 增加各个版本的适配(api15-api29),增加代码注释...
 */
@SuppressWarnings("JavaReflectionMemberAccess")
@SuppressLint({"PrivateApi", "unchecked"})
final class ReceiverHelper {

    private static final String TAG = "ReceiverHelper";

    private static Map<ActivityInfo, List<? extends IntentFilter>> sCache = new HashMap<>();
    private static List<BroadcastReceiver> sReceiverList = new ArrayList<>();

    static void preLoadReceiver(Context context, File apk) throws Exception {
        parserReceivers(apk);
        ClassLoader cl = null;
        for (ActivityInfo activityInfo : ReceiverHelper.sCache.keySet()) {
            Log.i(TAG, "preload receiver:" + activityInfo.name);
            List<? extends IntentFilter> intentFilters = ReceiverHelper.sCache.get(activityInfo);
            if (cl == null) {
                cl = CustomClassLoader.getPluginClassLoader(apk, activityInfo.packageName);
            }

            if (intentFilters == null) continue;
            // 把解析出来的每一个静态Receiver都注册为动态的
            for (IntentFilter intentFilter : intentFilters) {
                BroadcastReceiver receiver = (BroadcastReceiver) cl.loadClass(activityInfo.name).newInstance();
                context.registerReceiver(receiver, intentFilter);
                sReceiverList.add(receiver);
            }
        }
    }

    static void unregisterReceiver(Context context) {
        if (context == null) return;
        for (BroadcastReceiver broadcastReceiver : sReceiverList) {
            if (broadcastReceiver == null) continue;
            context.unregisterReceiver(broadcastReceiver);
        }
        sCache.clear();
        sReceiverList.clear();
    }

    /**
     * 解析Apk文件中的 <receiver>, 并存储起来
     */
    @SuppressLint("DiscouragedPrivateApi")
    private static void parserReceivers(File apkFile) throws Exception {
        int version = Build.VERSION.SDK_INT;
        if (version < 15) return;
        //1.获取PackageParser的Class对象
        //package android.content.pm
        //public class PackageParser
        Class<?> packageParserClass = Class.forName("android.content.pm.PackageParser");

        //2.获取parsePackage()方法的Method
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-29
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-28
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-27
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-26
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-25
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-24
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-23
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-22
        //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-21
        //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-19
        //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-18
        //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-17
        //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-16
        //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-15
        Method parsePackageMethod;
        if (Build.VERSION.SDK_INT >= 20) {
            parsePackageMethod = packageParserClass.getDeclaredMethod("parsePackage", File.class, int.class);
        } else {
            // 15<=Build.VERSION.SDK_INT <=19
            parsePackageMethod = packageParserClass.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, int.class);
        }
        parsePackageMethod.setAccessible(true);

        //3.生成PackageParser对象实例
        Object packageParser;
        if (Build.VERSION.SDK_INT >= 20) {
            packageParser = packageParserClass.newInstance();
        } else {
            // 15<=Build.VERSION.SDK_INT <=19
            //public PackageParser(String archiveSourcePath) {}//api-19
            //public PackageParser(String archiveSourcePath) {}//api-18
            //public PackageParser(String archiveSourcePath) {}//api-17
            //public PackageParser(String archiveSourcePath) {}//api-16
            //public PackageParser(String archiveSourcePath) {}//api-15
            Constructor constructor = packageParserClass.getConstructor(String.class);
            constructor.setAccessible(true);
            String archiveSourcePath = apkFile.getCanonicalPath();
            packageParser = constructor.newInstance(archiveSourcePath);
        }

        //4.调用parsePackage获取到apk对象对应的Package对象(return information about intent receivers in the package)
        //Package为PackageParser的内部类;public final static class Package implements Parcelable {}
        Object packageObj;
        if (Build.VERSION.SDK_INT >= 20) {
            //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-29
            //public Package parsePackage(File packageFile, int flags) throws PackageParserException {}//api-21
            packageObj = parsePackageMethod.invoke(packageParser, apkFile, PackageManager.GET_RECEIVERS);
        } else {
            // 15<=Build.VERSION.SDK_INT <=19
            String destCodePath = apkFile.getCanonicalPath();
            DisplayMetrics displayMetrics = new DisplayMetrics();

            //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-19
            //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-15
            packageObj = parsePackageMethod.invoke(packageParser, apkFile, destCodePath, displayMetrics, PackageManager.GET_RECEIVERS);
        }

        if (packageObj == null) return;

        //5.获取Package中的receivers字段Field
        // 读取Package对象里面的receivers字段,注意这是一个 List<Activity> (没错,底层把<receiver>当作<activity>处理)
        // 接下来要做的就是根据这个List<Activity> 获取到Receiver对应的 ActivityInfo (依然是把receiver信息用activity处理了)
        //public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        Field receiversField = packageObj.getClass().getDeclaredField("receivers");

        //6.获取Package实例中receivers字段的值,为ArrayList<Activity> receivers
        List<?> receivers = (List<?>) receiversField.get(packageObj);
        if (receivers == null) return;

        // 调用android.content.pm.PackageParser$Activity#generateActivityInfo()方法, 把PackageParser#Activity 转换成ActivityInfo

        //7.获取PackageParser类的内部类Activity的Class对象
        // public final static class Activity extends Component<ActivityIntentInfo> {}
        Class<?> packageParser$ActivityClass = Class.forName("android.content.pm.PackageParser$Activity");


        //8.获取PackageParser类中内部类Component
        //public static abstract class Component<II extends IntentInfo> {}//api-29
        //public static class Component<II extends IntentInfo> {}//api-15
        Class<?> packageParser$ComponentClass = Class.forName("android.content.pm.PackageParser$Component");

        //9.获取 Component类的intents属性的Field
        //public final ArrayList<II> intents;
        Field intentsField = packageParser$ComponentClass.getDeclaredField("intents");

        //10.调用 public static final ActivityInfo android.content.pm.PackageParser#generateActivityInfo()

        //handle 1.api17-29
        //handle 2.api16
        //handle 3.api15
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=29
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=28
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=27
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=26
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=25
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=24
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=23
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=22
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=21
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=19
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=18
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}//api=17
        //public static final ActivityInfo generateActivityInfo(Activity a, int flags, boolean stopped,int enabledState, int userId) {}//api=16
        //public static final ActivityInfo generateActivityInfo(Activity a,int flags) {}//api=15
        Method generateActivityInfoMethod;
        if (Build.VERSION.SDK_INT >= 17) {
            //11.获取PackageUserState的Class对象
            Class<?> packageUserStateClass = Class.forName("android.content.pm.PackageUserState");

            //12.生成PackageUserState的实例对象
            Object defaultUserStateObj = packageUserStateClass.newInstance();

            //13.获取UserHandle的Class对象
            Class<?> userHandleClass = Class.forName("android.os.UserHandle");

            //14.获取UserHandle中的getCallingUserId()方法
            //public static @UserIdInt int getCallingUserId(){}//api-29
            Method getCallingUserIdMethod = userHandleClass.getDeclaredMethod("getCallingUserId");
            getCallingUserIdMethod.setAccessible(true);


            //15.获取getCallingUserId()方法(静态方法)的返回值userId
            Object userIdObj = getCallingUserIdMethod.invoke(null);
            if (!(userIdObj instanceof Integer)) return;
            int userId = (Integer) userIdObj;


            //public static final ActivityInfo generateActivityInfo(Activity a, int flags, PackageUserState state, int userId) {}
            generateActivityInfoMethod = packageParserClass.getDeclaredMethod(
                    "generateActivityInfo", packageParser$ActivityClass, int.class, packageUserStateClass, int.class);
            generateActivityInfoMethod.setAccessible(true);

            //16.解析出 receiver以及对应的 intentFilter
            //receivers为ArrayList<Activity> receivers
            for (Object activity : receivers) {
                //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}
                ActivityInfo activityInfo = (ActivityInfo) generateActivityInfoMethod.invoke(packageParser, activity, 0, defaultUserStateObj, userId);

                //17.PackageParser$Activity中获取intents字段的值,既public final ArrayList<II> intents;
                //PackageParser$Activity是PackageParser$Component的子类,intents继承自父类
                //public final static class Activity extends Component<ActivityIntentInfo> implements Parcelable {}
                //public static abstract class Component<II extends IntentInfo> {
                //  public final ArrayList<II> intents;
                //}

                // unchecked的原因是,II extends IntentInfo; 而IntentInfo extends IntentFilter==>所以II extends IntentFilter
                // public static class IntentInfo extends IntentFilter {}
                // public static class Component<II extends IntentInfo> {
                //   public final ArrayList<II> intents;
                // }
                @SuppressWarnings("unchecked")
                List<? extends IntentFilter> intentFilters = (List<? extends IntentFilter>) intentsField.get(activity);
                sCache.put(activityInfo, intentFilters);
            }

        } else if (Build.VERSION.SDK_INT == 16) {
            Class<?> userIdClass = Class.forName("android.os.UserId");
            // public static final int getCallingUserId(){}
            Method getCallingUserIdMethod = userIdClass.getDeclaredMethod("getCallingUserId");
            getCallingUserIdMethod.setAccessible(true);

            Object userIdObj = getCallingUserIdMethod.invoke(null);
            if (!(userIdObj instanceof Integer)) return;
            int userId = (Integer) userIdObj;

            //public static final ActivityInfo generateActivityInfo(Activity a, int flags, boolean stopped,int enabledState, int userId) {}//api=16
            generateActivityInfoMethod = packageParserClass.getDeclaredMethod("generateActivityInfo", packageParser$ActivityClass, int.class, boolean.class, int.class, int.class);
            generateActivityInfoMethod.setAccessible(true);

            //receivers为ArrayList<Activity> receivers
            for (Object activity : receivers) {
                int enabledState = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
                ActivityInfo activityInfo = (ActivityInfo) generateActivityInfoMethod.invoke(packageParser, activity, 0, false, enabledState, userId);

                @SuppressWarnings("unchecked")
                List<? extends IntentFilter> intentFilters = (List<? extends IntentFilter>) intentsField.get(activity);
                sCache.put(activityInfo, intentFilters);
            }
        } else {
            //public static final ActivityInfo generateActivityInfo(Activity a,int flags) {}//api=15
            generateActivityInfoMethod = packageParserClass.getDeclaredMethod("generateActivityInfo", packageParser$ActivityClass, int.class);
            generateActivityInfoMethod.setAccessible(true);

            //receivers为ArrayList<Activity> receivers
            for (Object activity : receivers) {
                ActivityInfo activityInfo = (ActivityInfo) generateActivityInfoMethod.invoke(packageParser, activity, 0);

                @SuppressWarnings("unchecked")
                List<? extends IntentFilter> intentFilters = (List<? extends IntentFilter>) intentsField.get(activity);
                sCache.put(activityInfo, intentFilters);
            }
        }
    }
}
