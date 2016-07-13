package com.driff.android.twitterclient.home;

import android.util.Log;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.entities.MyTweet_Table;
import com.driff.android.twitterclient.home.events.HomeEvent;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.driff.android.twitterclient.utils.TweetUtils.containsImages;
import static com.driff.android.twitterclient.utils.TweetUtils.containsUserName;

/**
 * Created by johnj on 22/6/2016.
 */
public class HomeRepositoryImpl implements HomeRepository {

    private final static int TWEET_COUNT = 100;
    private EventBus eventBus;
    private CustomTwitterApiClient client;
    private List<MyTweet> tweets;

    public HomeRepositoryImpl(EventBus eventBus, CustomTwitterApiClient client) {
        this.eventBus = eventBus;
        this.client = client;
    }

    @Override
    public void getHomeTimeline() {
        client.getTimelineService().homeTimeline(TWEET_COUNT, false, true, true, true, listCallback());
    }

    private retrofit.Callback<List<Tweet>> listCallback() {
        //TODO: check memory consumption of this, if gc not cleaning up i'll have to instantiate it.
        return new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                if (tweets == null || tweets.isEmpty())
                    tweets = new ArrayList<>();
                else {
                    tweets.clear();
                }
                Log.i(this.getClass().getCanonicalName(), "items size: " + result.data.size());
                for (Tweet tweet : result.data) {
                    MyTweet tweetModel = new MyTweet();
                    tweetModel.setId(tweet.idStr);
                    tweetModel.setFavoriteCount(tweet.favoriteCount);
                    tweetModel.setFavorite(tweet.favorited);
                    tweetModel.setRetweeted(tweet.retweeted);
                    tweetModel.setRetweetCount(tweet.retweetCount);
                    tweetModel.setUserAvatarURL(tweet.user.profileImageUrl);
                    tweetModel.setUserName(containsUserName(tweet.user) ? tweet.user.screenName : "@blank");
                    String tweetText = tweet.text;
                    int index = tweetText.indexOf("http");
                    if (index > 0) {
                        tweetText = tweetText.substring(0, index);
                    }
                    tweetModel.setTweetText(tweetText);
                    if (containsImages(tweet)) {
                        MediaEntity currentPhoto = tweet.entities.media.get(0);
                        String imageUrl = currentPhoto.mediaUrl;
                        tweetModel.setImageURL(imageUrl);
                    }
                    List<String> hashtags = new ArrayList<>();
                    for (HashtagEntity hashtag : tweet.entities.hashtags) {
                        hashtags.add(hashtag.text);
                    }
                    tweetModel.setHashtags(hashtags);
                    tweets.add(tweetModel);
                }

                Collections.sort(tweets, new Comparator<MyTweet>() {
                    @Override
                    public int compare(MyTweet lhs, MyTweet rhs) {
                        return rhs.getFavoriteCount() - lhs.getFavoriteCount();
                    }
                });
                FastStoreModelTransaction
                        .saveBuilder(FlowManager.getModelAdapter(MyTweet.class))
                        .addAll(tweets)
                        .build();
                post(tweets);
            }

            @Override
            public void failure(TwitterException e) {
                List<MyTweet> newTweets = new ArrayList<>();
                tweets = SQLite.select()
                        .from(MyTweet.class)
                        .queryList();
                Log.i(this.getClass().getCanonicalName(), "tweets size: " + tweets.size());
                Log.e(this.getClass().getCanonicalName(), "List: " + e.getLocalizedMessage());
                for (MyTweet tweet :
                        tweets) {
                    tweet.setHashtags(Arrays.asList(""));
                    newTweets.add(tweet);
                }
                if (newTweets.isEmpty()) {
                    post(e.getLocalizedMessage());
                } else {
                    post(newTweets);
                }
            }
        };
    }

    retrofit.Callback<Tweet> callback() {
        return new Callback<Tweet>() {
            @Override
            public void success(final Result<Tweet> result) {
                Log.i(this.getClass().getCanonicalName(), "callback worked...");
                MyTweet myTweet = SQLite.select().from(MyTweet.class).where(MyTweet_Table.id.is(result.data.idStr)).querySingle();
                if (myTweet != null) {
                    myTweet.setRetweeted(result.data.retweeted);
                    myTweet.setFavorite(result.data.favorited);
                    myTweet.update();
                    tweets.add(tweets.indexOf(myTweet), myTweet);
                }
                post(tweets);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.e(this.getClass().getCanonicalName(), "callback: " + exception.getLocalizedMessage());
                post(exception.getLocalizedMessage());
            }
        };
    }

    public void setFavorite(boolean isFav, MyTweet myTweet) {
        if (isFav) {
            client.getTimelineService().createFavorite(myTweet.getId(), callback());
        } else {
            client.getTimelineService().destroyFavorite(myTweet.getId(), callback());
        }
        myTweet.setFavorite(isFav);
        myTweet.update();
    }

    @Override
    public void setRetweet(boolean isRT, MyTweet myTweet) {
        if (isRT) {
            client.getTimelineService().doRetweet(myTweet.getId(), callback());
        } else {
            client.getTimelineService().undoRetweet(myTweet.getId(), callback());
        }
        myTweet.setRetweeted(isRT);
        myTweet.update();
    }

    private void post(List<MyTweet> items) {
        post(items, null);
    }

    private void post(String error) {
        post(null, error);
    }

    private void post(List<MyTweet> items, String error) {
        HomeEvent event = new HomeEvent();
        event.setError(error);
        event.setItems(items);
        eventBus.post(event);
    }

}
