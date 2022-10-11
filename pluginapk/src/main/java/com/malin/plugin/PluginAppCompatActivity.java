package com.malin.plugin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

@SuppressLint("SetTextI18n")
public class PluginAppCompatActivity extends BaseActivity {

    private static final String TAG = "PluginAppCompatActivity";

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, TAG + ":onCreate");
        View rootView;
        if (pluginInHostRunning) {
            // 插件apk在宿主中运行
            rootView = LayoutInflater.from(mContext).inflate(R.layout.plugin_activity, null);
        } else {
            // 插件作为独立的apk运行
            rootView = LayoutInflater.from(this).inflate(R.layout.plugin_activity, null);
        }
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PluginAppCompatActivity.this.finish();
            }
        });
        setContentView(rootView);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, TAG + ":onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, TAG + ":onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, TAG + ":onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, TAG + ":onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, TAG + ":onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, TAG + ":onDestroy");
    }

}
