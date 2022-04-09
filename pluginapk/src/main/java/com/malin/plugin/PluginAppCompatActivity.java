package com.malin.plugin;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("SetTextI18n")
public class PluginAppCompatActivity extends BaseActivity {

    private static final String TAG = "PluginAppCompatActivity";

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.d(TAG, TAG + ":onCreate");
        View view = LayoutInflater.from(mContext).inflate(R.layout.plugin_activity, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PluginAppCompatActivity.this.finish();
            }
        });
        try {
            ActionBar actionBar = getActionBar();
            if (actionBar != null) actionBar.hide();
            androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) supportActionBar.hide();
        } catch (Throwable ignore) {

        }
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
