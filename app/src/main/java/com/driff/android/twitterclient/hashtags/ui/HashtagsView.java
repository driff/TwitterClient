package com.driff.android.twitterclient.hashtags.ui;

import com.driff.android.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by johnj on 19/6/2016.
 */
public interface HashtagsView {

    void showHashtags();
    void hideHashtags();
    void showProgressBar();
    void hideProgressBar();

    void onError(String error);
    void setContent(List<Hashtag> items);

}
