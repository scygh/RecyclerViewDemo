package com.scy.recyclerviewdemo.footer;

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
public class RcvFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> list = new ArrayList<>();
    public static final int content = 0;
    public static final int footer = 1;
    private int footerCount = 1;

    public RcvFooterAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRcvClickDataList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == content) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rcy_footer_item, parent, false);
            return new RcvClickViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rcy_footer_item, parent, false);
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RcvClickViewHolder) {
            final String content = list.get(position);
            ((RcvClickViewHolder) holder).tvNum.setText(position + 1 + " ");
            ((RcvClickViewHolder) holder).tvContent.setText(content);
        } else if (holder instanceof FooterViewHolder){

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (footerCount != 0 && position >=(getContentItemCount())) {
            return footer;
        } else {
            return content;
        }
    }

    @Override
    public int getItemCount() {
        return getContentItemCount() + footerCount;
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

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public int getContentItemCount() {
        return list.size();
    }

    public boolean isFooterView(int position) {
        return footerCount != 0 && position >= (footerCount + getContentItemCount());
    }

}
