package com.example.myapplication.activity.okhttp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// 测试api网站
// http://www.httpbin.org/

public class OkhttpActivity extends AppCompatActivity implements View.OnClickListener {

    private OkHttpClient client = new OkHttpClient();

    public static void goTo(Context context) {
        Intent intent = new Intent(context, OkhttpActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        findViewById(R.id.bt_get_sync).setOnClickListener(this);
        findViewById(R.id.bt_get_async).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_get_sync: { // 同步
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
//                        Request request = new Request.Builder()
//                                .get()
//                                .url("https://www.httpbin.org/get?a=1&b=2")
//                                .build();
//                        Call call = client.newCall(request);
//                        try {
//                            Response res = call.execute();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                        Request request = new Request.Builder().url("http://www.httpbin.org/get?a=1&b=2").build();
//                        Call call = client.newCall(request);
//                        try {
//                            call.execute();
//                            Response res = call.execute();
//                            Log.e("getSync", res.toString());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                        Call call = client.newCall(request);
                        call.enqueue(new Callback() {

                            // 请求失败
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.e("bb", e.toString());
                            }

                            // 请求结束
                            // 只意味着跟服务器通信成功, 但不一定只会返回 200, 也有可能 404
                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                // isSuccessful() { return code >= 200 && code < 300; }
                                if (response.isSuccessful()) {
                                    Log.e("ss", "getAsync:" + response.body().string());
                                }
                            }

                        });
                    }
                }.start();
                break;
            }
            case R.id.bt_get_async: {// 异步
                Request request = new Request.Builder().url("http://www.httpbin.org/get?a=1&b=2").build();
//                        Call call = client.newCall(request);
//                        try {
//                            call.execute();
//                            Response res = call.execute();
//                            Log.e("getSync", res.toString());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                Call call = client.newCall(request);
                call.enqueue(new Callback() {

                    // 请求失败
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("bb", e.toString());
                    }

                    // 请求结束
                    // 只意味着跟服务器通信成功, 但不一定只会返回 200, 也有可能 404
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        // isSuccessful() { return code >= 200 && code < 300; }
                        if (response.isSuccessful()) {
                            Log.e("ss", "getAsync:" + response.body().string());
                        }
                    }

                });
                break;
            }
        }
    }

    /**
     * get 同步请求
     */
    public void getSync() {
        Request request = new Request.Builder().url("https://www.httpbin.org/ip").build();
        Call call = client.newCall(request);
        try {
            Response res = call.execute();
            Log.e("getSync", res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}