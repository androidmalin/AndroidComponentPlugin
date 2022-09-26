package com.malin.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;

import java.io.File;
import java.lang.reflect.Field;

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resource = PluginResourceUtil.getResource(getApplication());
        mContext = new ContextThemeWrapper(getBaseContext(),  R.style.AppCompatThemePlugin);
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
}
