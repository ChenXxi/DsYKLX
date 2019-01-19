package com.example.cxx.dsyklx.persenter;

import com.example.cxx.dsyklx.contract.UserContract;
import com.example.cxx.dsyklx.entity.BeanChild;
import com.example.cxx.dsyklx.entity.BeanFrag;
import com.example.cxx.dsyklx.entity.UserEntity;
import com.example.cxx.dsyklx.model.UserModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class UserPersenter extends UserContract.IPresenter {
    UserModel userModel;
    UserContract.IView iView;

    public UserPersenter(UserContract.IView iView) {
        userModel = new UserModel();
        this.iView = iView;
    }

    @Override
    public void getUser(HashMap<String, String> params) {
        userModel.getUser(params, new UserModel.ModelCallback() {
            @Override
            public void success(String result) {
                UserEntity userEntity = new Gson().fromJson(result,UserEntity.class);
                UserEntity.DataBean data = userEntity.getData();
                iView.success(data);
            }

            @Override
            public void failure(String msg) {

            }

            @Override
            public void leftSuccess(String result) {

            }

            @Override
            public void rightSUccess(String result) {

            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });
    }

    @Override
    public void getLeftList(HashMap<String, String> params) {
        userModel.getLeftList(params, new UserModel.ModelCallback() {
            @Override
            public void success(String result) {

            }

            @Override
            public void failure(String msg) {

            }

            @Override
            public void leftSuccess(String result) {
                BeanFrag leftClsBean = new Gson().fromJson(result,BeanFrag.class);
                List<BeanFrag.Cls> data = leftClsBean.data;
                iView.leftSucess(data);
            }

            @Override
            public void rightSUccess(String result) {

            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });
    }

    @Override
    public void getRightList(HashMap<String, String> params) {
        userModel.getRightList(params, new UserModel.ModelCallback() {
            @Override
            public void success(String result) {

            }

            @Override
            public void failure(String msg) {

            }

            @Override
            public void leftSuccess(String result) {

            }

            @Override
            public void rightSUccess(String result) {
                BeanChild rightClsBean = new Gson().fromJson(result,BeanChild.class);
                List<BeanChild.Cls> data = rightClsBean.data;
                iView.rightSucess(data);
            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });
    }
}
