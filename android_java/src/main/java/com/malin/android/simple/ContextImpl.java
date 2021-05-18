package com.malin.android.simple;

public class ContextImpl extends Context {

    public static ContextImpl createAppContext() {
        return new ContextImpl();
    }

    @Override
    public void startActivity(Intent intent) {
        System.out.println("ContextImpl#startActivity(Intent intent)");
    }
}
