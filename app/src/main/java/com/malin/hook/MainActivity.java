package com.malin.hook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.os.BuildCompat;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnHookAmsActivity;
    private Button mBtnHookAmsAppCompatActivity;
    private Button mBtnHookInstrumentationActivity;
    private Button mBtnHookInstrumentationAppCompatActivity;
    private Button mBtnHookService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();

    }

    private void initView() {
        mBtnHookAmsActivity = findViewById(R.id.btn_start);
        mBtnHookAmsAppCompatActivity = findViewById(R.id.btn_start_appcompat);
        mBtnHookInstrumentationActivity = findViewById(R.id.btn_start_instrumentation);
        mBtnHookInstrumentationAppCompatActivity = findViewById(R.id.btn_start_instrumentation_appCompat);
        mBtnHookService = findViewById(R.id.btn_service);
    }


    private void initData() {
        if (MApplication.getInstance().isHookInstrumentation()) {
            mBtnHookAmsActivity.setVisibility(View.GONE);
            mBtnHookAmsAppCompatActivity.setVisibility(View.GONE);
            if (MApplication.getInstance().isHookInstrumentationIsAppCompatActivity()) {
                mBtnHookInstrumentationAppCompatActivity.setVisibility(View.VISIBLE);
                mBtnHookInstrumentationActivity.setVisibility(View.GONE);
            } else {
                mBtnHookInstrumentationAppCompatActivity.setVisibility(View.GONE);
                mBtnHookInstrumentationActivity.setVisibility(View.VISIBLE);
            }
        } else {
            mBtnHookAmsActivity.setVisibility(View.VISIBLE);
            mBtnHookAmsAppCompatActivity.setVisibility(View.VISIBLE);
            mBtnHookInstrumentationActivity.setVisibility(View.GONE);
            mBtnHookInstrumentationAppCompatActivity.setVisibility(View.GONE);
        }
    }

    private void initListener() {
        mBtnHookAmsActivity.setOnClickListener(this);
        mBtnHookAmsAppCompatActivity.setOnClickListener(this);
        mBtnHookInstrumentationActivity.setOnClickListener(this);
        mBtnHookInstrumentationAppCompatActivity.setOnClickListener(this);
        mBtnHookService.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_start: {
                if (BuildCompat.isAtLeastQ()) {
                    Toast.makeText(this, "暂不支持android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }
                startHook(false);
                startActivity(new Intent(this, TargetActivity.class));
                break;
            }
            case R.id.btn_start_appcompat: {
                if (BuildCompat.isAtLeastQ()) {
                    Toast.makeText(this, "暂不支持android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }
                startHook(true);
                startActivity(new Intent(this, TargetAppCompatActivity.class));
                break;
            }

            case R.id.btn_start_instrumentation: {
                MApplication.resetPms();
                HookActivity.hookPackageManager(this, StubActivity.class);
                startActivity(new Intent(this, TargetActivity.class));
                break;
            }

            case R.id.btn_start_instrumentation_appCompat: {
                MApplication.resetPms();
                HookActivity.hookPackageManager(this, StubAppCompatActivity.class);
                startActivity(new Intent(this, TargetAppCompatActivity.class));
                break;
            }

            case R.id.btn_service: {
                startService(new Intent(this, TargetService.class));
                break;
            }

            default: {
                break;
            }
        }
    }

    private void startHook(boolean isAppCompatActivity) {
        MApplication.resetPms();
        MApplication.resetAms();
        if (isAppCompatActivity) {
            HookAMS.hookStartActivity(this, StubAppCompatActivity.class, true);
        } else {
            HookAMS.hookStartActivity(this, StubActivity.class, false);
        }
    }
}
