package com.example.myapplication.activity.broadcast1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.constant.Constant;

public class BroadCast1 extends AppCompatActivity implements View.OnClickListener {

    public static void goTo(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BroadCast1.class);
        context.startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast1);
        findViewById(R.id.ac_broadcast_btn_sendQuiery).setOnClickListener(this);
        findViewById(R.id.ac_broadcast_btn_sendDynamic).setOnClickListener(this);

        // 注册一个动态广播
        ReceiveBroadCast1 broadCast1 = new ReceiveBroadCast1();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.BROADCAST_DYNAMIC);
        registerReceiver(broadCast1, intentFilter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // todo 静态广播大部分已经不能用了，因此需要使用动态广播。如果想使用静态广播，需要查资料
            case R.id.ac_broadcast_btn_sendQuiery: {
                Intent intent = new Intent();
                intent.setAction(Constant.BROADCAST_QUIET);
                Log.e("sendBroadcast", "Static type");
                sendBroadcast(intent);
                break;
            }
            case R.id.ac_broadcast_btn_sendDynamic: {
                Intent intent = new Intent();
                intent.setAction(Constant.BROADCAST_DYNAMIC);
                Log.e("sendBroadcast", "Dynamic type");
                sendBroadcast(intent);
                break;
            }
        }
    }
}