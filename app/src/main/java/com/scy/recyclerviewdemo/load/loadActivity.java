package com.scy.recyclerviewdemo.load;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.scy.recyclerviewdemo.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class loadActivity extends AppCompatActivity {

    private LoadService mService;
    private LoadAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
    private int lastVisibleItem;
    private int total = 0;
    private int start = 0;
    private int count = 10;
    private boolean isFirst = true;
    private ProgressBar mProgressBar;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        initService();
        initView();
        initData(0, 10);
    }

    private void initService() {
        mService = new RetrofitClient().getService();
    }

    private void initView() {
        mAdapter = new LoadAdapter(this);
        RecyclerView rcvLoad = findViewById(R.id.rcv_load);
        mProgressBar = findViewById(R.id.progress_bar);
        rcvLoad.setLayoutManager(mLinearLayoutManager);
        rcvLoad.setHasFixedSize(true);
        rcvLoad.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rcvLoad.setAdapter(mAdapter);
        rcvLoad.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override

            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                // 判断 RecyclerView 的状态是空闲时，同时是最后一个可见的 item 时才加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                        lastVisibleItem + 1 == mAdapter.getItemCount()) {
                    total = total - count;
                    if (total > count) {
                        count = 10;
                        start = 10;
                        initData(start, count);
                    } else if (total < count && total > 0) {
                        count = total;
                        start = 20;
                        initData(start, count);
                    } else if (total == 0) {
                        count = total;

                        Toast.makeText(loadActivity.this, "已经没有数据了", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 最后一个可见的 item
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    private void initData(int start, int count) {
        Observable<LoadDataBean> observable = mService.getLoadData(
                "0b2bdeda43b5688921839c8ecb20399b",
                "%E5%8C%97%E4%BA%AC",
                start,
                count,
                "",
                ""
        );

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoadDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNext(LoadDataBean loadDataBean) {
                        if (isFirst) {
                            total = loadDataBean.getTotal();
                            mAdapter.setLoadDataList(loadDataBean.getSubjects());
                            isFirst = false;
                        } else {
                            mAdapter.addItem(loadDataBean.getSubjects());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mProgressBar.setVisibility(View.GONE);
                    }
                });

    }
}
