package com.driff.android.twitterclient.api;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by johnj on 17/6/2016.
 */
public interface TimelineService {

    @GET("/1.1/statuses/home_timeline.json")
    void homeTimeline(@Query("count")Integer count,
                      @Query("trim_user")Boolean trim_user,
                      @Query("exclude_replies")Boolean exclude_replies,
                      @Query("contributor_details")Boolean contributor_details,
                      @Query("include_entities")Boolean include_entities,
                      Callback<List<Tweet>> callback);

    @POST("/1.1/statuses/update.json")
    void updateStatus(@Query("status") String status, Callback<Tweet> callback);

    @POST("/1.1/favorites/create.json")
    void createFavorite(@Query("id") String id, Callback<Tweet> callback);

    @POST("/1.1/favorites/destroy.json")
    void destroyFavorite(@Query("id") String id, Callback<Tweet> callback);

    @POST("/1.1/statuses/retweet/{id}.json")
    void doRetweet(@Path("id") String id, Callback<Tweet> callback);

    @POST("/1.1/statuses/unretweet/{id}.json")
    void undoRetweet(@Path("id") String id, Callback<Tweet> callback);

}
