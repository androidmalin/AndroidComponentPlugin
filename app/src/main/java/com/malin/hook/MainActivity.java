package com.malin.hook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
    private Button mBtnSendBroadCastToPlugin;
    private ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();

    private static final String PLUGIN_APK = "pluginapk-debug.apk";
    private static final String RECEIVER_PLUGIN = "receiverPlugin-debug.apk";
    private static final String PLUGIN_SEND_ACTION = "com.malin.receiver.plugin.receiver1.SEND_ACTION";
    private static final String ACTION_PLUGIN1 = "com.malin.receiver.plugin.Receiver1.action";
    private static final String ACTION_PLUGIN2 = "com.malin.receiver.plugin.Receiver2.action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
        initReceiverPlugin();
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
        mBtnSendBroadCastToPlugin = findViewById(R.id.btn_send_broadcast_to_plugin);
    }


    private void initData() {
        if (MApplication.getInstance().isHookInstrumentation()) {
            mBtnHookAmsActivity.setVisibility(View.GONE);
            mBtnHookAmsAppCompatActivity.setVisibility(View.GONE);
            if (MApplication.getInstance().isHookInstrumentationIsAppCompatActivity()) {
                mBtnHookInstrumentationAppCompatActivity.setVisibility(View.VISIBLE);
                mBtnHookInstrumentationActivity.setVisibility(View.VISIBLE);
                mBtnStartPluginActivity.setVisibility(View.VISIBLE);
                mBtnStartPluginAppCompatActivity.setVisibility(View.VISIBLE);
            } else {
                mBtnHookInstrumentationAppCompatActivity.setVisibility(View.GONE);
                mBtnHookInstrumentationActivity.setVisibility(View.VISIBLE);
                mBtnStartPluginActivity.setVisibility(View.VISIBLE);
                mBtnStartPluginAppCompatActivity.setVisibility(View.GONE);
            }
        } else {
            mBtnHookAmsActivity.setVisibility(View.VISIBLE);
            mBtnHookAmsAppCompatActivity.setVisibility(View.VISIBLE);
            mBtnHookInstrumentationActivity.setVisibility(View.GONE);
            mBtnHookInstrumentationAppCompatActivity.setVisibility(View.GONE);
        }
        if (Build.VERSION.SDK_INT < 29) {
            mBtnTestBlackListApi.setVisibility(View.GONE);
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
        mBtnSendBroadCastToPlugin.setOnClickListener(this);
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
                    Toast.makeText(this, "暂不支持>=android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }
                startHook(false);
                startActivity(new Intent(this, TargetActivity.class));
                break;
            }
            case R.id.btn_start_appcompat: {
                if (!MApplication.getInstance().isHookInstrumentation() && (Build.VERSION.SDK_INT >= 29 || BuildCompat.isAtLeastQ())) {
                    Toast.makeText(this, "暂不支持>=android-Q", Toast.LENGTH_SHORT).show();
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
                Runnable patchClassLoaderRunnable = new Runnable() {
                    @Override
                    public void run() {
                        PluginUtils.extractAssets(MApplication.getInstance(), PLUGIN_APK);
                        File dexFile = getFileStreamPath(PLUGIN_APK);
                        File optDexFile = getFileStreamPath(PLUGIN_APK);
                        BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
                    }
                };
                mSingleThreadExecutor.execute(patchClassLoaderRunnable);
                break;
            }

            case R.id.btn_start_plugin_apk_activity: {
                if (!MApplication.getInstance().isHookInstrumentation() && (Build.VERSION.SDK_INT >= 29 || BuildCompat.isAtLeastQ())) {
                    Toast.makeText(this, "暂不支持android-Q", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (MApplication.getInstance().isHookInstrumentation()) {
                    //use hook Instrumentation, please modify MApplication#mHookInstrumentation=true;
                    MApplication.resetPms();
                    HookActivity.hookPackageManager(this, StubActivity.class);
                } else {
                    startHook(false);
                }

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
                if (MApplication.getInstance().isHookInstrumentation()) {
                    //use hook Instrumentation, please modify MApplication#mHookInstrumentation=true;mHookInstrumentation_is_appcompatActivity=true;
                    MApplication.resetPms();
                    HookActivity.hookPackageManager(this, StubAppCompatActivity.class);
                } else {
                    startHook(true);
                }
                //start plugin activity
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginAppCompatActivity"));
                startActivity(intent);
                break;
            }

            case R.id.btn_send_broadcast_to_plugin: {
                sendBroadcast(new Intent(ACTION_PLUGIN1));
                sendBroadcast(new Intent(ACTION_PLUGIN2));
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
        if (Build.VERSION.SDK_INT < 29) return;
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

    private void initReceiverPlugin() {
        Runnable receiverPluginRegisterRunnable = new Runnable() {
            @Override
            public void run() {
                PluginUtils.extractAssets(MainActivity.this.getApplicationContext(), RECEIVER_PLUGIN);

                // /data/data/com.malin.hook/files/receiverPlugin-debug.apk
                File testPlugin = getFileStreamPath(RECEIVER_PLUGIN);
                try {
                    ReceiverHelper.preLoadReceiver(MainActivity.this, testPlugin);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                // 注册插件收到我们发送的广播之后, 回传的广播
                registerReceiver(mReceiver, new IntentFilter(PLUGIN_SEND_ACTION));
            }
        };
        mSingleThreadExecutor.execute(receiverPluginRegisterRunnable);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive 插件插件,我是主程序,握手完成!");
            Toast.makeText(context, "插件插件,我是主程序,握手完成!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mReceiver != null) unregisterReceiver(mReceiver);
        ReceiverHelper.unregisterReceiver(MainActivity.this);
    }
}
