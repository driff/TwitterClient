package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import com.driff.android.twitterclient.timelines.TimelineInteractor;
import com.driff.android.twitterclient.timelines.TimelineInteractorImpl;
import com.driff.android.twitterclient.timelines.TimelinePresenter;
import com.driff.android.twitterclient.timelines.TimelinePresenterImpl;
import com.driff.android.twitterclient.timelines.TimelineRepository;
import com.driff.android.twitterclient.timelines.TimelineRepositoryImpl;
import com.driff.android.twitterclient.timelines.ui.TimelineView;
import com.driff.android.twitterclient.timelines.ui.adapters.TimelineAdapter;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by johnj on 6/7/2016.
 */
@Module
public class TimelineModule {

    private TimelineView view;
    private OnItemClickListener<MyTweet> clickListener;

    public TimelineModule(TimelineView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    TimelineAdapter providesAdapter(List<MyTweet> dataset, ImageLoader imageLoader, OnItemClickListener<MyTweet> clickListener) {
        return new TimelineAdapter(dataset, imageLoader, clickListener);
    }


    @Provides
    @Singleton
    OnItemClickListener<MyTweet> providesOnItemClickListener() {
        return this.clickListener;
    }


    @Provides
    @Singleton
    List<MyTweet> providesItemsList() {
        return new ArrayList<MyTweet>();
    }


    @Provides
    @Singleton
    TimelinePresenter providesTimelinePresenter(EventBus eventBus, TimelineView view, TimelineInteractor interactor){
        return new TimelinePresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    TimelineView providesTimelineView(){
        return this.view;
    }

    @Provides
    @Singleton
    TimelineInteractor providesTimelineInteractor(TimelineRepository repository){
        return new TimelineInteractorImpl(repository);
    }

    @Provides
    @Singleton
    TimelineRepository providesTimelineRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new TimelineRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(TwitterSession session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession providesTwitterSession(){
        return Twitter.getSessionManager().getActiveSession();
    }

}
