package com.driff.android.twitterclient.entities;

import java.util.List;

/**
 * Created by johnj on 19/6/2016.
 */
public class Hashtag extends Tweet{
    private List<String> hashtags;

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

}
