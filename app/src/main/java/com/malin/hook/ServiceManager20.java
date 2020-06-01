package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 插件化ServiceManager
 * come from weishu
 * modify by malin
 * 适用于 android >=20
 */
@SuppressLint("PrivateApi")
public final class ServiceManager20 {

    private static final String TAG = "ServiceManager";

    // 动态创建的Service信息,调用ActivityThread#handleCreateService(CreateServiceData data){}方法,创建Service对象
    private final Map<String, Service> mServiceMap = new HashMap<>();

    // 存储插件的Service信息
    private final Map<ComponentName, ServiceInfo> mServiceInfoMap = new HashMap<>();

    private static class Holder {
        private static final ServiceManager20 instance = new ServiceManager20();
    }

    static ServiceManager20 getInstance() {
        return ServiceManager20.Holder.instance;
    }


    /**
     * 启动某个插件Service; 如果Service还没有启动, 那么会创建新的插件Service
     *
     * @param proxyIntent proxyIntent
     * @param startId     startId
     */
    @SuppressWarnings("deprecation")
    void onStart(Intent proxyIntent, int startId) {

        Intent targetIntent = proxyIntent.getParcelableExtra(HookAMSForServicePlugin.EXTRA_TARGET_INTENT);
        if (targetIntent == null) throw new NullPointerException("targetIntent==null");
        ServiceInfo serviceInfo = selectPluginService(targetIntent);

        if (serviceInfo == null) {
            Log.w(TAG, "can not found service : " + targetIntent.getComponent());
            return;
        }
        try {
            String processName0 = ProcessUtil.getProcessNameViaManager(MApplication.getInstance());
            Log.d(TAG, "0processName:" + processName0);
            Log.d(TAG, "0mServiceMap.size:" + mServiceMap.size());
            Log.d(TAG, "0mServiceMap.containsKey(serviceInfo.name):" + serviceInfo.name);

            if (!mServiceMap.containsKey(serviceInfo.name)) {
                // service还不存在, 先创建
                proxyCreateService(serviceInfo);
            }

            Service service = mServiceMap.get(serviceInfo.name);
            if (service == null) throw new NullPointerException("service==null");
            service.onStart(targetIntent, startId);

            String processName2 = ProcessUtil.getProcessNameViaManager(MApplication.getInstance());
            Log.d(TAG, "2processName:" + processName2);
            Log.d(TAG, "2mServiceMap.size:" + mServiceMap.size());
            Log.d(TAG, "2mServiceMap.get(serviceInfo.name):" + serviceInfo.name);
        } catch (Throwable e) {
            Log.e(TAG, "Throwable:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 停止某个插件Service, 当全部的插件Service都停止之后, ProxyService也会停止
     *
     * @param targetIntent targetIntent
     * @return int
     */
    public int stopService(Intent targetIntent) {
        ServiceInfo serviceInfo = selectPluginService(targetIntent);
        if (serviceInfo == null) {
            Log.w(TAG, "can not found service: " + targetIntent.getComponent());
            return 0;
        }
        String processName3 = ProcessUtil.getProcessNameViaManager(MApplication.getInstance());
        Log.d(TAG, "3processName:" + processName3);
        Log.d(TAG, "3mServiceMap.size:" + mServiceMap.size());
        Log.d(TAG, "3mServiceMap.get(serviceInfo.name):" + serviceInfo.name);

        Service service = mServiceMap.get(serviceInfo.name);
        if (service == null) {
            Log.w(TAG, "can not runnning, are you stopped it multi-times?");
            return 0;
        }
        service.onDestroy();
        mServiceMap.remove(serviceInfo.name);
        if (mServiceMap.isEmpty()) {
            // 没有Service了, 这个没有必要存在了
            Log.d(TAG, "service all stopped, stop proxy");
            Context appContext = MApplication.getInstance();
            appContext.stopService(new Intent().setComponent(new ComponentName(appContext.getPackageName(), PluginProxyService.class.getName())));
        }
        return 1;
    }

    /**
     * 选择匹配的ServiceInfo
     *
     * @param pluginIntent 插件的Intent
     * @return ServiceInfo
     */
    private ServiceInfo selectPluginService(Intent pluginIntent) {
        for (ComponentName componentName : mServiceInfoMap.keySet()) {
            if (componentName.equals(pluginIntent.getComponent())) {
                return mServiceInfoMap.get(componentName);
            }
        }
        return null;
    }

    /**
     * 思路:
     * 目标:通过反射调用ActivityThread的handleCreateService方法创建出Service对象,
     * private void handleCreateService(CreateServiceData data) {}
     * 创建出来的Service对象存储在ActivityThread中的mServices成员中,从该成员中取出,供之后使用
     * final ArrayMap<IBinder, Service> mServices = new ArrayMap<>();
     * <p>
     * 1.创建CreateServiceData对象
     * static final class CreateServiceData {
     * IBinder token;
     * ServiceInfo info;
     * CompatibilityInfo compatInfo;
     * Intent intent;
     * }
     * CreateServiceData类有四个成员,依次创建它的成员赋值给创建出来的CreateServiceData对象;
     * 既给它的成员变量赋值.
     * <p>
     * 2.调用ActivityThread#handleCreateService(CreateServiceData data){}方法,创建Service对象
     * <p>
     * 3.取出创建出来的Service对象;
     * 创建出来的Service对象存储在ActivityThread类中的mServices成员中,从该成员中取出.存储起来,在之后使用
     * final ArrayMap<IBinder, Service> mServices = new ArrayMap<>();
     *
     * @param serviceInfo 插件的ServiceInfo
     * @throws Throwable e
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    private void proxyCreateService(ServiceInfo serviceInfo) throws Throwable {
        //0.
        IBinder token = new Binder();

        //1.创建CreateServiceData对象, 用来传递给ActivityThread的handleCreateService 当作参数
        //ActivityThread的内部类CreateServiceData static final class CreateServiceData {}
        Class<?> createServiceDataClazz = Class.forName("android.app.ActivityThread$CreateServiceData");
        Constructor<?> createServiceDataConstructor = createServiceDataClazz.getDeclaredConstructor();
        createServiceDataConstructor.setAccessible(true);
        Object createServiceData = createServiceDataConstructor.newInstance();

        //2.给我们创建的createServiceData对象的token字段赋值, ActivityThread的handleCreateService用这个作为key存储Service
        Field tokenField = createServiceDataClazz.getDeclaredField("token");
        tokenField.setAccessible(true);
        tokenField.set(createServiceData, token);

        //3.给serviceInfo.applicationInfo增加必须的属性.
        // 之前android.content.pm.PackageParser#generateServiceInfo(){}方法,得到的ServiceInfo中 serviceInfo.applicationInfo属性没有值;
        //这个修改是为了loadClass的时候, LoadedApk会是主程序的ClassLoader, 我们选择Hook BaseDexClassLoader的方式加载插件
        serviceInfo.applicationInfo.packageName = MApplication.getInstance().getPackageName();

        //android10出现的异常解决办法,通过异常，寻找出错的地方
        //插件APK的路径
        String path = MApplication.getInstance().getFileStreamPath("pluginService-debug-1.0.apk").getPath();
        serviceInfo.applicationInfo.sourceDir = path;
        serviceInfo.applicationInfo.publicSourceDir = path;
        serviceInfo.applicationInfo.nativeLibraryDir = MApplication.getInstance().getApplicationInfo().nativeLibraryDir;

        //4.给我们创建的createServiceData对象的info字段赋值
        Field infoField = createServiceDataClazz.getDeclaredField("info");
        infoField.setAccessible(true);
        infoField.set(createServiceData, serviceInfo);

        //5.给我们创建的createServiceData对象的compatInfo字段赋值
        //5.1获取默认的compatibility配置
        //public class CompatibilityInfo implements Parcelable {
        //    /** default compatibility info object for compatible applications */
        //    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {
        //    };
        //}
        Class<?> compatibilityClazz = Class.forName("android.content.res.CompatibilityInfo");
        Field defaultCompatibilityField = compatibilityClazz.getDeclaredField("DEFAULT_COMPATIBILITY_INFO");
        defaultCompatibilityField.setAccessible(true);
        Object defaultCompatibility = defaultCompatibilityField.get(null);

        //5.2赋值
        Field compatInfoField = createServiceDataClazz.getDeclaredField("compatInfo");
        compatInfoField.setAccessible(true);
        compatInfoField.set(createServiceData, defaultCompatibility);

        //6.调用ActivityThread#handleCreateService(CreateServiceData data){}方法
        //6.1 get currentActivityThread
        Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
        Method currentActivityThreadMethod = activityThreadClazz.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);
        Object currentActivityThread = currentActivityThreadMethod.invoke(null);

        //6.2 invoke handleCreateService(CreateServiceData data) {}方法
        // private void handleCreateService(CreateServiceData data) {}
        Method handleCreateServiceMethod = activityThreadClazz.getDeclaredMethod("handleCreateService", createServiceDataClazz);
        handleCreateServiceMethod.setAccessible(true);
        handleCreateServiceMethod.invoke(currentActivityThread, createServiceData);

        //7.获取存储在ActivityThread的mServices字段里的值
        // handleCreateService方法创建出来的Service对象并没有返回, 而是存储在ActivityThread的mServices字段里面, 这里我们手动把它取出来
        //final ArrayMap<IBinder, Service> mServices = new ArrayMap<>();
        Field mServicesField = activityThreadClazz.getDeclaredField("mServices");
        mServicesField.setAccessible(true);
        Map<?, ?> mServices = (Map<?, ?>) mServicesField.get(currentActivityThread);
        if (mServices == null) throw new NullPointerException("mServices==null");
        //8.获取我们新创建出来的Service对象
        Service service = (Service) mServices.get(token);

        //9.获取到之后, 移除这个service, 我们只是借花献佛。
        //使用系统的类,来解析.用完后,清除使用过程中产生的额外产物;清理干净;
        mServices.remove(token);

        //10.将此Service存储起来
        mServiceMap.put(serviceInfo.name, service);

        String processName1 = ProcessUtil.getProcessNameViaManager(MApplication.getInstance());
        Log.d(TAG, "1processName:" + processName1);
        Log.d(TAG, "1mServiceMap.size:" + mServiceMap.size());
        Log.d(TAG, "1mServiceMap.put(serviceInfo.name, service):" + serviceInfo.name);
    }

    /**
     * 解析Apk文件中的 <service>, 并存储起来
     * 主要是调用PackageParser类的generateServiceInfo方法
     *
     * @param apkFile 插件对应的apk文件
     * @throws Throwable 解析出错或者反射调用出错, 均会抛出异常
     */
    @SuppressWarnings({"JavaReflectionInvocation"})
    void preLoadServices(File apkFile) throws Throwable {
        //1.生成PackageParser对象
        Class<?> packageParserClazz = Class.forName("android.content.pm.PackageParser");
        Object packageParser = packageParserClazz.newInstance();

        //2.调用parsePackage获取到插件apkFile对应的Package对象
        //public Package parsePackage(File packageFile, int flags) {}
        Method parsePackageMethod = packageParserClazz.getDeclaredMethod("parsePackage", File.class, int.class);
        parsePackageMethod.setAccessible(true);
        //PackageParser$Package,Package为PackageParser的静态内部类
        //public final static class Package {}
        Object packageObj = parsePackageMethod.invoke(packageParser, apkFile, PackageManager.GET_SERVICES);
        if (packageObj == null) throw new NullPointerException("packageObj==null");

        //3.读取Package对象里面的services字段
        //public final ArrayList<Service> services = new ArrayList<Service>(0);
        Field servicesField = packageObj.getClass().getDeclaredField("services");
        servicesField.setAccessible(true);
        List<?> services = (List<?>) servicesField.get(packageObj);
        if (services == null) throw new NullPointerException("services==null");

        //4.接下来要做的就是根据这个List<Service> 获取到Service对应的ServiceInfo
        // 调用generateServiceInfo 方法, 把PackageParser$Service转换成ServiceInfo
        //public final static class Service extends Component<ServiceIntentInfo> {}
        Class<?> packageParser$ServiceClazz = Class.forName("android.content.pm.PackageParser$Service");

        //5.get defaultUserState
        Class<?> packageUserStateClazz = Class.forName("android.content.pm.PackageUserState");
        Object defaultUserState = packageUserStateClazz.newInstance();

        //6. get userId
        Class<?> userHandlerClazz = Class.forName("android.os.UserHandle");
        //public static final int getCallingUserId() {}
        Method getCallingUserIdMethod = userHandlerClazz.getDeclaredMethod("getCallingUserId");
        getCallingUserIdMethod.setAccessible(true);
        Object userIdObj = getCallingUserIdMethod.invoke(null);
        if (!(userIdObj instanceof Integer)) return;
        int userId = (Integer) userIdObj;

        //7. call generateServiceInfo方法
        // public static final ServiceInfo generateServiceInfo(android.content.pm.PackageParser.Service s, int flags, android.content.pm.PackageUserState state, int userId) {
        Method generateServiceInfo = packageParserClazz.getDeclaredMethod("generateServiceInfo", packageParser$ServiceClazz, int.class, packageUserStateClazz, int.class);
        generateServiceInfo.setAccessible(true);

        //8. 解析出intent对应的Service组件
        for (Object service : services) {
            ServiceInfo info = (ServiceInfo) generateServiceInfo.invoke(packageParser, service, 0, defaultUserState, userId);
            if (info == null) continue;
            mServiceInfoMap.put(new ComponentName(info.packageName, info.name), info);
        }
    }
}
