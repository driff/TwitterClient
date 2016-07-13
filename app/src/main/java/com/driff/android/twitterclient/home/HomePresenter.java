package com.driff.android.twitterclient.home;

import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.home.events.HomeEvent;

/**
 * Created by johnj on 22/6/2016.
 */
public interface HomePresenter {
    void onResume();

    void onPause();

    void onDestroy();

    void getHomeTweets();

    void setFavorite(boolean isFav, MyTweet myTweet);

    void setRetweet(boolean isRT, MyTweet myTweet);

    void onEventMainThread(HomeEvent event);
}
