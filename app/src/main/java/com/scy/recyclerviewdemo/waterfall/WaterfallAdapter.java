package com.scy.recyclerviewdemo.waterfall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.scy.recyclerviewdemo.R;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/30 11:28
 */
public class WaterfallAdapter extends RecyclerView.Adapter<WaterfallAdapter.WaterfallViewHolder> {
    private static final String TAG = WaterfallAdapter.class.getSimpleName();
    private Context mContext;
    private List<WaterfallBean.ResultsBean> mList;

    public WaterfallAdapter(Context context) {
        mContext = context;
    }

    public void setWaterfallData(List<WaterfallBean.ResultsBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WaterfallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.waterfall_recycle_item, parent, false);
        return new WaterfallViewHolder(view);
    }



    @Override

    public void onBindViewHolder(@NonNull WaterfallViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getUrl()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class WaterfallViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;

        public WaterfallViewHolder(View itemView) {

            super(itemView);

            ivImage = itemView.findViewById(R.id.iv_image);

        }

    }

}