package com.malin.plugin.impl

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Handler
import android.os.Message
import java.lang.reflect.InvocationHandler
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * 对Activity启动流程中的两次拦截
 */
@SuppressLint("PrivateApi")
object HookActivity {
    private const val EXTRA_ORIGIN_INTENT = "EXTRA_ORIGIN_INTENT"

    /**
     * 对IActivityManager接口中的startActivity方法进行动态代理,发生在app的进程中
     * [android.app.Activity.startActivity]
     * [android.app.Activity.startActivityForResult]
     * [android.app.Instrumentation]
     * android.app.Instrumentation#execStartActivity()
     * Activity#startActivityForResult-->Instrumentation#execStartActivity-->ActivityManager.getService().startActivity()-->
     * IActivityManager public int startActivity(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options) throws android.os.RemoteException;
     *
     * @param context          context
     * @param subActivityClazz 在AndroidManifest.xml中注册了的Activity
     */
    @SuppressLint("DiscouragedPrivateApi")
    fun hookStartActivity(context: Context, subActivityClazz: Class<*>) {
        try {
            val apiLevel = Build.VERSION.SDK_INT
            when {
                apiLevel >= 29 -> {
                    // 1.获取ActivityTaskManager的Class对象
                    // package android.app;
                    // public class ActivityTaskManager
                    val activityTaskManagerClazz = Class.forName("android.app.ActivityTaskManager")

                    // 2.获取ActivityTaskManager的私有静态成员变量IActivityTaskManagerSingleton
                    // private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton
                    // 3.取消Java的权限检查
                    val iActivityTaskManagerSingletonField =
                        activityTaskManagerClazz.getDeclaredField("IActivityTaskManagerSingleton")
                            .also { it.isAccessible = true }

                    // 4.获取IActivityManagerSingleton的实例对象
                    // private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton
                    // 所有静态对象的反射可以通过传null获取,如果是非静态必须传实例
                    val iActivityTaskManagerSingletonObj =
                        iActivityTaskManagerSingletonField.get(null)

                    // 5.
                    handleIActivityTaskManager(
                        context,
                        subActivityClazz,
                        iActivityTaskManagerSingletonObj
                    )
                }

                apiLevel >= 26 -> {
                    // 1.获取ActivityManager的Class对象
                    // package android.app
                    // public class ActivityManager
                    val activityManagerClazz = Class.forName("android.app.ActivityManager")

                    // 2.获取ActivityManager的私有静态属性IActivityManagerSingleton
                    // private static final Singleton<IActivityManager> IActivityManagerSingleton
                    // 3.取消Java的权限检查
                    val iActivityManagerSingletonField =
                        activityManagerClazz.getDeclaredField("IActivityManagerSingleton")
                            .also { it.isAccessible = true }

                    // 4.获取IActivityManagerSingleton的实例对象
                    // private static final Singleton<IActivityManager> IActivityManagerSingleton
                    // 所有静态对象的反射可以通过传null获取,如果是非静态必须传实例
                    handleIActivityManager(
                        context,
                        subActivityClazz,
                        iActivityManagerSingletonField[null]
                    )
                }

                else -> {
                    // 1.获取ActivityManagerNative的Class对象
                    // package android.app
                    // public abstract class ActivityManagerNative
                    val activityManagerNativeClazz =
                        Class.forName("android.app.ActivityManagerNative")

                    // 2.获取 ActivityManagerNative的 私有属性gDefault
                    // private static final Singleton<IActivityManager> gDefault
                    // 3.对私有属性gDefault,解除私有限定
                    val singletonField = activityManagerNativeClazz.getDeclaredField("gDefault")
                        .also { it.isAccessible = true }

                    // 4.获得gDefaultField中对应的属性值(被static修饰了),既得到Singleton<IActivityManager>对象的实例
                    // 所有静态对象的反射可以通过传null获取
                    // private static final Singleton<IActivityManager> gDefault
                    handleIActivityManager(context, subActivityClazz, singletonField[null])
                }
            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    /**
     * just for apiLevel >= 29
     */
    @SuppressLint("DiscouragedPrivateApi")
    private fun handleIActivityTaskManager(
        context: Context,
        subActivityClazz: Class<*>,
        IActivityTaskManagerSingletonObj: Any?,
    ) {
        try {
            // 5.获取private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton对象中的属性private T mInstance的值
            // 既,为了获取一个IActivityTaskManager的实例对象
            // private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton = new Singleton<IActivityTaskManager>() {...}

            // 6.获取Singleton类对象
            // package android.util
            // public abstract class Singleton<T>
            val singletonClazz = Class.forName("android.util.Singleton")

            // 7.获取mInstance属性
            // private T mInstance;
            // 8.取消Java的权限检查
            val mInstanceField =
                singletonClazz.getDeclaredField("mInstance").also { it.isAccessible = true }

            // 9.获取mInstance属性的值,既IActivityTaskManager的实例
            // 从private static final Singleton<IActivityTaskManager> IActivityTaskManagerSingleton实例对象中获取mInstance属性对应的值,既IActivityTaskManager
            var iActivityTaskManager = mInstanceField[IActivityTaskManagerSingletonObj]

            // 10.android10之后,从mInstanceField中取到的值为null,这里判断如果为null,就再次从get方法中再取一次
            if (iActivityTaskManager == null) {
                val getMethod =
                    singletonClazz.getDeclaredMethod("get").also { it.isAccessible = true }
                iActivityTaskManager = getMethod.invoke(IActivityTaskManagerSingletonObj)
            }

            // 11.获取IActivityTaskManager接口的类对象
            // package android.app
            // public interface IActivityTaskManager
            val iActivityTaskManagerClazz = Class.forName("android.app.IActivityTaskManager")

            // 12.创建一个IActivityTaskManager接口的代理对象
            val iActivityTaskManagerProxy = Proxy.newProxyInstance(
                Thread.currentThread().contextClassLoader, arrayOf(iActivityTaskManagerClazz),
                IActivityInvocationHandler(iActivityTaskManager, context, subActivityClazz)
            )

            // 13.重新赋值
            // 给mInstance属性,赋新值
            // 给Singleton<IActivityTaskManager> IActivityTaskManagerSingleton实例对象的属性private T mInstance赋新值
            mInstanceField[IActivityTaskManagerSingletonObj] = iActivityTaskManagerProxy
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    /**
     *  for 15<= apiLevel <= 28
     */
    @SuppressLint("DiscouragedPrivateApi")
    private fun handleIActivityManager(
        context: Context,
        subActivityClazz: Class<*>,
        iActivityManagerSingletonObj: Any?,
    ) {
        try {
            // 5.获取private static final Singleton<IActivityManager> IActivityManagerSingleton对象中的属性private T mInstance的值
            // 既,为了获取一个IActivityManager的实例对象
            // private static final Singleton<IActivityManager> IActivityManagerSingleton = new Singleton<IActivityManager>(){...}

            // 6.获取Singleton类对象
            // package android.util
            // public abstract class Singleton<T>
            val singletonClazz = Class.forName("android.util.Singleton")

            // 7.获取mInstance属性
            // private T mInstance;
            // 8.取消Java的权限检查
            val mInstanceField =
                singletonClazz.getDeclaredField("mInstance").also { it.isAccessible = true }

            // 9.获取mInstance属性的值,既IActivityManager的实例
            // 从private static final Singleton<IActivityManager> IActivityManagerSingleton实例对象中获取mInstance属性对应的值,既IActivityManager
            val iActivityManager = mInstanceField[iActivityManagerSingletonObj]

            // 10.获取IActivityManager接口的类对象
            // package android.app
            // public interface IActivityManager
            val iActivityManagerClazz = Class.forName("android.app.IActivityManager")

            // 11.创建一个IActivityManager接口的代理对象
            val iActivityManagerProxy = Proxy.newProxyInstance(
                Thread.currentThread().contextClassLoader, arrayOf(iActivityManagerClazz),
                IActivityInvocationHandler(iActivityManager, context, subActivityClazz)
            )

            // 12.重新赋值
            // 给mInstance属性,赋新值
            // 给Singleton<IActivityManager> IActivityManagerSingleton实例对象的属性private T mInstance赋新值
            mInstanceField[iActivityManagerSingletonObj] = iActivityManagerProxy
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    /**
     * 启动未注册的Activity,将之前替换了的Intent,换回去.我们的目标是要启动未注册的Activity
     */
    @SuppressLint("DiscouragedPrivateApi")
    fun hookLauncherActivity() {
        try {
            // 1.获取ActivityThread的Class对象
            // package android.app
            // public final class ActivityThread
            val activityThreadClazz = Class.forName("android.app.ActivityThread")

            // 2.获取currentActivityThread()静态方法;为了保证在多个版本中兼容性,使用该静态方法获取ActivityThread的实例
            // public static ActivityThread currentActivityThread(){return sCurrentActivityThread;}
            val currentActivityThreadMethod =
                activityThreadClazz.getDeclaredMethod("currentActivityThread")
                    .also { it.isAccessible = true }

            // 3.获取ActivityThread的对象实例
            // public static ActivityThread currentActivityThread(){return sCurrentActivityThread;}
            val activityThreadObj = currentActivityThreadMethod.invoke(null)

            // 4.获取ActivityThread 的属性mH
            // final H mH = new H();
            val mHField = activityThreadClazz.getDeclaredField("mH").also { it.isAccessible = true }

            // 5.获取mH的值,既获取ActivityThread类中H类的实例对象
            // 从ActivityThread实例中获取mH属性对应的值,既mH的值
            val mHObj = mHField[activityThreadObj]

            // 6.获取Handler的Class对象
            // package android.os
            // public class Handler
            val handlerClazz = Class.forName("android.os.Handler")

            // 7.获取mCallback属性
            // final Callback mCallback;
            // Callback是Handler类内部的一个接口
            val mCallbackField =
                handlerClazz.getDeclaredField("mCallback").also { it.isAccessible = true }

            // 8.给mH增加mCallback
            // 给mH,既Handler的子类设置mCallback属性,提前对消息进行处理.
            if (Build.VERSION.SDK_INT >= 28) {
                // >=android 9.0
                mCallbackField[mHObj] = HandlerCallbackP()
            } else {
                mCallbackField[mHObj] = HandlerCallback()
            }
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun handleLaunchActivity(msg: Message) {
        var launchActivity = 100
        try {
            // 1.获取ActivityThread的内部类H的Class对象
            // package android.app
            // public final class ActivityThread{ private class H extends Handler {} }
            val hClazz = Class.forName("android.app.ActivityThread\$H")

            // 2.获取LAUNCH_ACTIVITY属性的Field
            // public static final int LAUNCH_ACTIVITY = 100;
            val launchActivityField = hClazz.getField("LAUNCH_ACTIVITY")

            // 3.获取LAUNCH_ACTIVITY的值
            val launchActivityValue = launchActivityField[null]
            if (launchActivityValue is Int) {
                launchActivity = launchActivityValue
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (msg.what != launchActivity) return
        // private class H extends Handler {
        // public void handleMessage(Message msg) {
        //            switch (msg.what) {
        //                case LAUNCH_ACTIVITY: {
        //                    final ActivityClientRecord r = (ActivityClientRecord) msg.obj;
        //                    r.packageInfo = getPackageInfoNoCheck(r.activityInfo.applicationInfo, r.compatInfo);
        //                    handleLaunchActivity(r, null, "LAUNCH_ACTIVITY");
        //                    break;
        //                }
        //            }
        //    }
        // 1.从msg中获取ActivityClientRecord对象
        // android.app.ActivityThread$ActivityClientRecord
        // static final class ActivityClientRecord {}
        val activityClientRecordObj = msg.obj
        try {
            // 2.获取ActivityClientRecord的intent属性
            // Intent intent;
            val safeIntentField = activityClientRecordObj.javaClass.getDeclaredField("intent")
                .also { it.isAccessible = true }

            // 3.获取ActivityClientRecord的intent属性的值,既安全的Intent
            val safeIntent = safeIntentField[activityClientRecordObj] as? Intent ?: return

            // 4.获取原始的Intent
            val originIntent: Intent? = if (Build.VERSION.SDK_INT >= 33) {
                safeIntent.getParcelableExtra(EXTRA_ORIGIN_INTENT, Intent::class.java)
            } else {
                @Suppress("DEPRECATION")
                safeIntent.getParcelableExtra(EXTRA_ORIGIN_INTENT)
            }
            if (originIntent == null) return

            // 5.将安全的Intent,替换为原始的Intent,以启动我们要启动的未注册的Activity
            safeIntent.component = originIntent.component


            // 给插件apk设置主题
            val activityInfoField =
                activityClientRecordObj.javaClass.getDeclaredField("activityInfo")
                    .also { it.isAccessible = true }
            val activityInfo: ActivityInfo =
                activityInfoField.get(activityClientRecordObj) as ActivityInfo
            activityInfo.theme = selectSystemTheme()


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Suppress("SameParameterValue")
    private fun selectSystemTheme(): Int {
        val targetSdkVersion: Int = Build.VERSION.SDK_INT
        val theme: Int = when {
            targetSdkVersion < 24 -> R.style.AppCompatTheme
            else -> R.style.AppCompatTheme
        }
        return theme
    }

    /**
     * 获取包名
     */
    private fun getAppPackageName(context: Context): String {
        return context.applicationContext.packageName
    }

    /**
     * 1.处理未注册的Activity为AppCompatActivity类或者子类的情况
     * 2.hook IPackageManager,处理android 4.3以下(<= 18)启动Activity,在ApplicationPackageManager.getActivityInfo方法中未找到注册的Activity的异常
     *
     *
     * http://weishu.me/2016/03/07/understand-plugin-framework-ams-pms-hook/
     *
     * @param context          context
     * @param subActivityClazz 注册了的Activity的class对象
     */
    @SuppressLint("DiscouragedPrivateApi")
    fun hookPackageManager(context: Context, subActivityClazz: Class<*>) {
        try {
            // 1.获取ActivityThread的值
            val activityThreadClazz = Class.forName("android.app.ActivityThread")
            // public static ActivityThread currentActivityThread() {
            //        return sCurrentActivityThread;
            //    }
            val currentActivityThreadMethod =
                activityThreadClazz.getDeclaredMethod("currentActivityThread")
                    .also { it.isAccessible = true }

            val activityThread = currentActivityThreadMethod.invoke(null)

            // 2.获取ActivityThread里面原始的 sPackageManager
            // static IPackageManager sPackageManager;
            val sPackageManagerField = activityThreadClazz.getDeclaredField("sPackageManager")
                .also { it.isAccessible = true }

            val sPackageManager = sPackageManagerField[activityThread]

            // 3.准备好代理对象, 用来替换原始的对象
            val iPackageManagerClazz = Class.forName("android.content.pm.IPackageManager")
            val proxy = Proxy.newProxyInstance(
                Thread.currentThread().contextClassLoader, arrayOf(iPackageManagerClazz),
                PackageManagerProxyHandler(
                    sPackageManager,
                    getAppPackageName(context),
                    subActivityClazz.name
                )
            )

            // 4.替换掉ActivityThread里面的 sPackageManager 字段
            sPackageManagerField[activityThread] = proxy

            // 5.替换 ApplicationPackageManager里面的 mPM对象
            val packageManager = context.packageManager
            // PackageManager的实现类ApplicationPackageManager中的mPM
            // private final IPackageManager mPM;
            val mPmField =
                packageManager.javaClass.getDeclaredField("mPM").also { it.isAccessible = true }
            mPmField[packageManager] = proxy
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    /**
     * 对IActivityManager/IActivityTaskManager接口进行动态代理
     */
    private class IActivityInvocationHandler(
        private val mIActivityManager: Any?,
        private val mContext: Context,
        private val mSubActivityClazz: Class<*>,
    ) : InvocationHandler {
        @Throws(InvocationTargetException::class, IllegalAccessException::class)
        override fun invoke(proxy: Any, method: Method, args: Array<Any>?): Any? {
            if (method.name == "startActivity" && !args.isNullOrEmpty()) {
                var intentIndex = 2
                for (i in args.indices) {
                    if (args[i] is Intent) {
                        intentIndex = i
                        break
                    }
                }
                // 将启动的未注册的Activity对应的Intent,替换为安全的注册了的桩Activity的Intent
                // 1.将未注册的Activity对应的Intent,改为安全的Intent,既在AndroidManifest.xml中配置了的Activity的Intent
                val originIntent = args[intentIndex] as Intent
                val safeIntent = Intent(mContext, mSubActivityClazz)
                // public class Intent implements Parcelable;
                // Intent类已经实现了Parcelable接口
                safeIntent.putExtra(EXTRA_ORIGIN_INTENT, originIntent)

                // 2.替换到原来的Intent,欺骗AMS
                args[intentIndex] = safeIntent

                // 3.之后,再换回来,启动我们未在AndroidManifest.xml中配置的Activity
                // final H mH = new H();
                // hook Handler消息的处理,给Handler增加mCallback
            }
            // public abstract int android.app.IActivityManager.startActivity(android.app.IApplicationThread,java.lang.String,android.content.Intent,java.lang.String,android.os.IBinder,java.lang.String,int,int,android.app.ProfilerInfo,android.os.Bundle) throws android.os.RemoteException
            // public abstract int android.app.IActivityTaskManager.startActivity(whoThread, who.getBasePackageName(), intent,intent.resolveTypeIfNeeded(who.getContentResolver()),token, target != null ? target.mEmbeddedID : null,requestCode, 0, null, options);
            return method.invoke(mIActivityManager, *(args ?: arrayOfNulls<Any>(0)))
        }
    }

    /**
     * 对应<9.0情况,创建一个Handler的Callback接口的实例对象
     */
    private class HandlerCallback : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            handleLaunchActivity(msg)
            return false
        }
    }

    /**
     * 对Android 9.0的处理
     * https://www.cnblogs.com/Jax/p/9521305.html
     */
    private class HandlerCallbackP : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            // android.app.ActivityThread$H.EXECUTE_TRANSACTION = 159
            // android 9.0反射,Accessing hidden field Landroid/app/ActivityThread$H;->EXECUTE_TRANSACTION:I (dark greylist, reflection)
            // android9.0 深灰名单（dark greylist）则debug版本在会弹出dialog提示框，在release版本会有Toast提示，均提示为"Detected problems with API compatibility"
            if (msg.what == 159) { // 直接写死,不反射了,否则在android9.0的设备上运行会弹出使用了反射的dialog提示框
                handleActivity(msg)
            }
            return false
        }

        @SuppressLint("DiscouragedPrivateApi")
        private fun handleActivity(msg: Message) {
            try {
                // ClientTransaction-->ClientTransaction中的List<ClientTransactionItem> mActivityCallbacks-->集合中的第一个值LaunchActivityItem-->LaunchActivityItem的mIntent
                // 这里简单起见,直接取出TargetActivity;
                // final ClientTransaction transaction = (ClientTransaction) msg.obj;
                // 1.获取ClientTransaction对象
                val clientTransactionObj = msg.obj ?: return

                // filter
                // public ActivityLifecycleItem getLifecycleStateRequest() { return mLifecycleStateRequest; }
                val activityLifecycleItem =
                    Class.forName("android.app.servertransaction.ClientTransaction")
                        .getDeclaredMethod("getLifecycleStateRequest")
                        .also { it.isAccessible = true }.invoke(clientTransactionObj)

                val resumeActivityItemClazz =
                    Class.forName("android.app.servertransaction.ResumeActivityItem")
                if (!resumeActivityItemClazz.isInstance(activityLifecycleItem)) return

                // 2.获取ClientTransaction类中属性mActivityCallbacks的Field
                // 3.禁止Java访问检查
                // private List<ClientTransactionItem> mActivityCallbacks;
                val mActivityCallbacksField =
                    clientTransactionObj.javaClass.getDeclaredField("mActivityCallbacks")
                        .also { it.isAccessible = true }

                // 4.获取ClientTransaction类中mActivityCallbacks属性的值,既List<ClientTransactionItem>
                val mActivityCallbacks = mActivityCallbacksField[clientTransactionObj] as? List<*>
                if (mActivityCallbacks == null || mActivityCallbacks.isEmpty()) return
                if (mActivityCallbacks[0] == null) return

                // 5.ClientTransactionItem的Class对象
                // package android.app.servertransaction;
                // public class LaunchActivityItem extends ClientTransactionItem
                val launchActivityItemClazz =
                    Class.forName("android.app.servertransaction.LaunchActivityItem")

                // 6.判断集合中第一个元素的值是LaunchActivityItem类型的
                if (!launchActivityItemClazz.isInstance(mActivityCallbacks[0])) return

                // 7.获取LaunchActivityItem的实例
                // public class LaunchActivityItem extends ClientTransactionItem
                val launchActivityItem = mActivityCallbacks[0]

                // 8.ClientTransactionItem的mIntent属性的mIntent的Field
                // private Intent mIntent;
                // 9.禁止Java访问检查
                val mIntentField = launchActivityItemClazz.getDeclaredField("mIntent")
                    .also { it.isAccessible = true }

                // 10.获取mIntent属性的值,既桩Intent(安全的Intent)
                // 从LaunchActivityItem中获取属性mIntent的值
                val safeIntent = mIntentField[launchActivityItem] as? Intent ?: return

                // 11.获取原始的Intent
                // 12.需要判断originIntent != null
                val originIntent: Intent? =
                    if (Build.VERSION.SDK_INT >= 33) {
                        safeIntent.getParcelableExtra(EXTRA_ORIGIN_INTENT, Intent::class.java)
                    } else {
                        @Suppress("DEPRECATION")
                        safeIntent.getParcelableExtra(EXTRA_ORIGIN_INTENT)
                    }
                if (originIntent == null) return

                // 13.将原始的Intent,赋值给clientTransactionItem的mIntent属性
                safeIntent.component = originIntent.component

                // 给插件apk设置主题
                val activityInfo: ActivityInfo = launchActivityItemClazz.getDeclaredField("mInfo")
                    .also { it.isAccessible = true }.get(launchActivityItem) as ActivityInfo
                activityInfo.theme = selectSystemTheme()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private class PackageManagerProxyHandler(
        private val mIPackageManagerObj: Any?,
        private val mAppPackageName: String,
        private val mSubActivityClazzName: String,
    ) : InvocationHandler {
        // bug fixed java.lang.NullPointerException: null cannot be cast to non-null type kotlin.Any
        @Throws(Throwable::class)
        override fun invoke(proxy: Any, method: Method, args: Array<Any>?): Any? {
            // public android.content.pm.ActivityInfo getActivityInfo(android.content.ComponentName className, int flags, int userId)
            if ("getActivityInfo" == method.name && !args.isNullOrEmpty()) {
                var index = 0
                for (i in args.indices) {
                    if (args[i] is ComponentName) {
                        index = i
                        break
                    }
                }
                val componentName = ComponentName(mAppPackageName, mSubActivityClazzName)
                args[index] = componentName
            }
            // https://blog.csdn.net/skeeing/article/details/96122977
            // https://stackoverflow.com/questions/41774450/why-is-kotlin-throw-illegalargumentexception-when-using-proxy
            // * is also used to pass an array to a vararg parameter
            // method!!.invoke(worker, *(args ?: arrayOfNulls<Any>(0)))
            return try {
                method.invoke(mIPackageManagerObj, *(args ?: arrayOfNulls<Any>(0)))
            } catch (e: IllegalAccessException) {
                println("IllegalAccessException appear")
                throw e.cause
                    ?: IllegalAccessException("PackageManagerProxyHandler IllegalAccessException unKnow")
            } catch (e: InvocationTargetException) {
                throw e.cause
                    ?: IllegalAccessException("PackageManagerProxyHandler InvocationTargetException unKnow")
            }
        }
    }
}
