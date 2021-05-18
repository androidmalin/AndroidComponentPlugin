package com.malin.android;

public class ContextImpl extends Context {
    final ActivityThread mMainThread;


    public ContextImpl(ActivityThread activityThread) {
        mMainThread = activityThread;
    }

    public ClassLoader getClassLoader() {
        return ClassLoader.getSystemClassLoader();
    }


    public static ContextImpl createAppContext(ActivityThread activityThread) {
        return new ContextImpl(activityThread);
    }

    @Override
    public void startActivity(Intent intent) {
        System.out.println("ContextImpl#startActivity(Intent intent)");
    }

    @Override
    public Context getApplicationContext() {
        return mMainThread.getApplication();
    }
}
