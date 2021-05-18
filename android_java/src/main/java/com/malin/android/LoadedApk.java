package com.malin.android;

public class LoadedApk {
    Application app;
    ActivityThread mActivityThread;

    public LoadedApk(ActivityThread activityThread) {
        this.mActivityThread = activityThread;
    }

    public Application makeApplication() {
        ContextImpl appContext = ContextImpl.createAppContext(mActivityThread);
        try {
            String appClass = "com.malin.android.Application";
            app = mActivityThread.mInstrumentation.newApplication(ClassLoader.getSystemClassLoader(), appClass, appContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return app;
    }
}
