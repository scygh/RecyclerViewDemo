package com.scy.recyclerviewdemo.waterfall;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/30 11:27
 */
public interface WaterfallService {
    @GET("{type}/{count}/{page}")
    Observable<WaterfallBean> getWaterfallData(@Path("type") String type,
                                               @Path("count") int count,
                                               @Path("page") int page);
}
