package com.driff.android.twitterclient.tweetit;

import com.driff.android.twitterclient.events.SingleTweetEvent;

/**
 * Created by johnj on 12/7/2016.
 */
public interface TweetitPresenter {

    void onResume();

    void onPause();

    void onDestroy();

    void getRtTweet();

    void onEventMainThread(SingleTweetEvent event);

}
