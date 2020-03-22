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
 * androidmalin 增加各个版本的适配(api15-api29,apiR),增加代码注释...
 * <p>
 * 动态注册的receiver ActivityManagerService是知道的,广播的分发也是AMS完成,
 * host要监听(插件中动态注册的广播),也是委托AMS完成;因此不需要进行任何处理.
 */
@SuppressWarnings("JavaReflectionMemberAccess")
@SuppressLint({"PrivateApi", "unchecked"})
final class ReceiverHelper {

    private static final String TAG = "ReceiverHelper";

    private static Map<ActivityInfo, List<? extends IntentFilter>> sCache = new HashMap<>();
    private static List<BroadcastReceiver> sReceiverList = new ArrayList<>();

    static void preLoadReceiver(Context context, File apkFile) throws Exception {
        parserReceivers(apkFile);
        ClassLoader classLoader = null;
        for (ActivityInfo activityInfo : ReceiverHelper.sCache.keySet()) {
            Log.i(TAG, "preload receiver:" + activityInfo.name);
            List<? extends IntentFilter> intentFilters = ReceiverHelper.sCache.get(activityInfo);
            if (classLoader == null) {
                classLoader = CustomClassLoader.getPluginClassLoader(apkFile, activityInfo.packageName);
            }

            if (intentFilters == null) continue;
            // 把解析出来的每一个静态Receiver都注册为动态的
            for (IntentFilter intentFilter : intentFilters) {
                BroadcastReceiver receiver = (BroadcastReceiver) classLoader.loadClass(activityInfo.name).newInstance();
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
        Class<?> packageParserClazz = Class.forName("android.content.pm.PackageParser");

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
            parsePackageMethod = packageParserClazz.getDeclaredMethod("parsePackage", File.class, int.class);
        } else {
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
            //public PackageParser(String archiveSourcePath) {}//api-19
            //public PackageParser(String archiveSourcePath) {}//api-18
            //public PackageParser(String archiveSourcePath) {}//api-17
            //public PackageParser(String archiveSourcePath) {}//api-16
            //public PackageParser(String archiveSourcePath) {}//api-15
            Constructor packageParserConstructor = packageParserClazz.getDeclaredConstructor(String.class);
            packageParserConstructor.setAccessible(true);
            String archiveSourcePath = apkFile.getCanonicalPath();
            packageParser = packageParserConstructor.newInstance(archiveSourcePath);
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
            displayMetrics.setToDefaults();//参考api=29时 PackageParser的默认构造函数中的表达式

            //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-19
            //public Package parsePackage(File sourceFile, String destCodePath, DisplayMetrics metrics, int flags) {}//api-15
            packageObj = parsePackageMethod.invoke(packageParser, apkFile, destCodePath, displayMetrics, PackageManager.GET_RECEIVERS);
        }

        //Package:为PackageParser的静态内部类
        //public class PackageParser {
        //       public final static class Package implements Parcelable {
        //           public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        //       }
        //       public final static class Activity extends Component<ActivityIntentInfo> implements Parcelable {
        //
        //       }
        // }
        if (packageObj == null) return;

        //5.获取Package中的receivers字段Field
        //public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        Field receiversField = packageObj.getClass().getDeclaredField("receivers");
        receiversField.setAccessible(true);

        //6.获取Package对象里面的receivers字段的值,注意这是一个 ArrayList<Activity> (没错,底层把<receiver>当作<Activity>处理)
        List<?> receivers = (List<?>) receiversField.get(packageObj);
        if (receivers == null) return;

        // 接下来要做的就是根据这个ArrayList<Activity> 获取到Receiver对应的 ActivityInfo (依然是把receiver信息用Activity处理了)
        // 调用 ActivityInfo PackageParser#generateActivityInfo(Activity a,int flags,PackageUserState state,int userId){}方法, 把PackageParser#Activity 转换成ActivityInfo

        //7.获取PackageParser类的内部类Activity的Class对象
        // public final static class Activity extends Component<ActivityIntentInfo> {}
        Class<?> packageParser$ActivityClazz = Class.forName("android.content.pm.PackageParser$Activity");


        //8.获取PackageParser类中内部类Component
        //public static abstract class Component<II extends IntentInfo> {}//api-29
        //public static class Component<II extends IntentInfo> {}//api-15
        Class<?> packageParser$ComponentClazz = Class.forName("android.content.pm.PackageParser$Component");

        //9.获取 Component类的intents属性的Field
        //public final ArrayList<II> intents;
        Field intentsField = packageParser$ComponentClazz.getDeclaredField("intents");
        intentsField.setAccessible(true);

        //10.调用 public static final ActivityInfo android.content.pm.PackageParser#generateActivityInfo(){}

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
            Class<?> packageUserStateClazz = Class.forName("android.content.pm.PackageUserState");

            //12.生成PackageUserState的实例对象
            Object defaultUserStateObj = packageUserStateClazz.newInstance();

            //13.获取UserHandle的Class对象
            Class<?> userHandleClazz = Class.forName("android.os.UserHandle");

            //14.获取UserHandle中的getCallingUserId()方法
            //public static @UserIdInt int getCallingUserId(){}//api-29
            Method getCallingUserIdMethod = userHandleClazz.getDeclaredMethod("getCallingUserId");
            getCallingUserIdMethod.setAccessible(true);


            //15.获取getCallingUserId()方法(静态方法)的返回值userId
            Object userIdObj = getCallingUserIdMethod.invoke(null);
            if (!(userIdObj instanceof Integer)) return;
            int userId = (Integer) userIdObj;


            //public static final ActivityInfo generateActivityInfo(Activity a, int flags, PackageUserState state, int userId) {}
            generateActivityInfoMethod = packageParserClazz.getDeclaredMethod(
                    "generateActivityInfo", packageParser$ActivityClazz, int.class, packageUserStateClazz, int.class);
            generateActivityInfoMethod.setAccessible(true);

            //16.解析出 receiver以及对应的 intentFilter
            //receivers为ArrayList<Activity> receivers
            for (Object activity : receivers) {
                //public static final ActivityInfo generateActivityInfo(Activity a, int flags,PackageUserState state, int userId) {}
                //ActivityInfo:
                //Information you can retrieve about a particular application activity or receiver.
                //This corresponds to information collected from the AndroidManifest.xm's <activity/> ,<receiver/> tags.
                ActivityInfo activityInfo = (ActivityInfo) generateActivityInfoMethod.invoke(packageParser, activity, 0, defaultUserStateObj, userId);

                //17.PackageParser$Activity中获取intents字段的值,既public final ArrayList<II> intents;
                //PackageParser$Activity是PackageParser$Component的子类,PackageParser$Activity中的intents成员变量继承自父类PackageParser$Component

                //public class PackageParser {
                //       public final static class Package implements Parcelable {
                //              public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
                //       }
                //       public final static class Activity extends Component<ActivityIntentInfo> implements Parcelable {
                //
                //       }
                //        public static abstract class Component<II extends IntentInfo> {
                //               public final ArrayList<II> intents;
                //       }
                // }

                // unchecked的原因是,II extends IntentInfo; 而IntentInfo extends IntentFilter==>所以II 是 IntentFilter 的子类
                // public static class Component<II extends IntentInfo> {
                //   public final ArrayList<II> intents;
                // }
                // public static class IntentInfo extends IntentFilter {}
                @SuppressWarnings("unchecked")
                List<? extends IntentFilter> intentFilters = (List<? extends IntentFilter>) intentsField.get(activity);
                sCache.put(activityInfo, intentFilters);
            }

        } else if (Build.VERSION.SDK_INT == 16) {
            Class<?> userIdClazz = Class.forName("android.os.UserId");
            // public static final int getCallingUserId(){}
            Method getCallingUserIdMethod = userIdClazz.getDeclaredMethod("getCallingUserId");
            getCallingUserIdMethod.setAccessible(true);

            Object userIdObj = getCallingUserIdMethod.invoke(null);
            if (!(userIdObj instanceof Integer)) return;
            int userId = (Integer) userIdObj;

            //public static final ActivityInfo generateActivityInfo(Activity a, int flags, boolean stopped,int enabledState, int userId) {}//api=16
            generateActivityInfoMethod = packageParserClazz.getDeclaredMethod("generateActivityInfo", packageParser$ActivityClazz, int.class, boolean.class, int.class, int.class);
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
            generateActivityInfoMethod = packageParserClazz.getDeclaredMethod("generateActivityInfo", packageParser$ActivityClazz, int.class);
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
