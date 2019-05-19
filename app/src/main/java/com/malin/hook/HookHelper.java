package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressLint("PrivateApi")
public class HookHelper {

    public static void replaceInstrumentation() {

        try {
            // 先获取到当前的ActivityThread对象
            //1.获取ActivityThread的Class对象
            Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");

            //2.获取currentActivityThread静态方法
            //public static ActivityThread currentActivityThread() {return sCurrentActivityThread;}
            @SuppressLint("DiscouragedPrivateApi")
            Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);

            //3.调用currentActivityThread静态方法,获取ActivityThread的实例对象
            //currentActivityThread是一个static函数所以可以直接invoke，不需要带实例参数
            Object currentActivityThread = currentActivityThreadMethod.invoke(null);

            //4.获取ActivityThread中的属性Instrumentation mInstrumentation的Field
            //Instrumentation mInstrumentation;
            Field mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);

            //5.获取Instrumentation mInstrumentation的值
            Instrumentation mInstrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThread);

            //6.创建代理对象
            Instrumentation evilInstrumentation = new ActivityProxyInstrumentation(mInstrumentation);

            //7.给mInstrumentation设置为代理对象的值
            mInstrumentationField.set(currentActivityThread, evilInstrumentation);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    public static class ActivityProxyInstrumentation extends Instrumentation {
        private static final String TAG = "ProxyInstrumentation";
        //ActivityThread中原始的对象, 保存起来

        /**
         * ActivityThread中原始的Instrumentation对象
         */
        Instrumentation mBase;

        /**
         * https://blog.csdn.net/shifuhetudi/article/details/52078445
         */
        private void getLoaderApk() throws NoSuchFieldException, IllegalAccessException {
            MApplication myApplication = MApplication.getInstance();
            Class<?> superClass = myApplication.getClass().getSuperclass();
            if (superClass != null) {
                Field mLoadedApk = superClass.getDeclaredField("mLoadedApk");
                mLoadedApk.setAccessible(true);
                Object mLoadedApkObject = mLoadedApk.get(myApplication);
                Log.d(TAG, "获取的mLoadedApkObject=" + mLoadedApkObject);
            }
        }


        /**
         * 重写创建Activity的方法
         * https://www.cnblogs.com/Jax/p/9521305.html
         */
        @Override
        public Activity newActivity(ClassLoader cl, String className, Intent intent)
                throws InstantiationException, IllegalAccessException, ClassNotFoundException {
            Log.d(TAG, "Hook newActivity");
            try {
                getLoaderApk();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            Log.d(TAG, "Hook newActivity className=" + className + " intent=" + intent);
            return mBase.newActivity(cl, className, intent);
        }

        public ActivityProxyInstrumentation(Instrumentation base) {
            mBase = base;
        }

        public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target,
                                                Intent intent, int requestCode, Bundle options) {

            // Hook之前, 可以输出你想要的!
            Log.e(TAG, " 执行了startActivity, 参数如下: "
                    + "who = [" + who + "], "
                    + "contextThread = [" + contextThread + "], "
                    + "token = [" + token + "], "
                    + "target = [" + target + "], "
                    + "intent = [" + intent + "], "
                    + "requestCode = [" + requestCode + "], "
                    + "options = [" + options + "]");

            // 开始调用原始的方法, 调不调用随你,但是不调用的话, 所有的startActivity都失效了.
            // 由于这个方法是隐藏的,因此需要使用反射调用;首先找到这个方法
            try {
                @SuppressLint("DiscouragedPrivateApi")
                Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod(
                        "execStartActivity",
                        Context.class,
                        IBinder.class,
                        IBinder.class,
                        Activity.class,
                        Intent.class,
                        int.class,
                        Bundle.class);
                execStartActivityMethod.setAccessible(true);
                return (ActivityResult) execStartActivityMethod.invoke(mBase, who, contextThread, token, target, intent, requestCode, options);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                //Rom修改了 需要手动适配
                //throw new RuntimeException("do not support!!! pls adapt it");
            }
            return null;
        }

    }

}
