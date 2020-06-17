package com.malin.hook;

import android.util.Log;

import java.lang.reflect.Method;

import static android.os.Build.VERSION.SDK_INT;

/**
 * @author weishu
 * 2018/6/7.
 * https://github.com/tiann/FreeReflection
 * http://weishu.me/2018/06/07/free-reflection-above-android-p/
 * http://weishu.me/2019/03/16/another-free-reflection-above-android-p/
 * <p>
 * android 11 not work target R
 * https://www.xda-developers.com/android-11-harden-hidden-api-restriction-meta-reflection/
 * https://developer.android.com/preview/setup-sdk#update-build
 * <p>
 * 思路
 * 首先,我们通过反射 API 拿到 getDeclaredMethod 方法.
 * getDeclaredMethod 是 public 的,不存在问题;这个通过反射拿到的方法我们称之为元反射方法.
 * 然后,我们通过刚刚反射拿到元反射方法去反射调用 getDeclardMethod.
 * 这里我们就实现了以系统身份去反射的目的——反射相关的 API 都是系统类,
 * 因此我们的元反射方法也是被系统类加载的方法;
 * 所以我们的元反射方法调用的 getDeclardMethod 会被认为是系统调用的,可以反射任意的方法.
 */
class Reflection {

    private static final String TAG = "Reflection";

    /**
     * VMRuntime singleton.
     */
    private static Object sVmRuntime;

    private static Method setHiddenApiExemptions;
    private static final int ERROR_EXEMPT_FAILED = -1;
    private static final int ANDROID_P = 28;

    static {
        if (SDK_INT >= ANDROID_P) {
            try {

                //1.forName() 方法-->Class
                //package java.lang.Class
                //public static Class<?> forName(String className){}
                Method forNameMethod = Class.class.getDeclaredMethod("forName", String.class);

                //2.getDeclaredMethod() 方法-->Method
                //package java.lang.Class
                // public Method getDeclaredMethod(String name, Class<?>... parameterTypes){}
                Method getDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);

                //3.生成 VMRuntime class对象
                //Class<?>  vmRuntimeClass = Class.forName("dalvik.system.VMRuntime");
                Class<?> vmRuntimeClass = (Class<?>) forNameMethod.invoke(null, "dalvik.system.VMRuntime");

                //4.生成getRuntime方法
                // VMRuntime singleton.
                // private static final VMRuntime THE_ONE = new VMRuntime();
                // public static VMRuntime getRuntime() {return THE_ONE;}
                Method getRuntime = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "getRuntime", null);


                //5.
                //设置免除隐藏API访问权限的列表
                //public native void setHiddenApiExemptions(String[] signaturePrefixes);

                //signaturePrefixes:
                // 签名前缀列表.
                //列表中的每个项目都是黑名单API的类型签名上的前缀匹配.
                //所有匹配的API均被视为已列入白名单：允许访问,且无日志记录.
                setHiddenApiExemptions = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});

                if (getRuntime != null) {
                    //获取单例的VMRuntime对象
                    sVmRuntime = getRuntime.invoke(null);
                }
            } catch (Throwable e) {
                Log.e(TAG, "reflect bootstrap failed:", e);
            }
        }
    }

    static int unseal() {
        if (SDK_INT < ANDROID_P) {
            // Below Android P, ignore
            return 0;
        }

        // try exempt API first.
        if (exemptAll()) {
            return 0;
        } else {
            return ERROR_EXEMPT_FAILED;
        }
    }


    /**
     * Make all hidden API exempted.
     *
     * @return true if success.
     */
    private static boolean exemptAll() {
        return exempt("L");
    }

    /**
     * make specific methods exempted from hidden API check.
     * 使特定方法免于隐藏API检查.
     *
     * @param methods the method signature prefix, such as "Ldalvik/system", "Landroid" or even "L"
     * @return true if success
     */
    private static boolean exempt(String... methods) {
        if (sVmRuntime == null || setHiddenApiExemptions == null) {
            return false;
        }

        try {
            // class dalvik.system.VMRuntime;
            // public native void setHiddenApiExemptions(String[] signaturePrefixes);
            setHiddenApiExemptions.invoke(sVmRuntime, new Object[]{methods});
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }

}
