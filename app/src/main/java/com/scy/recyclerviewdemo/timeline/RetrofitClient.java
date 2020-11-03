package com.scy.recyclerviewdemo.timeline;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/30 10:38
 */
public class RetrofitClient {
    public TimeLineService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.kuaidi100.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(TimeLineService.class);

    }
}
