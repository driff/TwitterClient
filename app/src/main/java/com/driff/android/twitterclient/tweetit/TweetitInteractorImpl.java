package com.driff.android.twitterclient.tweetit;

import javax.inject.Inject;

/**
 * Created by johnj on 12/7/2016.
 */
public class TweetitInteractorImpl implements TweetitInteractor {

    private TweetitRepository repository;

    @Inject
    public TweetitInteractorImpl(TweetitRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.getRtTweet();
    }

}
