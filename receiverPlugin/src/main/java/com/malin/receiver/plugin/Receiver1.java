package com.malin.receiver.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver1 extends BroadcastReceiver {
    private static final String ACTION = "com.malin.receiver.plugin.receiver1.SEND_ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Receiver1#onReceive I am receiver 1");
        Toast.makeText(context, "我是插件, 主程序收到请回答!", Toast.LENGTH_SHORT).show();
        context.sendBroadcast(new Intent(ACTION));
    }
}