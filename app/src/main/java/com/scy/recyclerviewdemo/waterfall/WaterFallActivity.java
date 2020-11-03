package com.scy.recyclerviewdemo.waterfall;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.scy.recyclerviewdemo.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WaterFallActivity extends AppCompatActivity {

    private WaterfallService mService;
    private WaterfallAdapter mAdapter;
    private RecyclerView mRcvWaterfall;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall);
        initWaterfallService();
        initView();
        initWaterfallData();
    }

    private void initWaterfallService() {
        mService = new RetrofitClient().getWaterfallService();
    }

    private void initView() {
        mAdapter = new WaterfallAdapter(this);
        mRcvWaterfall = findViewById(R.id.rcv_waterfall);
        mProgressBar = findViewById(R.id.progress_bar);
        mRcvWaterfall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRcvWaterfall.setHasFixedSize(true);
        mRcvWaterfall.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
        mRcvWaterfall.setItemAnimator(new DefaultItemAnimator());
        mRcvWaterfall.setAdapter(mAdapter);
    }


    private void initWaterfallData() {
        Observable<WaterfallBean> observable = mService.getWaterfallData(
                "福利",
                10,
                1
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WaterfallBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mProgressBar.setVisibility(View.VISIBLE);
                        mRcvWaterfall.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(WaterfallBean waterfallBean) {
                        mAdapter.setWaterfallData(waterfallBean.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        mProgressBar.setVisibility(View.GONE);
                        mRcvWaterfall.setVisibility(View.VISIBLE);
                    }
                });
    }
}
