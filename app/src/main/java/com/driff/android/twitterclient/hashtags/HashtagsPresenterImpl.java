package com.driff.android.twitterclient.hashtags;

import com.driff.android.twitterclient.hashtags.events.HashtagsEvent;
import com.driff.android.twitterclient.hashtags.ui.HashtagsView;
import com.driff.android.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by johnj on 18/6/2016.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {

    private EventBus eventBus;
    private HashtagsView view;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor) {
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
        view= null;
    }

    @Override
    public void getHashtagTweets() {
        if( view != null){
            view.hideHashtags();
            view.showProgressBar();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String error = event.getError();
        if( view != null){
            view.showHashtags();
            view.hideProgressBar();
            if(error != null){
                view.onError(error);
            }else{
                view.setContent(event.getItems());
            }
        }
    }
}
