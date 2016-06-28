package com.driff.android.twitterclient.images;

import com.driff.android.twitterclient.images.events.ImagesEvent;

/**
 * Created by johnj on 18/6/2016.
 */
public interface ImagesPresenter {

    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);

}
