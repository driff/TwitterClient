package com.driff.android.twitterclient.images;

import android.util.Log;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.images.events.ImagesEvent;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
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
 * Created by johnj on 18/6/2016.
 */
public class ImagesRepositoryImpl implements ImagesRepository {

    private EventBus eventBus;
    private CustomTwitterApiClient client;
    private final static int TWEET_COUNT = 100;
    private List<MyTweet> tweets;

    public ImagesRepositoryImpl(EventBus eventBus, CustomTwitterApiClient client) {
        this.eventBus = eventBus;
        this.client = client;
    }

    @Override
    public void getImages() {
        Callback<List<Tweet>> callback = new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                List<MyTweet> items = new ArrayList<>();
                for (Tweet tweet: result.data){
                    if (containsImages(tweet)) {
                        MyTweet tweetModel = new MyTweet();
                        tweetModel.setId(tweet.idStr);
                        tweetModel.setFavoriteCount(tweet.favoriteCount);
                        tweetModel.setUserName(containsUserName(tweet.user)?tweet.user.screenName:"@blank");
                        String tweetText = tweet.text;
                        int index = tweetText.indexOf("http");
                        if(index > 0){
                            tweetText = tweetText.substring(0, index);
                        }
                        tweetModel.setTweetText(tweetText);

                        MediaEntity currentPhoto = tweet.entities.media.get(0);
                        String imageUrl = currentPhoto.mediaUrl;
                        tweetModel.setImageURL(imageUrl);
                        //tweetModel.save();
                        items.add(tweetModel);
                    }
                }

                Collections.sort(items, new Comparator<MyTweet>() {
                    @Override
                    public int compare(MyTweet lhs, MyTweet rhs) {
                        return rhs.getFavoriteCount() - lhs.getFavoriteCount();
                    }
                });
                FastStoreModelTransaction
                        .saveBuilder(FlowManager.getModelAdapter(MyTweet.class))
                        .addAll(items)
                        .build();
                post(items);
            }

            @Override
            public void failure(TwitterException e) {
                List<MyTweet> newTweets = new ArrayList<>();
                tweets = SQLite.select()
                        .from(MyTweet.class)
                        .queryList();
                Log.i(this.getClass().getCanonicalName(), "tweets size: "+tweets.size());

                for (MyTweet tweet :
                        tweets) {
                    String[] a = new String[]{"empty"};
                    tweet.setHashtags(Arrays.asList(a));
                    newTweets.add(tweet);
                }

                if(newTweets.isEmpty()){
                    post(e.getLocalizedMessage());
                }else{
                    post(newTweets);
                }
            }
        };
        client.getTimelineService().homeTimeline(TWEET_COUNT, false, true, true, true, callback);
    }

    private void post(List<MyTweet> items){
        post(items, null);
    }

    private void post(String error){
        post(null, error);
    }

    private void post(List<MyTweet> items, String error){
        ImagesEvent event = new ImagesEvent();
        event.setError(error);
        event.setItems(items);
        eventBus.post(event);
    }

}
