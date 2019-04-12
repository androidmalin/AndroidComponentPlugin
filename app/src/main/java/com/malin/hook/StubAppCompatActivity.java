package com.malin.hook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * AppCompatActivity类型的桩Activity
 */
@SuppressLint("SetTextI18n")
public class StubAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("StubActivity");
        setContentView(textView);
    }
}
