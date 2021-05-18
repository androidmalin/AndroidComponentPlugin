package com.malin.android;

public class Application extends ContextWrapper {
    public void attach(Context context) {
        attachBaseContext(context);
    }
}
