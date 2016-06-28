package com.driff.android.twitterclient.images;

import com.driff.android.twitterclient.images.events.ImagesEvent;
import com.driff.android.twitterclient.images.ui.ImagesView;
import com.driff.android.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by johnj on 18/6/2016.
 */
public class ImagesPresenterImpl implements ImagesPresenter {

    private EventBus eventBus;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(EventBus eventBus, ImagesView view, ImagesInteractor interactor) {
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
    public void getImageTweets() {
        if( view != null){
            view.hideImages();
            view.showProgressBar();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(ImagesEvent event) {
        String error = event.getError();
        if( view != null){
            view.showImages();
            view.hideProgressBar();
            if(error != null){
                view.onError(error);
            }else{
                view.setContent(event.getItems());
            }
        }
    }
}
