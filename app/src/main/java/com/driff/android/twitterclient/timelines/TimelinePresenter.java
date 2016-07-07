package com.driff.android.twitterclient.timelines;

import com.driff.android.twitterclient.timelines.events.TimelineEvent;

/**
 * Created by johnj on 22/6/2016.
 */
public interface TimelinePresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getTimelineTweets();
    void onEventMainThread(TimelineEvent event);
}
