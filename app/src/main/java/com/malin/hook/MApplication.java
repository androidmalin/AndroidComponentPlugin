package com.malin.hook;

import android.app.Application;
import android.content.Context;

import com.malin.plugin.impl.PluginImpl;


public class MApplication extends Application {

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        PluginImpl.getInstance().init(context, true, true);
    }
}
