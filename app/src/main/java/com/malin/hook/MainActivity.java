package com.malin.hook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.os.BuildCompat;

import java.lang.reflect.InvocationTargetException;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnHookAmsActivity;
    private Button mBtnHookAmsAppCompatActivity;
    private Button mBtnHookInstrumentationActivity;
    private Button mBtnHookInstrumentationAppCompatActivity;


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
                HookActivity.hookPackageManager(this, StubActivity.class);
                startActivity(new Intent(this, TargetActivity.class));
                break;
            }

            case R.id.btn_start_instrumentation_appCompat: {
                HookActivity.hookPackageManager(this, StubAppCompatActivity.class);
                startActivity(new Intent(this, TargetAppCompatActivity.class));
                break;
            }

            default: {
                break;
            }
        }
    }

    private void startHook(boolean isAppCompatActivity) {
        MApplication.reset();
        try {
            if (isAppCompatActivity) {
                HookAMS.hookStartActivity(this, StubAppCompatActivity.class, true);
            } else {
                HookAMS.hookStartActivity(this, StubActivity.class, false);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
