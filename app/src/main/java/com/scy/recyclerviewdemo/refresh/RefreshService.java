package com.scy.recyclerviewdemo.refresh;

import com.scy.recyclerviewdemo.load.LoadDataBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/29 16:16
 */
public interface RefreshService {
    @GET("/v2/movie/in_theaters")

    Observable<RefreshDataBean> getRefreshData(@Query("apikey") String apikey,

                                               @Query("city") String city,

                                               @Query("start") int start,

                                               @Query("count") int count,

                                               @Query("client") String client,

                                               @Query("udid") String udid);
}
