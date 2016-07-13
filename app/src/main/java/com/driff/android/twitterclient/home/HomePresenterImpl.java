package com.driff.android.twitterclient.home;

import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.home.events.HomeEvent;
import com.driff.android.twitterclient.home.ui.HomeView;
import com.driff.android.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by johnj on 22/6/2016.
 */
public class HomePresenterImpl implements HomePresenter {

    private EventBus eventBus;
    private HomeView view;
    private HomeInteractor interactor;

    public HomePresenterImpl(EventBus eventBus, HomeView view, HomeInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHomeTweets() {
        if (view != null) {
            view.showTimeline();
            view.hideProgressBar();
        }
        interactor.getTimeline();
    }

    @Override
    public void setFavorite(boolean isFav, MyTweet myTweet) {
        interactor.setFavorite(isFav, myTweet);
    }

    @Override
    public void setRetweet(boolean isRT, MyTweet myTweet) {
        interactor.setRetweet(isRT, myTweet);
    }

    @Override
    @Subscribe
    public void onEventMainThread(HomeEvent event) {
        String error = event.getError();
        if (view != null) {
            view.showTimeline();
            view.hideProgressBar();
            if (error != null) {
                view.onError(error);
            } else {
                view.setContent(event.getItems());
            }
        }
    }
}
