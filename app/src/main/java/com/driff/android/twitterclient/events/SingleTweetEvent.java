package com.driff.android.twitterclient.events;

import com.driff.android.twitterclient.entities.MyTweet;

/**
 * Created by johnj on 12/7/2016.
 */
public class SingleTweetEvent {

    private String error;
    private MyTweet item;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public MyTweet getItem() {
        return item;
    }

    public void setItems(MyTweet item) {
        this.item = item;
    }

}
