package com.example.myapplication.activity.broadcast1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveBroadCast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("ReceiveBroadCast1", "这是一个广播接受者");
        Toast.makeText(context, "广播", Toast.LENGTH_SHORT).show();
    }
}
