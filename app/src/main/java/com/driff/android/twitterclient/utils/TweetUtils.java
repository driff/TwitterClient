package com.driff.android.twitterclient.utils;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

/**
 * Created by johnj on 21/6/2016.
 */
public class TweetUtils {

    private final static String BASE_TWEET_URL = "https://twitter.com/null/status/";

    public static boolean containsImages(Tweet tweet){
        return tweet.entities != null && tweet.entities.media !=null && !tweet.entities.media.isEmpty();
    }

    public static boolean containsUserName(User user){
        return user != null && user.entities != null && user.screenName != null;
    }

    public static boolean containsHashtags(Tweet tweet){
        return tweet.entities != null && tweet.entities.hashtags !=null && !tweet.entities.hashtags.isEmpty();
    }

    public static String getTweetUrl(String id){
        return BASE_TWEET_URL + id;
    }
}
