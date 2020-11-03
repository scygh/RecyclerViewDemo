package com.scy.recyclerviewdemo.slide;

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
 * date : 2020/10/30 09:37
 */
public class SlideHorizontalAdapter extends RecyclerView.Adapter<SlideHorizontalAdapter.SlideHorizontalViewHolder> {

    private static final String TAG = SlideHorizontalViewHolder.class.getSimpleName();
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public SlideHorizontalAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public SlideHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.slide_horizontal_include_item, parent, false);
        return new SlideHorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideHorizontalViewHolder holder, int position) {
        holder.tvText.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class SlideHorizontalViewHolder extends RecyclerView.ViewHolder {

        TextView tvText;
        public SlideHorizontalViewHolder(View itemView) {

            super(itemView);

            tvText = itemView.findViewById(R.id.tv_slide_horizontal_text);

        }

    }

}