package com.driff.android.twitterclient.lib;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.driff.android.twitterclient.lib.base.ImageLoader;

/**
 * Created by johnj on 17/6/2016.
 */
public class GlideImageLoader implements ImageLoader {

    private RequestManager glideRequestManager;

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    @Override
    public void load(ImageView imgView, String URL) {
        glideRequestManager.load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop()
                .override(800, 500).into(imgView);
    }
}
