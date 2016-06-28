package com.driff.android.twitterclient.images.events;

import com.driff.android.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by johnj on 19/6/2016.
 */
public class ImagesEvent {

    private String error;
    private List<Image> items;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getItems() {
        return items;
    }

    public void setItems(List<Image> items) {
        this.items = items;
    }

}
