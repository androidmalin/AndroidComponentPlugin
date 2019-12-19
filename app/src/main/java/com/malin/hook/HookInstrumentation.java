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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 适配android15-28,android Q
 * 代码参考 android 进阶解密第十五章
 */
@SuppressLint("PrivateApi")
public class HookInstrumentation {

    private static final String TARGET_INTENT_NAME = "target_intent_name";

    public static void hookInstrumentation(Context context, String stubActivityClassName) {

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

    @SuppressWarnings("JavaReflectionMemberAccess")
    @SuppressLint("DiscouragedPrivateApi")
    private static class InstrumentationProxy extends Instrumentation {

        private Instrumentation mInstrumentation;
        private PackageManager mPackageManager;
        private String mStubActivityClassName;

        public InstrumentationProxy(Instrumentation instrumentation, PackageManager packageManager, String stubActivityClassName) {
            mInstrumentation = instrumentation;
            mPackageManager = packageManager;
            mStubActivityClassName = stubActivityClassName;
        }

        /**
         * Instrumentation的execStartActivity方法激活Activity生命周期
         * 使用占坑的Activity来通过AMS的验证.
         */
        public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode, Bundle options) {

            List<ResolveInfo> resolveInfoList = null;

            try {
                //TODO:queryIntentActivities API23以上才有的问题.
                //http://androidxref.com/9.0.0_r3/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com//8.1.0_r33/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/8.0.0_r4/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/7.1.2_r36/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com//7.0.0_r1/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com//6.0.1_r10/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com//5.1.1_r6/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/5.0.0_r2/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/4.4_r1/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/4.3_r2.1/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/4.2_r1/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                //http://androidxref.com/4.1.2/xref/frameworks/base/core/java/android/content/pm/PackageManager.java#queryIntentActivities
                resolveInfoList = mPackageManager.queryIntentActivities(intent, PackageManager.MATCH_ALL);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            if (resolveInfoList == null || resolveInfoList.size() == 0) {
                //目标Activity没有在AndroidManifest.xml中注册的话,将目标Activity的ClassName保存到桩Intent中.
                if (intent.getComponent() != null) {
                    intent.putExtra(TARGET_INTENT_NAME, intent.getComponent().getClassName());//未注册的Activity的名字
                    intent.setClassName(who, mStubActivityClassName);//替换要启动的Activity为 桩Activity
                }
            }
            try {
                //通过反射调用execStartActivity方法,这样就可以用桩Activity通过AMS的验证.
                Method execMethod = Instrumentation.class.getDeclaredMethod("execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
                return (ActivityResult) execMethod.invoke(mInstrumentation, who, contextThread, token, target, intent, requestCode, options);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        }


        /**
         * Instrumentation的newActivity方法,用类加载器来创建Activity实例
         * 还原目标Activity.
         */
        @Override
        public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
            if (Build.VERSION.SDK_INT >= 28) {
                String intentName = intent.getStringExtra(TARGET_INTENT_NAME);
                if (!TextUtils.isEmpty(intentName)) {
                    return mInstrumentation.newActivity(cl, intentName, intent);
                }
                return mInstrumentation.newActivity(cl, className, intent);
            } else {
                String intentName = intent.getStringExtra(TARGET_INTENT_NAME);
                if (!TextUtils.isEmpty(intentName)) {
                    return super.newActivity(cl, intentName, intent);
                }
                return super.newActivity(cl, className, intent);
            }
        }
    }

}
