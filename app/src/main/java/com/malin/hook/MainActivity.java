package com.malin.hook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    //启动AppCompatActivity类型的Activity
    private boolean APPCOMPAT_ACTIVITY = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        initHook();
    }

    private void initHook() {
        try {
            if (APPCOMPAT_ACTIVITY) {
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
        }
    }


    private void initView() {
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_start) {
            if (APPCOMPAT_ACTIVITY) {
                startActivity(new Intent(this, TargetAppCompatActivity.class));
            } else {
                startActivity(new Intent(this, TargetActivity.class));
            }
        }
    }
}
