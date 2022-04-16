package com.example.myapplication.activity.service1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.ac_ser_bt_start).setOnClickListener(this);
        findViewById(R.id.ac_ser_bt_stop).setOnClickListener(this);
        findViewById(R.id.ac_ser_bt_bindStart).setOnClickListener(this);
        findViewById(R.id.ac_ser_bt_bindStop).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ttt", "1111");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_ser_bt_start: {
                Intent intent = new Intent(this, Service.class);
                startService(intent);
                break;
            }
            case R.id.ac_ser_bt_stop: {
                Intent intent = new Intent(this, Service.class);
                stopService(intent);
                break;
            }
            case R.id.ac_ser_bt_bindStart: {
                Intent intent = new Intent(this, Service.class);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                break;
            }
            case R.id.ac_ser_bt_bindStop:{
                unbindService(connection);
                break;
            }
        }
    }

    // 一般写法，在Activity被销毁时，自动解绑服务
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    // MainActivity与MyService桥梁
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


}
