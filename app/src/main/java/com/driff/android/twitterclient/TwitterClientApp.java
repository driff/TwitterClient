package com.driff.android.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.crashlytics.android.Crashlytics;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.hashtags.di.DaggerHashtagsComponent;
import com.driff.android.twitterclient.hashtags.di.HashtagsComponent;
import com.driff.android.twitterclient.hashtags.di.HashtagsModule;
import com.driff.android.twitterclient.hashtags.ui.HashtagsView;
import com.driff.android.twitterclient.home.di.DaggerHomeComponent;
import com.driff.android.twitterclient.home.di.HomeComponent;
import com.driff.android.twitterclient.home.di.HomeModule;
import com.driff.android.twitterclient.home.ui.HomeView;
import com.driff.android.twitterclient.images.di.DaggerImagesComponent;
import com.driff.android.twitterclient.images.di.ImagesComponent;
import com.driff.android.twitterclient.images.di.ImagesModule;
import com.driff.android.twitterclient.images.ui.ImagesView;
import com.driff.android.twitterclient.lib.di.LibsModule;
import com.driff.android.twitterclient.utils.OnHomeItemClickListener;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by johnj on 17/6/2016.
 */
public class TwitterClientApp extends Application{

    private static final String TWITTER_KEY = "jllOpccfBys7pQoXofTDANJCa";
    private static final String TWITTER_SECRET = "DwTAomajxbT0I42hw2k48JNorHw9T0xWajxLeeHmxoI8jx4COo";

    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new Crashlytics());
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener<MyTweet> clickListener){
        return DaggerImagesComponent
            .builder()
            .libsModule(new LibsModule(fragment))
            .imagesModule(new ImagesModule(view, clickListener))
            .build();
    }
    public HashtagsComponent getHashtagsComponent(HashtagsView view, OnItemClickListener<MyTweet> clickListener){
        return DaggerHashtagsComponent
            .builder()
            .libsModule(new LibsModule(null))
            .hashtagsModule(new HashtagsModule(view, clickListener))
            .build();
    }

    public HomeComponent getTimelineComponent(Fragment fragment, HomeView view, OnHomeItemClickListener<MyTweet> clickListener) {
        return DaggerHomeComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .homeModule(new HomeModule(view, clickListener))
                .build();
    }

    @Override
    public void onTerminate() {
        FlowManager.destroy();
        super.onTerminate();
    }
}
