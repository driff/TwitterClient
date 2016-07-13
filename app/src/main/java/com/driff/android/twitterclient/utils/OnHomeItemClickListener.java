package com.driff.android.twitterclient.utils;

/**
 * Created by johnj on 18/6/2016.
 */
public interface OnHomeItemClickListener<T> {
    void onItemClick(T t);

    void onRetweetClick(T t);

    void onShareClick(T t);

    void onFavoriteClick(T t);
}
