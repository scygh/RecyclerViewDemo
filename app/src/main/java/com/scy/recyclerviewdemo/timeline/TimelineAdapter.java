package com.scy.recyclerviewdemo.timeline;

import android.content.Context;
import android.graphics.Color;
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
 * date : 2020/10/30 10:44
 */
public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    private static final String TAG = TimelineAdapter.class.getSimpleName();
    private Context mContext;
    private List<TimelineBean.DataBean> mList = new ArrayList<>();
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;

    public TimelineAdapter(Context context) {
        mContext = context;
    }

    public void setTimelineData(List<TimelineBean.DataBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TimelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.timeline_recycle_item, parent, false);
        return new TimelineViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TimelineViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            holder.tvHeaderLine.setVisibility(View.INVISIBLE);
            holder.tvTime.setTextColor(Color.BLACK);
            holder.tvContext.setTextColor(Color.BLACK);
            holder.tvDot.setBackgroundResource(R.drawable.timeline_dot_header);
        } else if (getItemViewType(position) == TYPE_NORMAL) {
            holder.tvHeaderLine.setVisibility(View.VISIBLE);
            holder.tvTime.setTextColor(Color.GRAY);
            holder.tvContext.setTextColor(Color.GRAY);
            holder.tvDot.setBackgroundResource(R.drawable.timeline_dot_normal);
        }

        holder.tvTime.setText(mList.get(position).getTime());
        holder.tvContext.setText(mList.get(position).getContext());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder {

        TextView tvTime, tvContext, tvHeaderLine, tvDot;

        public TimelineViewHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvContext = itemView.findViewById(R.id.tv_context);
            tvHeaderLine = itemView.findViewById(R.id.tv_header_line);
            tvDot = itemView.findViewById(R.id.tv_dot);
        }
    }

}