package com.malin.hook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.os.BuildCompat;

import java.io.File;
import java.lang.reflect.Field;


public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button mBtnHookAmsActivity;
    private Button mBtnHookAmsAppCompatActivity;
    private Button mBtnHookInstrumentationActivity;
    private Button mBtnHookInstrumentationAppCompatActivity;
    private Button mBtnHookService;
    private Button mBtnDownloadPlugin;
    private Button mBtnStartPluginActivity;
    private Button mBtnStartPluginAppCompatActivity;
    private Button mBtnTestBlackListApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    private void initView() {
        mBtnHookAmsActivity = findViewById(R.id.btn_start);
        mBtnHookAmsAppCompatActivity = findViewById(R.id.btn_start_appcompat);
        mBtnHookInstrumentationActivity = findViewById(R.id.btn_start_instrumentation);
        mBtnHookInstrumentationAppCompatActivity = findViewById(R.id.btn_start_instrumentation_appCompat);
        mBtnHookService = findViewById(R.id.btn_service);
        mBtnDownloadPlugin = findViewById(R.id.btn_download_plugin_apk);
        mBtnStartPluginActivity = findViewById(R.id.btn_start_plugin_apk_activity);
        mBtnStartPluginAppCompatActivity = findViewById(R.id.btn_start_plugin_apk_appcompat_activity);
        mBtnTestBlackListApi = findViewById(R.id.btn_test_hide_black_api);
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
        mBtnStartPluginActivity.setOnClickListener(this);
        mBtnStartPluginAppCompatActivity.setOnClickListener(this);
        mBtnTestBlackListApi.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btn_test_hide_black_api: {
                testBlackListApi();
                break;
            }
            case R.id.btn_start: {
                if (!MApplication.getInstance().isHookInstrumentation() && (Build.VERSION.SDK_INT >= 29 || BuildCompat.isAtLeastQ())) {
                    Toast.makeText(this, "暂不支持android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }
                startHook(false);
                startActivity(new Intent(this, TargetActivity.class));
                break;
            }
            case R.id.btn_start_appcompat: {
                if (!MApplication.getInstance().isHookInstrumentation() && (Build.VERSION.SDK_INT >= 29 || BuildCompat.isAtLeastQ())) {
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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PluginUtils.extractAssets(MApplication.getInstance(), "pluginapk-debug.apk");
                        File dexFile = getFileStreamPath("pluginapk-debug.apk");
                        File optDexFile = getFileStreamPath("pluginapk-debug.dex");
                        BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
                    }
                }).start();
                break;
            }

            case R.id.btn_start_plugin_apk_activity: {
                if (!MApplication.getInstance().isHookInstrumentation() && (Build.VERSION.SDK_INT >= 29 || BuildCompat.isAtLeastQ())) {
                    Toast.makeText(this, "暂不支持android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }
                //use hook Instrumentation, please modify MApplication#mHookInstrumentation=true;
                MApplication.resetPms();
                HookActivity.hookPackageManager(this, StubActivity.class);

                //start plugin activity
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginActivity"));
                startActivity(intent);
                break;
            }


            case R.id.btn_start_plugin_apk_appcompat_activity: {
                if (!MApplication.getInstance().isHookInstrumentation() && (Build.VERSION.SDK_INT >= 29 || BuildCompat.isAtLeastQ())) {
                    Toast.makeText(this, "暂不支持android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }
                //use hook Instrumentation, please modify MApplication#mHookInstrumentation=true;mHookInstrumentation_is_appcompatActivity=true;
                MApplication.resetPms();
                HookActivity.hookPackageManager(this, StubAppCompatActivity.class);

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

    /**
     * 测试黑名单API
     * <p>
     * 正常情况
     * Accessing hidden field Landroid/app/ActivityManager;->INSTR_FLAG_DISABLE_HIDDEN_API_CHECKS:I (blacklist, reflection, denied)
     * System.err  W  java.lang.NoSuchFieldException: INSTR_FLAG_DISABLE_HIDDEN_API_CHECKS
     */
    @SuppressWarnings("JavaReflectionMemberAccess")
    private void testBlackListApi() {
        try {
            //1.
            //package android.app;
            //ActivityManager
            Class<?> activityManagerClazz = Class.forName("android.app.ActivityManager");

            //2.
            //Disable hidden API checks for the newly started instrumentation.
            // @hide
            //public static final int INSTR_FLAG_DISABLE_HIDDEN_API_CHECKS = 1 << 0;
            Field field = activityManagerClazz.getField("INSTR_FLAG_DISABLE_HIDDEN_API_CHECKS");

            //3.get value
            int check_flag = (int) field.get(null);
            Log.d(TAG, "get blacklist api :" + check_flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
