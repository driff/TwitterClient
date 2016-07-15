package com.driff.android.twitterclient.home.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.home.HomeInteractor;
import com.driff.android.twitterclient.home.HomeInteractorImpl;
import com.driff.android.twitterclient.home.HomePresenter;
import com.driff.android.twitterclient.home.HomePresenterImpl;
import com.driff.android.twitterclient.home.HomeRepository;
import com.driff.android.twitterclient.home.HomeRepositoryImpl;
import com.driff.android.twitterclient.home.ui.HomeView;
import com.driff.android.twitterclient.home.ui.adapters.HomeAdapter;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import com.driff.android.twitterclient.utils.OnHomeItemClickListener;
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
public class HomeModule {

    private HomeView view;
    private OnHomeItemClickListener<MyTweet> clickListener;

    public HomeModule(HomeView view, OnHomeItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    HomeAdapter providesAdapter(List<MyTweet> dataset, ImageLoader imageLoader, OnHomeItemClickListener<MyTweet> clickListener) {
        return new HomeAdapter(dataset, imageLoader, clickListener);
    }


    @Provides
    @Singleton
    OnHomeItemClickListener<MyTweet> providesOnItemClickListener() {
        return this.clickListener;
    }


    @Provides
    @Singleton
    List<MyTweet> providesItemsList() {
        return new ArrayList<MyTweet>();
    }


    @Provides
    @Singleton
    HomePresenter providesHomePresenter(EventBus eventBus, HomeView view, HomeInteractor interactor) {
        return new HomePresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    HomeView providesTimelineView() {
        return this.view;
    }

    @Provides
    @Singleton
    HomeInteractor providesHomeInteractor(HomeRepository repository) {
        return new HomeInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HomeRepository providesHomeRepository(EventBus eventBus, CustomTwitterApiClient client) {
        return new HomeRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession providesTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }

}
