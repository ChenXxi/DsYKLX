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
import com.example.cxx.dsyklx.entity.UserEntity;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {
    private Context context;
    private UserEntity.DataBean list;

    public listAdapter(Context context, UserEntity.DataBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.main_zi_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UserEntity.DataBean.TuijianBean.ListBeanX listBeanX = list.getTuijian().getList().get(i);
        viewHolder.price.setText("￥:"+listBeanX.getPrice());
        String[] imgs = listBeanX.getImages().split("\\|");
        if (imgs != null && imgs.length > 0){
            Glide.with(context).load(imgs[0]).into(viewHolder.image);
        }
    }

    @Override
    public int getItemCount() {
        return list.getTuijian().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.price);
        }
    }
}
