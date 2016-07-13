package com.driff.android.twitterclient.utils;

import android.graphics.Color;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

/**
 * Created by johnj on 21/6/2016.
 */
public class TweetUtils {

    public final static int COLOR_GREY = Color.rgb(158, 158, 158);
    public final static int COLOR_DARKGREY = Color.rgb(69, 90, 100);
    public final static int COLOR_GREEN = Color.rgb(139, 195, 74);
    public final static int COLOR_RED = Color.rgb(211, 47, 47);
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

    //returns a gray color if not favorite and a red color if it is favorite
    public static int getFavoriteColor(boolean status) {
        if (status)
            return COLOR_RED;
        else
            return COLOR_GREY;

    }

    public static int getRetweetColor(boolean status) {
        if (status)
            return COLOR_GREEN;
        else
            return COLOR_GREY;

    }

    public static String getTweetUrl(String id){
        return BASE_TWEET_URL + id;
    }
}
