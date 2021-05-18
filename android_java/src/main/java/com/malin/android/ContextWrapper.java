package com.malin.android;

public class ContextWrapper extends Context {

    Context mBase;

    protected void attachBaseContext(Context base) {
        mBase = base;
    }

    @Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }

    @Override
    public Context getApplicationContext() {
        return mBase.getApplicationContext();
    }
}
