package com.malin.hook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }


    private void initView() {
        mImageView = findViewById(R.id.iv_image_plugin);
    }

    private void initListener() {
        mImageView.setOnClickListener(this);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_start_appcompat).setOnClickListener(this);
        findViewById(R.id.btn_start_plugin_apk_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_plugin_apk_appcompat_activity).setOnClickListener(this);
        findViewById(R.id.btn_load_img).setOnClickListener(this);
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

            case R.id.btn_load_img: {
                Drawable drawable = PluginResourceUtil.getPluginDrawableByName(this, "pluginapk-debug.apk", "com.malin.plugin", "plugin_img");
                mImageView.setImageDrawable(drawable);
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
