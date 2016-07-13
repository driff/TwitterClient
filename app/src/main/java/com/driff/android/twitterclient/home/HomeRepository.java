package com.driff.android.twitterclient.home;


import com.driff.android.twitterclient.entities.MyTweet;

/**
 * Created by johnj on 22/6/2016.
 */
public interface HomeRepository {
    void getHomeTimeline();

    void setFavorite(boolean isFav, MyTweet myTweet);

    void setRetweet(boolean isRT, MyTweet myTweet);
}