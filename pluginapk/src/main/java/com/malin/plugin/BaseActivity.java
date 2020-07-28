package com.malin.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resource = PluginResourceUtil.getResource(getApplication());
        mContext = new ContextThemeWrapper(getBaseContext(), 0);
        Class<?> contextClazz = mContext.getClass();
        try {
            Field mResourcesField = contextClazz.getDeclaredField("mResources");
            mResourcesField.setAccessible(true);
            mResourcesField.set(mContext, resource);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
