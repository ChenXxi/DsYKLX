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

public class jiuAdapter extends RecyclerView.Adapter<jiuAdapter.ViewHolder> {
    private Context context;
    private UserEntity.DataBean list;

    public jiuAdapter(Context context, UserEntity.DataBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_zi,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UserEntity.DataBean.FenleiBean fenleiBean = list.getFenlei().get(i);
        viewHolder.name.setText(fenleiBean.getName());
        Glide.with(context).load(fenleiBean.getIcon()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.getMiaosha().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
