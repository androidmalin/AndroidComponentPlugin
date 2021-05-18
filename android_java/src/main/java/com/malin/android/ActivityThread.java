package com.malin.android;

public class ActivityThread {

    LoadedApk loadedApk;
    Instrumentation mInstrumentation;
    Application mInitialApplication;

    public Activity performLaunchActivity() {
        loadedApk = new LoadedApk(this);
        mInitialApplication = loadedApk.makeApplication();

        ContextImpl appContext = new ContextImpl(this);
        ClassLoader classLoader = appContext.getClassLoader();

        Activity activity = null;
        String activityName = "com.malin.android.Activity";
        try {
            activity = mInstrumentation.newActivity(classLoader, activityName, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activity;
    }

    public Application getApplication() {
        return mInitialApplication;
    }

    public static void main(String[] args) {
        ActivityThread thread = new ActivityThread();
        thread.attach();
        thread.performLaunchActivity();
    }

    public void attach() {
        mInstrumentation = new Instrumentation();
    }
}
