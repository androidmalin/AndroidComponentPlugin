package com.malin.hook;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        if (id == R.id.btn_start) {
            startActivity(new Intent(this, TargetActivity.class));
        } else if (id == R.id.btn_start_appcompat) {
            startActivity(new Intent(this, TargetAppCompatActivity.class));
        } else if (id == R.id.btn_start_plugin_apk_activity) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginActivity"));
            startActivity(intent);
        } else if (id == R.id.btn_start_plugin_apk_appcompat_activity) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginAppCompatActivity"));
            startActivity(intent);
        } else if (id == R.id.btn_load_img) {
            Drawable drawable = PluginResourceUtil.getPluginDrawableByName(this, "pluginapk-debug.apk", "com.malin.plugin", "plugin_img");
            mImageView.setImageDrawable(drawable);
        }
    }
}
