package com.malin.hook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 普通的桩Activity
 */
@SuppressLint("SetTextI18n")
public class StubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("StubActivity");
        setContentView(textView);
    }
}
