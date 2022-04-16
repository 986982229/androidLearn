package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activity.broadcast1.BroadCast1;
import com.example.myapplication.activity.jump.DestinationActivity;
import com.example.myapplication.activity.okhttp.OkhttpActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.activity_main_bt);
        bt.setOnClickListener(this);
        findViewById(R.id.ac_main_bt2).setOnClickListener(this);
        findViewById(R.id.ac_main_bt_toBroadCastStatic).setOnClickListener(this);
        findViewById(R.id.ac_main_bt_toOkHttp).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.activity_main_bt: {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DestinationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.ac_main_bt2: { // 跳转到serviceActivity
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.myapplication.activity.service1.MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.ac_main_bt_toBroadCastStatic: { // 跳转到静态广播
                BroadCast1.goTo(MainActivity.this);
                break;
            }
            case R.id.ac_main_bt_toOkHttp: { // 跳转到okhttp
                OkhttpActivity.goTo(this);
                break;
            }
        }
    }
}