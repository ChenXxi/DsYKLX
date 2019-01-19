package com.example.cxx.dsyklx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.cxx.dsyklx.R;
import com.example.cxx.dsyklx.entity.BeanChild;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {

    private List<BeanChild.Cls> list;
    private Context context;

    public RightAdapter(List<BeanChild.Cls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_right,viewGroup,false);

        RightViewHolder leftViewHolder = new RightViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder rightViewHolder, int pos) {

        BeanChild.Cls bean = list.get(pos);

        List<BeanChild.Cls.Pcls> list = bean.list;

        rightViewHolder.nameTv.setText(bean.name);

        //设置子分类列表适配器
        rightViewHolder.rv.setLayoutManager(new GridLayoutManager(context,3));
        rightViewHolder.rv.setAdapter(new RightItemAdapter(list,context));




    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        private RecyclerView rv;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}
