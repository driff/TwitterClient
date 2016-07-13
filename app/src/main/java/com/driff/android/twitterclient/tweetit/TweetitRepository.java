package com.driff.android.twitterclient.tweetit;

import com.driff.android.twitterclient.entities.MyTweet;

/**
 * Created by johnj on 12/7/2016.
 */
public interface TweetitRepository {

    void getRtTweet();

    boolean createTweet(MyTweet tweet);

}
