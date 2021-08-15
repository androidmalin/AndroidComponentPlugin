package com.malin.android;

public class Main {

    public static void main(String[] args) {
        ActivityThread thread = new ActivityThread();
        thread.attach();

        Activity activity = thread.performLaunchActivity();
        activity.attach(thread.getApplication());

        //activity.getApplicationContext().startActivity(new Intent());
        activity.startActivity(new Intent());
    }
}
