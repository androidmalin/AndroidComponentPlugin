package com.malin.hook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * AppCompatActivity类型的未注册的Activity
 */
@SuppressLint({"SetTextI18n", "Registered"})
public class TargetAppCompatActivity extends AppCompatActivity {

    private static final String TAG = "TargetAppCompat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, TAG + ":onCreate");

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);

        TextView textView = new TextView(this);
        textView.setText("未注册的TargetAppCompatActivity,成功!");

        relativeLayout.addView(textView);
        setContentView(relativeLayout);
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
