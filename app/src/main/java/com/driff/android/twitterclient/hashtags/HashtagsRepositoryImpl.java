package com.driff.android.twitterclient.hashtags;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.Hashtag;
import com.driff.android.twitterclient.hashtags.events.HashtagsEvent;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.driff.android.twitterclient.utils.TweetUtils.containsHashtags;
import static com.driff.android.twitterclient.utils.TweetUtils.containsUserName;


/**
 * Created by johnj on 18/6/2016.
 */
public class HashtagsRepositoryImpl implements HashtagsRepository {

    private EventBus eventBus;
    private CustomTwitterApiClient client;
    private final static int TWEET_COUNT = 100;

    public HashtagsRepositoryImpl(EventBus eventBus, CustomTwitterApiClient client) {
        this.eventBus = eventBus;
        this.client = client;
    }

    @Override
    public void getHashtags() {
        final Callback<List<Tweet>> callback = new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                List<Hashtag> items = new ArrayList<>();
                for (Tweet tweet: result.data){
                    if (containsHashtags(tweet)) {
                        Hashtag tweetModel = new Hashtag();
                        tweetModel.setId(tweet.idStr);
                        tweetModel.setFavoriteCount(tweet.favoriteCount);
                        tweetModel.setTweetText(tweet.text);
                        tweetModel.setUserName(containsUserName(tweet.user)?tweet.user.screenName:"@blank");
                        List<String> hashtags = new ArrayList<>();
                        for (HashtagEntity hashtag : tweet.entities.hashtags) {
                            hashtags.add(hashtag.text);
                        }
                        tweetModel.setHashtags(hashtags);
                        items.add(tweetModel);
                    }
                }

                Collections.sort(items, new Comparator<Hashtag>() {
                    @Override
                    public int compare(Hashtag lhs, Hashtag rhs) {
                        return rhs.getFavoriteCount() - lhs.getFavoriteCount();
                    }
                });
                post(items);
            }

            @Override
            public void failure(TwitterException e) {
                post(e.getLocalizedMessage());
            }
        };
        client.getTimelineService().homeTimeline(TWEET_COUNT, false, true, true, true, callback);
    }

    private void post(List<Hashtag> items){
        post(items, null);
    }

    private void post(String error){
        post(null, error);
    }

    private void post(List<Hashtag> items, String error){
        HashtagsEvent event = new HashtagsEvent();
        event.setError(error);
        event.setItems(items);
        eventBus.post(event);
    }

}
