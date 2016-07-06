package com.driff.android.twitterclient.images.ui;

import com.driff.android.twitterclient.entities.MyTweet;

import java.util.List;

/**
 * Created by johnj on 5/7/2016.
 */
public interface ImagesView {

    void showImages();
    void hideImages();
    void showProgressBar();
    void hideProgressBar();

    void onError(String error);
    void setContent(List<MyTweet> items);

}
