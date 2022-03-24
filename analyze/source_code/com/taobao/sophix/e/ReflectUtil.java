package com.taobao.sophix.e;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {
    public static Class<?> a = method("android.app.ContextImpl");
    public static Class<?> activityTheadClazz = method("android.app.ActivityThread");

    private static Class<?> method(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Method method(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }

    public static Constructor<?> method(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
        if (!declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor;
    }

    public static Field field(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Field declaredField = clazz.getDeclaredField(fieldName);
        if (!declaredField.isAccessible()) declaredField.setAccessible(true);
        return declaredField;
    }
}