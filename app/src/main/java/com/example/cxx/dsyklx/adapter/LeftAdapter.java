package com.example.cxx.dsyklx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.cxx.dsyklx.R;
import com.example.cxx.dsyklx.entity.BeanFrag;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {

    private List<BeanFrag.Cls> list;
    private Context context;

    public LeftAdapter(List<BeanFrag.Cls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left,viewGroup,false);

        LeftViewHolder leftViewHolder = new LeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder leftViewHolder, final int pos) {

        final BeanFrag.Cls cls = list.get(pos);
        leftViewHolder.nameTv.setText(cls.name);

        leftViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener!=null){
                    itemClickListener.click(cls.cid);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class LeftViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
        }
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void click(String cid);
    }
}
