package com.scy.recyclerviewdemo.timeline;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/30 10:39
 */
public interface TimeLineService {
    /**
     * https://www.kuaidi100.com/query?type=zhongtong&postid=482357364071
     */
    @GET("query")
    Observable<TimelineBean> getTimeline(@Query("type") String type,
                                         @Query("postid") String postid);
}
