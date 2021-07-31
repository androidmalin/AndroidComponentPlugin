package com.example.lib;

import android.app.Activity;
import android.view.View;



import kotlin.Lazy;
import kotlin.LazyKt;

public class TestAct_ extends Activity {

    private final Lazy<View> delegate = this.bindView(this, R.layout.activity_main);

    private View getMBtnStartHostRegisterAct() {
        return (View) this.delegate.getValue();
    }

    private Lazy<View> bindView(final Activity activity,final int res) {
        return LazyKt.lazy(activity.findViewById(res));
    }
}
