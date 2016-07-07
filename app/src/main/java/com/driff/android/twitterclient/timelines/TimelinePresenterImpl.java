package com.driff.android.twitterclient.timelines;

import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.timelines.events.TimelineEvent;
import com.driff.android.twitterclient.timelines.ui.TimelineView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by johnj on 22/6/2016.
 */
public class TimelinePresenterImpl implements TimelinePresenter {

    private EventBus eventBus;
    private TimelineView view;
    private TimelineInteractor interactor;

    public TimelinePresenterImpl(EventBus eventBus, TimelineView view, TimelineInteractor interactor) {
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
    public void getTimelineTweets() {
        if(view != null){
            view.showTimeline();
            view.hideProgressBar();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(TimelineEvent event) {
        String error = event.getError();
        if( view != null){
            view.showTimeline();
            view.hideProgressBar();
            if(error != null){
                view.onError(error);
            }else{
                view.setContent(event.getItems());
            }
        }
    }
}
