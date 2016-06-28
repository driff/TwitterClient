package com.driff.android.twitterclient.hashtags.events;

import com.driff.android.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by johnj on 19/6/2016.
 */
public class HashtagsEvent {

    private String error;
    private List<Hashtag> items;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getItems() {
        return items;
    }

    public void setItems(List<Hashtag> items) {
        this.items = items;
    }

}
