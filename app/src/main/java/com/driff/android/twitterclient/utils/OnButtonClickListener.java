package com.driff.android.twitterclient.utils;

/**
 * Created by johnj on 6/7/2016
 * interface for buttons action related to them (for ex. changing btn icon color or disabling them)
 */
public interface OnButtonClickListener<T> {
    void onButtonClick(T t);
}
