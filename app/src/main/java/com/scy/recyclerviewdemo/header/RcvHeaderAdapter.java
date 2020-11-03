package com.scy.recyclerviewdemo.header;

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
public class RcvHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> list = new ArrayList<>();
    public static final int content = 0;
    public static final int header = 1;
    private int headerCount = 1;

    public RcvHeaderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRcvClickDataList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == header) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rcy_footer_item, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == content){
            View view = LayoutInflater.from(mContext).inflate(R.layout.rcy_footer_item, parent, false);
            return new RcvClickViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof RcvClickViewHolder){
            final String content = list.get(position);
            ((RcvClickViewHolder) holder).tvNum.setText(position + 1 + " ");
            ((RcvClickViewHolder) holder).tvContent.setText(content);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (headerCount != 0 && position < headerCount) {
            return header;
        } else {
            return content;
        }
    }

    @Override
    public int getItemCount() {
        return headerCount+getContentItemCount();
    }

    public class RcvClickViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.tv_content)
        TextView tvContent;
        public RcvClickViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public int getContentItemCount() {
        return list.size();
    }

    public boolean isFooterView(int position) {
        return headerCount != 0 && position < headerCount;
    }

}
