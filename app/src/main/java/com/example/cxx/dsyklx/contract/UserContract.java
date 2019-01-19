package com.example.cxx.dsyklx.contract;

import com.example.cxx.dsyklx.entity.BeanChild;
import com.example.cxx.dsyklx.entity.BeanFrag;
import com.example.cxx.dsyklx.entity.UserEntity;
import com.example.cxx.dsyklx.model.UserModel;

import java.util.HashMap;
import java.util.List;

public interface UserContract {
    abstract class IPresenter{
        protected abstract void getUser(HashMap<String,String> params);
        public abstract void getLeftList(HashMap<String,String> params);
        public abstract void getRightList(HashMap<String,String> params);
    }
    interface IModel{
        void getUser(HashMap<String,String> params,UserModel.ModelCallback callback);
        void getLeftList(HashMap<String, String> params, UserModel.ModelCallback callback);
        void getRightList(HashMap<String, String> params, UserModel.ModelCallback callback);
    }
    interface IView{
        void success(UserEntity.DataBean dataBean);
        void failure(String msg);
        void leftSucess(List<BeanFrag.Cls> leftClsBeanList);
        void rightSucess(List<BeanChild.Cls> rightClsBeanList);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
