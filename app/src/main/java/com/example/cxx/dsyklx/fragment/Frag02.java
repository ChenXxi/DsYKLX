package com.example.cxx.dsyklx.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cxx.dsyklx.R;
import com.example.cxx.dsyklx.adapter.LeftAdapter;
import com.example.cxx.dsyklx.adapter.RightAdapter;
import com.example.cxx.dsyklx.contract.UserContract;
import com.example.cxx.dsyklx.entity.BeanChild;
import com.example.cxx.dsyklx.entity.BeanFrag;
import com.example.cxx.dsyklx.entity.UserEntity;
import com.example.cxx.dsyklx.persenter.UserPersenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag02 extends Fragment implements UserContract.IView,LeftAdapter.ItemClickListener {

    @BindView(R.id.left_rv)
    RecyclerView leftRv;
    @BindView(R.id.right_rv)
    RecyclerView rightRv;
    private UserPersenter userPersenter;
    private LeftAdapter leftAdapter;
    private String cid = "1";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_frag02, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        leftRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        userPersenter = new UserPersenter(this);

        getLeft();
        userPersenter.getLeftList(new HashMap<String, String>());
    }

    private void getLeft() {
        HashMap<String,String> p2 = new HashMap<>();
        p2.put("cid",cid);
        userPersenter.getRightList(p2);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void click(String cid) {
        getLeft();
    }

    @Override
    public void success(UserEntity.DataBean dataBean) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void leftSucess(List<BeanFrag.Cls> leftClsBeanList) {
        if (leftAdapter==null){
            leftAdapter = new LeftAdapter(leftClsBeanList,getActivity());
            leftRv.setAdapter(leftAdapter);
            leftAdapter.setItemClickListener(this);
            leftAdapter.setItemClickListener(new LeftAdapter.ItemClickListener() {
                @Override
                public void click(String cid22) {
                    cid = null;
                    cid = cid22;
                    getLeft();
                }
            });
        }else{
            leftAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void rightSucess(List<BeanChild.Cls> rightClsBeanList) {
        rightRv.setAdapter(new RightAdapter(rightClsBeanList,getActivity()));
    }

    @Override
    public void leftFailure(String error) {

    }

    @Override
    public void rightFailure(String error) {

    }
}
