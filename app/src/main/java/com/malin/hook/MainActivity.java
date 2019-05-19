package com.malin.hook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.core.os.BuildCompat;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_start_appcompat).setOnClickListener(this);
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
