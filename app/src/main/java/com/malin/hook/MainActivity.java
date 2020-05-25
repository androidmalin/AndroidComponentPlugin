package com.malin.hook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnHookAmsActivity;
    private Button mBtnHookAmsAppCompatActivity;
    private Button mBtnDownloadPlugin;
    private Button mBtnStartPluginActivity;
    private Button mBtnStartPluginAppCompatActivity;


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
        mBtnDownloadPlugin = findViewById(R.id.btn_download_plugin_apk);
        mBtnStartPluginActivity = findViewById(R.id.btn_start_plugin_apk_activity);
        mBtnStartPluginAppCompatActivity = findViewById(R.id.btn_start_plugin_apk_appcompat_activity);
    }


    private void initData() {
        mBtnHookAmsActivity.setVisibility(View.VISIBLE);
        mBtnHookAmsAppCompatActivity.setVisibility(View.VISIBLE);
    }

    private void initListener() {
        mBtnHookAmsActivity.setOnClickListener(this);
        mBtnHookAmsAppCompatActivity.setOnClickListener(this);
        mBtnDownloadPlugin.setOnClickListener(this);
        mBtnStartPluginActivity.setOnClickListener(this);
        mBtnStartPluginAppCompatActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_start: {
                startHook(false);
                startActivity(new Intent(this, TargetActivity.class));
                break;
            }
            case R.id.btn_start_appcompat: {
                startHook(true);
                startActivity(new Intent(this, TargetAppCompatActivity.class));
                break;
            }


            case R.id.btn_download_plugin_apk: {
                PluginUtils.extractAssets(MApplication.getInstance(), "pluginapk-debug.apk");
                File dexFile = getFileStreamPath("pluginapk-debug.apk");
                File optDexFile = getFileStreamPath("pluginapk-debug.dex");
                BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
                break;
            }

            case R.id.btn_start_plugin_apk_activity: {
                //HookActivity.hookPackageManager(this, StubActivity.class);
                startHook(false);
                //start plugin activity
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginActivity"));
                startActivity(intent);
                break;
            }


            case R.id.btn_start_plugin_apk_appcompat_activity: {
                HookActivity.hookPackageManager(this, StubAppCompatActivity.class);
                startHook(true);
                //start plugin activity
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginAppCompatActivity"));
                startActivity(intent);
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
