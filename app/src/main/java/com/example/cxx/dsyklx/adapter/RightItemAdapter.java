package com.example.cxx.dsyklx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cxx.dsyklx.R;
import com.example.cxx.dsyklx.entity.BeanChild;


import java.util.List;

public class RightItemAdapter extends RecyclerView.Adapter<RightItemAdapter.RightViewHolder> {

    private List<BeanChild.Cls.Pcls> list;
    private Context context;

    public RightItemAdapter(List<BeanChild.Cls.Pcls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_subitem_layout,viewGroup,false);

        RightViewHolder leftViewHolder = new RightViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder rightViewHolder, int pos) {

        BeanChild.Cls.Pcls bean = list.get(pos);


        rightViewHolder.nameTv.setText(bean.name);

        Glide.with(context).load(bean.icon).into(rightViewHolder.iv);




    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        private ImageView iv;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
