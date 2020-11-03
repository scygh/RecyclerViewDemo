package com.scy.recyclerviewdemo.load;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/29 16:16
 */
public class RetrofitClient {

    public LoadService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(LoadService.class);

    }
}
