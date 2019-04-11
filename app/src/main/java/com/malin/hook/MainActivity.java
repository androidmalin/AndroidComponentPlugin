package com.malin.hook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        if (v.getId() == R.id.btn_start) {
            MApplication.reset();
            startHook(false);
            startActivity(new Intent(this, TargetActivity.class));
        } else if (v.getId() == R.id.btn_start_appcompat) {
            MApplication.reset();
            startHook(true);
            startActivity(new Intent(this, TargetAppCompatActivity.class));
        }
    }

    private void startHook(boolean isAppCompatActivity) {
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
