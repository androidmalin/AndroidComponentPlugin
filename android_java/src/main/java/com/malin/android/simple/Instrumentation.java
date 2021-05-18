package com.malin.android.simple;


public class Instrumentation {

    public Application newApplication(ClassLoader cl, String className, Context context)
            throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Application app = instantiateApplication(cl, className);
        app.attach(context);
        return app;
    }

    public Application instantiateApplication(ClassLoader cl, String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) cl.loadClass(className).newInstance();
    }
}
