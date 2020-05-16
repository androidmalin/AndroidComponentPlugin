package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;

import androidx.annotation.Keep;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 适配android15-28,android Q
 * 代码参考 android 进阶解密第十五章
 */
@SuppressLint("PrivateApi")
class HookInstrumentation {

    private static final String TARGET_INTENT_CLASS = "target_intent_class";

    @Keep
    static void hookInstrumentation(Context context, Class<?> stubActivityClassName) {

        try {
            //1.ContextImpl-->mMainThread
            //package android.app
            //class ContextImpl
            Class<?> contextImplClazz = Class.forName("android.app.ContextImpl");

            //final @NonNull ActivityThread mMainThread;
            Field mMainThreadField = contextImplClazz.getDeclaredField("mMainThread");
            mMainThreadField.setAccessible(true);

            //2.ActivityThread Object
            Object activityThreadObj = mMainThreadField.get(context);

            //3.mInstrumentation Object
            Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");

            //Instrumentation mInstrumentation;
            Field mInstrumentationField = activityThreadClazz.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);
            Instrumentation mInstrumentationObj = (Instrumentation) mInstrumentationField.get(activityThreadObj);

            //4.reset set value
            mInstrumentationField.set(activityThreadObj, new InstrumentationProxy(mInstrumentationObj, context.getPackageManager(), stubActivityClassName));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Keep
    @SuppressWarnings("JavaReflectionMemberAccess")
    @SuppressLint("DiscouragedPrivateApi")
    private static class InstrumentationProxy extends Instrumentation {

        private final Instrumentation mInstrumentation;
        private final PackageManager mPackageManager;
        private final Class<?> mStubActivityClass;

        InstrumentationProxy(Instrumentation instrumentation, PackageManager packageManager, Class<?> stubActivityClassName) {
            mInstrumentation = instrumentation;
            mPackageManager = packageManager;
            mStubActivityClass = stubActivityClassName;
        }

        /**
         * android16-android29
         * Instrumentation的execStartActivity方法激活Activity生命周期
         * 使用占坑的Activity来通过AMS的验证.
         */
        @Keep
        @SuppressWarnings("unused")
        public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode, Bundle options) {
            List<ResolveInfo> resolveInfoList = null;
            try {
                int flags = 0;
                if (Build.VERSION.SDK_INT >= 23) {
                    flags = PackageManager.MATCH_ALL;
                }
                resolveInfoList = mPackageManager.queryIntentActivities(intent, flags);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            Intent finalIntent = intent;
            if (resolveInfoList == null || resolveInfoList.size() == 0) {
                //目标Activity没有在AndroidManifest.xml中注册的话,将目标Activity的ClassName保存到桩Intent中.
                finalIntent = new Intent(who, mStubActivityClass);
                //public class Intent implements Parcelable;
                //Intent类已经实现了Parcelable接口
                finalIntent.putExtra(TARGET_INTENT_CLASS, intent);
            }
            try {
                //通过反射调用execStartActivity方法,这样就可以用桩Activity通过AMS的验证.
                Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod("execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
                return (ActivityResult) execStartActivityMethod.invoke(mInstrumentation, who, contextThread, token, target, finalIntent, requestCode, options);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * just for android-15
         * Instrumentation#execStartActivity()方法参数和其他版本不同, 需要单独适配
         * Instrumentation的execStartActivity方法激活Activity生命周期
         * 使用占坑的Activity来通过AMS的验证.
         * http://androidxref.com/4.0.3_r1/xref/frameworks/base/core/java/android/app/Instrumentation.java
         */
        @Keep
        @SuppressLint("WrongConstant")
        @SuppressWarnings("unused")
        public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode) {
            if (Build.VERSION.SDK_INT != 15) return null;
            List<ResolveInfo> resolveInfoList = null;
            try {
                int flags = 0;
                resolveInfoList = mPackageManager.queryIntentActivities(intent, flags);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            Intent finalIntent = intent;
            if (resolveInfoList == null || resolveInfoList.size() == 0) {
                //目标Activity没有在AndroidManifest.xml中注册的话,将目标Activity的ClassName保存到桩Intent中.
                finalIntent = new Intent(who, mStubActivityClass);
                //public class Intent implements Parcelable;
                //Intent类已经实现了Parcelable接口
                finalIntent.putExtra(TARGET_INTENT_CLASS, intent);
            }
            try {
                //just for android-15
                //通过反射调用execStartActivity方法,这样就可以用桩Activity通过AMS的验证.
                Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod("execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, int.class);
                return (ActivityResult) execStartActivityMethod.invoke(mInstrumentation, who, contextThread, token, target, finalIntent, requestCode);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * Instrumentation的newActivity方法,用类加载器来创建Activity实例
         * 还原目标Activity.
         */
        @Keep
        @Override
        public Activity newActivity(ClassLoader classLoader, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
            Intent pluginIntent = intent.getParcelableExtra(TARGET_INTENT_CLASS);
            boolean pluginIntentClassNameExist = pluginIntent != null && !TextUtils.isEmpty(pluginIntent.getComponent().getClassName());
            String finalClassName = pluginIntentClassNameExist ? pluginIntent.getComponent().getClassName() : className;
            Intent finalIntent = pluginIntentClassNameExist ? pluginIntent : intent;
            if (Build.VERSION.SDK_INT >= 28)
                return mInstrumentation.newActivity(classLoader, finalClassName, finalIntent);
            return super.newActivity(classLoader, finalClassName, finalIntent);
        }
    }
}
