package com.driff.android.twitterclient.timelines.ui;


import com.driff.android.twitterclient.entities.MyTweet;

import java.util.List;

/**
 * Created by johnj on 22/6/2016.
 */
public interface TimelineView {

    void showTimeline();
    void hideTimeline();
    void showProgressBar();
    void hideProgressBar();

    void onError(String error);
    void setContent(List<MyTweet> items);

}
