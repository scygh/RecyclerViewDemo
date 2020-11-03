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
 * date : 2020/10/30 09:40
 */
public class SlideVerticalAdapter extends RecyclerView.Adapter<SlideVerticalAdapter.SlideVerticalViewHolder> {

    private static final String TAG = SlideVerticalAdapter.class.getSimpleName();
    private Context mContext;
    private List<String> mList = new ArrayList<>();
    public SlideVerticalAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;

    }

    @NonNull
    @Override
    public SlideVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.slide_vertical_include_item, parent, false);
        return new SlideVerticalViewHolder(view);

    }

    @Override

    public void onBindViewHolder(@NonNull SlideVerticalViewHolder holder, int position) {
        holder.tvText.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class SlideVerticalViewHolder extends RecyclerView.ViewHolder {

        TextView tvText;
        public SlideVerticalViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_slide_vertical_text);
        }
    }
}

