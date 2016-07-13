package com.driff.android.twitterclient.tweetit.ui;

import com.driff.android.twitterclient.entities.MyTweet;

/**
 * Created by johnj on 12/7/2016.
 */
public interface TweetitView {

    void hideView();

    void onError(String error);

    void setContent(MyTweet item);

}
