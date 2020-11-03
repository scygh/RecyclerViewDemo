package com.scy.recyclerviewdemo.waterfall;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/30 11:24
 */
public class RetrofitClient {
    public WaterfallService getWaterfallService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(WaterfallService.class);

    }
}
