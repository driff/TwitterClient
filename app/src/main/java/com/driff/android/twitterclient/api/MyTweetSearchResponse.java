package com.driff.android.twitterclient.api;

import com.driff.android.twitterclient.entities.MyTweet;

import java.util.List;

/**
 * Created by johnj on 5/7/2016.
 */
public class MyTweetSearchResponse {

    private int count;
    private List<MyTweet> tweets;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MyTweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<MyTweet> tweets) {
        this.tweets = tweets;
    }

    public MyTweet getFirstTweet(){
        MyTweet first = null;
        if(!tweets.isEmpty()){
            first = tweets.get(0);
        }
        return first;
    }

}
