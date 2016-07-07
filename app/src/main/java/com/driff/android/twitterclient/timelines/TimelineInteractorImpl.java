package com.driff.android.twitterclient.timelines;

import javax.inject.Inject;

/**
 * Created by johnj on 22/6/2016.
 */
public class TimelineInteractorImpl implements TimelineInteractor {

    TimelineRepository repository;

    @Inject
    public TimelineInteractorImpl(TimelineRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getTimelines();
    }
}
