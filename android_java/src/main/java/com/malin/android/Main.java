package com.malin.android;

import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void main() {
        ActivityThread thread = new ActivityThread();
        thread.attach();

        Activity activity = thread.performLaunchActivity();
        activity.attach(thread.getApplication());

        //activity.getApplicationContext().startActivity(new Intent());
        activity.startActivity(new Intent());
    }
}
