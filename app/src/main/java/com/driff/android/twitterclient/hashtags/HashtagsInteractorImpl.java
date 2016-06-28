package com.driff.android.twitterclient.hashtags;

import javax.inject.Inject;

/**
 * Created by johnj on 18/6/2016.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {

    HashtagsRepository repository;

    @Inject
    public HashtagsInteractorImpl(HashtagsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getHashtags();
    }
}
