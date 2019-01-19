package com.example.cxx.dsyklx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cxx.dsyklx.R;
import com.example.cxx.dsyklx.entity.UserEntity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class xrvAdapter extends XRecyclerView.Adapter<xrvAdapter.ViewHolder> {
    private Context context;
    private UserEntity.DataBean list;
    public xrvAdapter(Context context, UserEntity.DataBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public xrvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_fu, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final xrvAdapter.ViewHolder viewHolder, int i) {
        final List<UserEntity.DataBean.BannerBean> banner1 = list.getBanner();
        ArrayList<String> images=new ArrayList<>();
        for (int a=0;a<banner1.size();a++){
            images.add(banner1.get(a).getIcon());
        }
        viewHolder.xbanner.setIsClipChildrenMode(true);
        viewHolder.xbanner.setData(banner1,null);
        viewHolder.xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(context).load(banner1.get(position).getIcon()).into((ImageView) view);
            }
        });
        viewHolder.xbanner.setPageTransformer(com.stx.xhb.xbanner.transformers.Transformer.Default);
        GridLayoutManager manager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        manager.setOrientation(OrientationHelper.HORIZONTAL);
        viewHolder.rv_jiu.setLayoutManager(manager);
        jiuAdapter adapter1=new jiuAdapter(context,list);
        viewHolder.rv_jiu.setAdapter(adapter1);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        viewHolder.rv_list.setLayoutManager(linearLayoutManager);
        listAdapter adapter2=new listAdapter(context,list);
        viewHolder.rv_list.setAdapter(adapter2);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView rv_jiu;
        private final RecyclerView rv_list;
        private final XBanner xbanner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            xbanner = itemView.findViewById(R.id.xbanner);
            rv_jiu = itemView.findViewById(R.id.rv_jiu);
            rv_list = itemView.findViewById(R.id.rv_list);
        }
    }
}
