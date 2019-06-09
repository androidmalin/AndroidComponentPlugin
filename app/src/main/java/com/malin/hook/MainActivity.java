package com.malin.hook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.os.BuildCompat;

import java.io.File;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnHookAmsActivity;
    private Button mBtnHookAmsAppCompatActivity;
    private Button mBtnHookInstrumentationActivity;
    private Button mBtnHookInstrumentationAppCompatActivity;
    private Button mBtnHookService;
    private Button mBtnDownloadPlugin;
    private Button mBtnStartPlugin;


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
        mBtnDownloadPlugin = findViewById(R.id.btn_download_plugin_apk);
        mBtnStartPlugin = findViewById(R.id.btn_start_plugin_apk);
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
        mBtnDownloadPlugin.setOnClickListener(this);
        mBtnStartPlugin.setOnClickListener(this);
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

            case R.id.btn_download_plugin_apk: {
                if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT <= 25) {
                    PluginUtils.extractAssets(MApplication.getInstance(), "pluginapk-debug.apk");
                    File dexFile = getFileStreamPath("pluginapk-debug.apk");
                    File optDexFile = getFileStreamPath("pluginapk-debug.dex");
                    BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
                } else {
                    Toast.makeText(this, "暂时只支持18~23", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.btn_start_plugin_apk: {
                if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT <= 25) {
                    startHook(false);
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginActivity"));
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "暂时只支持18~23", Toast.LENGTH_SHORT).show();
                }
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
