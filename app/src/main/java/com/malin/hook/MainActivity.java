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
        findViewById(R.id.btn_start_inner).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_start) {
            startActivity(1, false);
        } else if (id == R.id.btn_start_appcompat) {
            startActivity(2, false);
        } else if (id == R.id.btn_start_plugin_apk_activity) {
            startActivity(3, false);
        } else if (id == R.id.btn_start_plugin_apk_appcompat_activity) {
            startActivity(4, false);
        } else if (id == R.id.btn_load_img) {
            Drawable drawable = PluginResourceUtil.getPluginDrawableByName(this, "pluginapk-debug.apk", "com.malin.plugin", "plugin_img");
            mImageView.setImageDrawable(drawable);
        } else if (id == R.id.btn_start_inner) {
            startActivity(5, false);
        }
    }


    private void startActivity(int type, boolean context) {
        if (type < 1 || type > 5) {
            return;
        }
        Intent intent = null;
        switch (type) {
            case 1: {
                intent = new Intent(this, TargetActivity.class);
                break;
            }
            case 2: {
                intent = new Intent(this, TargetAppCompatActivity.class);
                break;
            }
            case 3: {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginActivity"));
                break;
            }
            case 4: {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.malin.plugin", "com.malin.plugin.PluginAppCompatActivity"));
                break;
            }
            case 5: {
                intent = new Intent(this, SecondActivity.class);
                break;
            }
        }
        if (context) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(intent);
        } else {
            startActivity(intent);
        }
    }

}
