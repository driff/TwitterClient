package com.driff.android.twitterclient.images.ui;

import com.driff.android.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by johnj on 18/6/2016.
 */
public interface ImagesView {

    void showImages();
    void hideImages();
    void showProgressBar();
    void hideProgressBar();

    void onError(String error);
    void setContent(List<Image> items);

}
