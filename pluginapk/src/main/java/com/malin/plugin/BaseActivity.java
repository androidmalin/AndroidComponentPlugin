package com.malin.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;

import java.lang.reflect.Field;

public class BaseActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resource = PluginResourceUtil.getResource(this);
        if (isOppoLollipop()) {
            mContext = new ContextThemeWrapper(getBaseContext(), R.style.plugin_theme);
        } else {
            mContext = new ContextThemeWrapper(getBaseContext(), 0);
        }
        Class<?> contextClazz = mContext.getClass();
        try {
            // android 15/16 java.lang.NoSuchFieldException: mResources
            // fix bug
            // use androidx.appcompat.view.ContextThemeWrapper; Instead of android.view.ContextThemeWrapper;
            Field mResourcesField = contextClazz.getDeclaredField("mResources");
            mResourcesField.setAccessible(true);
            mResourcesField.set(mContext, resource);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public Context getContext() {
        return getFixedContext(mContext);
    }

    private Context getFixedContext(Context context) {
        // Android Lollipop 5.0 & 5.1
        if (isOppo() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            //-1.right
            return context;

            //0.Caused by: android.content.res.Resources$NotFoundException: Resource ID #0x80020000
            //return context.getApplicationContext();

            //1.Caused by: android.content.res.Resources$NotFoundException: Resource ID #0x80020000
            //return context.createConfigurationContext(new Configuration());

            //2.Caused by: java.lang.IllegalStateException: getResources() or getAssets() has already been called
            //((ContextThemeWrapper)context).applyOverrideConfiguration(new Configuration());
        }
        return context;
    }

    private boolean isOppoLollipop() {
        return isOppo() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
    }

    private boolean isOppo() {
        final String brand = getBrand();
        final String manufacturer = getManufacturer();
        return isRightRom(brand, manufacturer, "oppo");
    }

    private static boolean isRightRom(final String brand, final String manufacturer, final String name) {
        return brand.contains(name) || manufacturer.contains(name);
    }

    private static String getManufacturer() {
        try {
            String manufacturer = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(manufacturer)) {
                return manufacturer.toLowerCase();
            }
        } catch (Throwable ignore) {
        }
        return "UNKNOWN";
    }

    private static String getBrand() {
        try {
            String brand = Build.BRAND;
            if (!TextUtils.isEmpty(brand)) {
                return brand.toLowerCase();
            }
        } catch (Throwable ignore) {
        }
        return "UNKNOWN";
    }
}
