package org.chickenhook.restrictionbypass;

import static android.os.Build.VERSION.SDK_INT;

import java.lang.reflect.Method;

public class Unseal {

    public static void unseal() throws Exception {
        if (SDK_INT < 28) {
            // Below Android P, ignore
            return;
        }
        Method getRuntime = RestrictionBypass.getDeclaredMethod(
                Class.forName("dalvik.system.VMRuntime"),
                "getRuntime"
        );
        getRuntime.setAccessible(true);
        Object vmRuntime = getRuntime.invoke(null);
        if (vmRuntime == null) throw new NullPointerException("vmRuntime==null");

        Method setHiddenApiExemptions = RestrictionBypass.getDeclaredMethod(
                vmRuntime.getClass(),
                "setHiddenApiExemptions",
                String[].class
        );
        setHiddenApiExemptions.setAccessible(true);

        String[] list = new String[1];
        list[0] = "L";
        Object[] args = new Object[1];
        args[0] = list;
        setHiddenApiExemptions.invoke(vmRuntime, args);
        // setHiddenApiExemptions
    }
}
