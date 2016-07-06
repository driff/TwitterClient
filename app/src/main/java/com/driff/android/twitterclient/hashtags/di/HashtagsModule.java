package com.driff.android.twitterclient.hashtags.di;


import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.hashtags.HashtagsInteractor;
import com.driff.android.twitterclient.hashtags.HashtagsInteractorImpl;
import com.driff.android.twitterclient.hashtags.HashtagsPresenter;
import com.driff.android.twitterclient.hashtags.HashtagsPresenterImpl;
import com.driff.android.twitterclient.hashtags.HashtagsRepository;
import com.driff.android.twitterclient.hashtags.HashtagsRepositoryImpl;
import com.driff.android.twitterclient.hashtags.ui.HashtagsView;
import com.driff.android.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by johnj on 18/6/2016.
 */
@Module
public class HashtagsModule {

    private HashtagsView view;
    private OnItemClickListener<MyTweet> clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    HashtagsAdapter providesAdapter(List<MyTweet> dataset, OnItemClickListener<MyTweet> clickListener) {
        return new HashtagsAdapter(dataset, clickListener);
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
    HashtagsPresenter providesHashtagsPresenter(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor){
        return new HashtagsPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesHashtagsView(){
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus, client);
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
