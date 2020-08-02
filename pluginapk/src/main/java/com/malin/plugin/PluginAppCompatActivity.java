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
        PluginResourceUtil.testLayoutId(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.plugin_activity, null);
        setContentView(view);
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
