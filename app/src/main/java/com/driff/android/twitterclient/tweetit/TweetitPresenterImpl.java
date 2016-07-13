package com.driff.android.twitterclient.tweetit;

import com.driff.android.twitterclient.events.SingleTweetEvent;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.tweetit.ui.TweetitView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by johnj on 12/7/2016.
 */
public class TweetitPresenterImpl implements TweetitPresenter {

    EventBus eventBus;
    TweetitView view;
    TweetitInteractor interactor;

    public TweetitPresenterImpl(EventBus eventBus, TweetitView view, TweetitInteractor interactor) {
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
    public void getRtTweet() {
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(SingleTweetEvent event) {
        String error = event.getError();
        if (view != null) {
            if (error != null) {
                view.onError(error);
            } else {
                view.setContent(event.getItem());
            }
        }
    }
}
