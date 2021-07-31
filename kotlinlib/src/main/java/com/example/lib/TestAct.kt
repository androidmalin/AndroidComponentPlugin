package com.example.lib

import android.app.Activity
import android.view.View
import android.widget.Button

class TestAct : Activity() {
    private val mRootView: Button by bindView(R.layout.activity_main)

    // private Lazy<View> bindView(final Activity activity, @IdRes final int res) {
    //        return LazyKt.lazy(() -> activity.findViewById(res));
    //    }
    private fun <T : View> Activity.bindView(res: Int): Lazy<T> {
        return lazy { findViewById(res) }
    }
}