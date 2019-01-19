package com.example.cxx.dsyklx.model;

import android.os.Handler;

import com.example.cxx.dsyklx.api.UserApi;
import com.example.cxx.dsyklx.contract.UserContract;
import com.example.cxx.dsyklx.utils.OkhttpCallback;
import com.example.cxx.dsyklx.utils.OkhttpUtils;

import java.util.HashMap;

public class UserModel implements UserContract.IModel {
    Handler handler = new Handler();
    @Override
    public void getUser(HashMap<String, String> params, final ModelCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.MYONE_API, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.failure("网络异常");
                    }
                });
            }

            @Override
            public void success(final String result) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(result);
                    }
                });
            }
        });
    }

    @Override
    public void getLeftList(HashMap<String, String> params, final ModelCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.Left_url, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                if (callback!=null)
                    callback.leftFailure(msg);
            }

            @Override
            public void success(String result) {
                if (callback!=null)
                    callback.leftSuccess(result);
            }
        });
    }

    @Override
    public void getRightList(HashMap<String, String> params, final ModelCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.Rigth_url, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                if (callback!=null)
                    callback.rightFailure(msg);
            }

            @Override
            public void success(String result) {
                if (callback!=null)
                    callback.rightSUccess(result);
            }
        });
    }

    public interface ModelCallback {
        void success(String result);
        void failure(String msg);
        void leftSuccess(String result);
        void rightSUccess(String result);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
