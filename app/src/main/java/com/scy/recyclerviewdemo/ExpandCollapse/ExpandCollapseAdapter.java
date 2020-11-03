package com.scy.recyclerviewdemo.ExpandCollapse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
public class ExpandCollapseAdapter extends RecyclerView.Adapter<ExpandCollapseAdapter.RcvClickViewHolder> {
    private Context mContext;
    private List<String> list = new ArrayList<>();
    private int e = -1;
    private RcvClickViewHolder mViewHolder;

    public ExpandCollapseAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRcvDragDataList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RcvClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rcv_expand_collapse_item, parent, false);
        return new RcvClickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RcvClickViewHolder holder, int position) {
        final String content = list.get(position);
        holder.tvTeam.setText(content);
        holder.tvTeamChild.setText(content + "的子内容");
        final boolean isExpand = position == e;
        holder.rlChild.setVisibility(isExpand ? View.VISIBLE : View.GONE);
        holder.rlParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mViewHolder != null) {
                    mViewHolder.rlChild.setVisibility(View.GONE);
                    notifyItemChanged(e);
                }
                e = isExpand ? -1 : holder.getAdapterPosition();
                mViewHolder = isExpand ? null : holder;
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RcvClickViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_team)
        TextView tvTeam;
        @BindView(R.id.rl_parent)
        RelativeLayout rlParent;
        @BindView(R.id.tv_team_child)
        TextView tvTeamChild;
        @BindView(R.id.rl_child)
        RelativeLayout rlChild;

        public RcvClickViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
