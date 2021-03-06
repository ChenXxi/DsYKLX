package com.example.addshopping.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import com.example.addshopping.R;
import com.example.addshopping.adaper.ShoppAdaper;
import com.example.addshopping.api.Apis;
import com.example.addshopping.bean.ShoppCarBean;
import com.example.addshopping.presenter.PresenterImpl;
import com.example.addshopping.view.Iview;

import java.util.HashMap;
import java.util.Map;

public class ShoppCarActivity extends AppCompatActivity implements Iview {

    private PresenterImpl presenter;
    private RecyclerView recyclerView;
    private CheckBox query;
    private TextView text_total;
    private TextView text_shopp;
    private ShoppAdaper adaper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppcar);
        presenter = new PresenterImpl(this);
        initView();
    }

    private void initView() {
        //获取资源id
        recyclerView = findViewById(R.id.recycle_view);
        query = findViewById(R.id.query);
        text_total = findViewById(R.id.text_total);
        text_shopp = findViewById(R.id.text_shopp);
        //1为不选中
        query.setTag(1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        adaper = new ShoppAdaper(this);
        recyclerView.setAdapter(adaper);
        //调用适配器里的接口
        adaper.setUpdateListener(new ShoppAdaper.UpdateListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                //设置ui的改变
                text_shopp.setText("共"+num+"件商品");
                text_total.setText("总价:￥"+total+"元");
                if(allCheck){
                    query.setTag(2);
                }else{
                    query.setTag(1);
                }
                query.setChecked(allCheck);
            }
        });
        //这里只做ui更改, 点击全选按钮,,调到adapter里面操作
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用adapter里面的方法 ,,把当前quanxuan状态传递过去
                int tag = (int) query.getTag();
                if(tag == 1){
                    query.setTag(2);
                }else{
                    query.setTag(1);
                }
                adaper.queryAll(query.isChecked());
            }
        });
        //请求网址
        Map<String,String> map = new HashMap<>();
        map.put("uid","23013");
        presenter.startRequest(Apis.URL_CAR_COUNT,map,ShoppCarBean.class);
    }

    @Override
    public void requestData(Object o) {
        if(o instanceof ShoppCarBean){
            ShoppCarBean bean = (ShoppCarBean) o;
            if(bean==null || !bean.isSuccess()){
                Toast.makeText(ShoppCarActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                adaper.add(bean);
            }
        }
    }

    @Override
    public void requestFail(Object o) {
        if(o instanceof Exception){
            Exception e = (Exception) o;
            e.printStackTrace();
        }
        Toast.makeText(ShoppCarActivity.this,"网络请求错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
