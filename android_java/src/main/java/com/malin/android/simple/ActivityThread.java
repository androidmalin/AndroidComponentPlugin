package com.malin.android.simple;

public class ActivityThread {

    LoadedApk loadedApk = new LoadedApk();
    Instrumentation mInstrumentation;

    private Activity performLaunchActivity() {
        loadedApk.makeApplication();
        return new Activity();
    }

    public static void main(String[] args) {
        ActivityThread thread = new ActivityThread();
        thread.attach();

        Activity activity = thread.performLaunchActivity();
        System.out.println(activity);
    }

    private void attach() {
        mInstrumentation = new Instrumentation();
    }
}
