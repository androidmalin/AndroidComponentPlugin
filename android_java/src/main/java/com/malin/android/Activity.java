package com.malin.android;

public class Activity extends ContextWrapper {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public final void attach(Context context) {
        attachBaseContext(context);
    }
}
