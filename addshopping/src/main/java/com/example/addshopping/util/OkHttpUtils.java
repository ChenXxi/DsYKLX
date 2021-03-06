package com.example.addshopping.util;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private static OkHttpUtils intance;
    private final OkHttpClient httpClient;
    private Handler handler = new Handler(Looper.myLooper());
    public OkHttpUtils() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)//添加日志拦截器
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();//链式调用，构建者模式
    }

    public static OkHttpUtils getIntance() {
        if(intance == null){
            synchronized (OkHttpUtils.class){
                intance = new OkHttpUtils();
            }
        }
        return intance;
    }
    /**
     * 异步get请求
     * */
    public void doGet(String url, String params, final Class clazz, final ICallBack iCallBack){
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
               handler.post(new Runnable() {
                   @Override
                   public void run() {
                       iCallBack.faniled(e);
                   }
               });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String result = response.body().string();
                    Gson gson = new Gson();
                    final Object o = gson.fromJson(result, clazz);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iCallBack.success(o);
                        }
                    });
                }catch (Exception e){
                    iCallBack.faniled(e);
                }
            }
        });
    }
    /**
     * 异步post请求
     * */
    public void doPost(String url, Map<String,String> map, final Class clazz, final ICallBack iCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> entry:map.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.faniled(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String result = response.body().string();
                        Gson gson = new Gson();
                        final Object o = gson.fromJson(result, clazz);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.success(o);
                            }
                        });
                    }catch (Exception e){
                        iCallBack.faniled(e);
                    }
            }
        });
    }
}
