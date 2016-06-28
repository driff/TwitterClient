package com.driff.android.twitterclient.images;

import javax.inject.Inject;

/**
 * Created by johnj on 18/6/2016.
 */
public class ImagesInteractorImpl implements ImagesInteractor {

    ImagesRepository repository;

    @Inject
    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
