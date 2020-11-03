package com.scy.recyclerviewdemo.timeline;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.scy.recyclerviewdemo.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TimelineActivity extends AppCompatActivity {
    private TimeLineService mService;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private TimelineAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        initService();
        initView();
        initData();

    }



    private void initService() {

        mService = new RetrofitClient().getService();

    }



    private void initView() {
        mAdapter = new TimelineAdapter(this);
        mRecyclerView = findViewById(R.id.rcv_timeline);
        mProgressBar = findViewById(R.id.progress_bar);

        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }



    private void initData() {
        Observable<TimelineBean> observable = mService.getTimeline(
                "zhongtong", "482357364071"
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TimelineBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(TimelineBean timelineBean) {
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(TimelineActivity.this));
                        mRecyclerView.setHasFixedSize(true);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.setTimelineData(timelineBean.getData());
                    }



                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mProgressBar.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }

                });

    }
}
