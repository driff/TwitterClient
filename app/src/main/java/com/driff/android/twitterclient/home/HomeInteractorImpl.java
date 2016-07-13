package com.driff.android.twitterclient.home;

import com.driff.android.twitterclient.entities.MyTweet;

import javax.inject.Inject;

/**
 * Created by johnj on 22/6/2016.
 */
public class HomeInteractorImpl implements HomeInteractor {

    HomeRepository repository;

    @Inject
    public HomeInteractorImpl(HomeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getTimeline() {
        repository.getHomeTimeline();
    }

    @Override
    public void setFavorite(boolean isFav, MyTweet myTweet) {
        repository.setFavorite(isFav, myTweet);
    }

    @Override
    public void setRetweet(boolean isRT, MyTweet myTweet) {
        repository.setRetweet(isRT, myTweet);
    }
}
