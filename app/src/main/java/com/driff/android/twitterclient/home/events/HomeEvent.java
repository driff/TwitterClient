package com.driff.android.twitterclient.home.events;

import com.driff.android.twitterclient.entities.MyTweet;

import java.util.List;

/**
 * Created by johnj on 22/6/2016.
 */
public class HomeEvent {

    private String error;
    private List<MyTweet> items;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<MyTweet> getItems() {
        return items;
    }

    public void setItems(List<MyTweet> items) {
        this.items = items;
    }

}
