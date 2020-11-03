package com.scy.recyclerviewdemo.drag;

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
public class RcvDragAdapter extends RecyclerView.Adapter<RcvDragAdapter.RcvClickViewHolder> implements ItemTouchHelperListener{

    private Context mContext;
    private List<String> list = new ArrayList<>();

    @Override
    public void onItemMove(int f, int t) {
        String p = list.remove(f);
        list.add(t > f ? t - 1 : t , p);
        notifyItemMoved(f,t);
    }

    public RcvDragAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRcvDragDataList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RcvClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rcv_drag_item, parent, false);
        return new RcvClickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RcvClickViewHolder holder, int position) {
        final String content = list.get(position);
        holder.tvContent.setText(content);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RcvClickViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_content)
        TextView tvContent;

        public RcvClickViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
