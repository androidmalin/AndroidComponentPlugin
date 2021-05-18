package com.malin.android.simple;

public class LoadedApk {
    Application app;
    ActivityThread mActivityThread = new ActivityThread();

    public Application makeApplication() {
        ContextImpl appContext = ContextImpl.createAppContext();
        try {
            String appClass = "com.malin.android.simple.Application";
            app = mActivityThread.mInstrumentation.newApplication(ClassLoader.getSystemClassLoader(), appClass, appContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return app;
    }
}
