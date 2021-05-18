package com.malin.android.simple;

public class Application extends ContextWrapper {
    public void attach(Context context) {
        attachBaseContext(context);
    }
}
