package com.scy.recyclerviewdemo.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scy.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/30 10:14
 */
public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.SwipeViewHolder> implements ItemTouchHelperListener {

    private static final String TAG = SwipeAdapter.class.getSimpleName();
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public SwipeAdapter(Context context) {
        mContext = context;
    }


    public void setSwipeDataList(List<String> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SwipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.swipe_recycle_item, parent, false);
        return new SwipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SwipeViewHolder holder, int position) {
        holder.tvContent.setText(mList.get(position));
    }


    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onItemDismiss(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }
        mList.remove(position);
        notifyItemRemoved(position);
        // 解决 RecyclerView 删除 Item 导致位置错乱的问题
        if (position != mList.size()) {
            notifyItemRangeChanged(position, mList.size() - position);
        }
    }

    public class SwipeViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        public SwipeViewHolder(View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
        }

    }

}
