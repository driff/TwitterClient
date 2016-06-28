package com.driff.android.twitterclient.hashtags;

import com.driff.android.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by johnj on 19/6/2016.
 */
public interface HashtagsPresenter {

    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);

}
