package com.example.cxx.dsyklx.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cxx.dsyklx.R;
import com.example.cxx.dsyklx.adapter.xrvAdapter;
import com.example.cxx.dsyklx.contract.UserContract;
import com.example.cxx.dsyklx.entity.BeanChild;
import com.example.cxx.dsyklx.entity.BeanFrag;
import com.example.cxx.dsyklx.entity.UserEntity;
import com.example.cxx.dsyklx.persenter.UserPersenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.xw.repo.XEditText;

import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag01 extends Fragment implements UserContract.IView {


    private XRecyclerView xrv;
    private XEditText ed_serach;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_frag01,null);
        xrv = view.findViewById(R.id.xrv);
        ed_serach = view.findViewById(R.id.ed_search);
        UserPersenter persenter = new UserPersenter(this);
        persenter.getUser(new HashMap<String, String>());

        return view;
    }

    @Override
    public void success(UserEntity.DataBean dataBean) {
        xrvAdapter adapter=new xrvAdapter(getActivity(),dataBean);
        xrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrv.setAdapter(adapter);
    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void leftSucess(List<BeanFrag.Cls> leftClsBeanList) {

    }

    @Override
    public void rightSucess(List<BeanChild.Cls> rightClsBeanList) {

    }

    @Override
    public void leftFailure(String error) {

    }

    @Override
    public void rightFailure(String error) {

    }
}
