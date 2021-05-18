package com.malin.android.simple;


public class MainActivity {
    public static void main(String[] args) {
        Intent intent = new Intent();
        getApplicationContext().startActivity(intent);
    }

    private static Context getApplicationContext() {
        ContextWrapper wrapper = new ContextWrapper();
        ContextImpl contextImpl = new ContextImpl();
        wrapper.attachBaseContext(contextImpl);
        return wrapper;
    }
}
