package com.malin.android;


public class Instrumentation {

    public Application newApplication(ClassLoader cl, String className, Context context)
            throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Application app = instantiateApplication(cl, className);
        app.attach(context);
        return app;
    }

    public Activity newActivity(ClassLoader cl, String className, Intent intent)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        return instantiateActivity(cl, className, intent);
    }

    public Activity instantiateActivity(ClassLoader cl, String className, Intent intent)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) cl.loadClass(className).newInstance();
    }

    public Application instantiateApplication(ClassLoader cl, String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) cl.loadClass(className).newInstance();
    }
}
