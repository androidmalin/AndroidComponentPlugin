package org.chickenhook.restrictionbypass;

import androidx.annotation.Keep;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class NativeReflectionBypass {

    @Keep
    public static native Method getDeclaredMethod(Object recv, String name, Class<?>[] parameterTypes);

    @Keep
    public static native Method getMethod(Object recv, String name, Class<?>[] parameterTypes);

    @Keep
    public static native Field getDeclaredField(Object recv, String name);

    static {
        System.loadLibrary("nrb");
    }
}
