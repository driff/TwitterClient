package com.driff.android.twitterclient.images.di;


import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.Image;
import com.driff.android.twitterclient.images.ImagesInteractor;
import com.driff.android.twitterclient.images.ImagesInteractorImpl;
import com.driff.android.twitterclient.images.ImagesPresenter;
import com.driff.android.twitterclient.images.ImagesPresenterImpl;
import com.driff.android.twitterclient.images.ImagesRepository;
import com.driff.android.twitterclient.images.ImagesRepositoryImpl;
import com.driff.android.twitterclient.images.ui.ImagesView;
import com.driff.android.twitterclient.images.ui.adapters.ImagesAdapter;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.lib.base.ImageLoader;
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
public class ImagesModule {

    private ImagesView view;
    private OnItemClickListener<Image> clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener<Image> clickListener) {
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }


    @Provides
    @Singleton
    OnItemClickListener<Image> providesOnItemClickListener() {
        return this.clickListener;
    }


    @Provides
    @Singleton
    List<Image> providesItemsList() {
        return new ArrayList<Image>();
    }


    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(EventBus eventBus, ImagesView view, ImagesInteractor interactor){
        return new ImagesPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
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
