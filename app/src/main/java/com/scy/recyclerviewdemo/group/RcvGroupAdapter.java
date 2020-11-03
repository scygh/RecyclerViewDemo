package com.scy.recyclerviewdemo.group;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/28 14:08
 */
public class RcvGroupAdapter extends RecyclerView.Adapter<RcvGroupAdapter.RcvClickViewHolder> {


    private Context mContext;
    private List<GroupDataBean> list = new ArrayList<>();

    public RcvGroupAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setGroupDataList(List<GroupDataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RcvClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rcv_group_item, parent, false);
        return new RcvClickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RcvClickViewHolder holder, int position) {
        holder.tvArea.setText(list.get(position).getArea());
        holder.tvTeam.setText(list.get(position).getTeam());
        if (position == 0) {
            holder.tvArea.setVisibility(View.VISIBLE);
        } else {
            if (list.get(position).getArea().equals(list.get(position-1).getArea())) {
                holder.tvArea.setVisibility(View.GONE);
            } else {
                holder.tvArea.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RcvClickViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_area)
        TextView tvArea;
        @BindView(R.id.tv_team)
        TextView tvTeam;
        public RcvClickViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
