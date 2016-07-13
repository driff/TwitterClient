package com.driff.android.twitterclient.entities;

import com.driff.android.twitterclient.db.TweetDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by johnj on 22/6/2016.
 */
@Table(database = TweetDatabase.class)
public class MyTweet extends BaseModel{
    private final static String BASE_TWEET_URL = "https://twitter.com/null/status/";
    @SerializedName("id")
    @PrimaryKey private String id;
    @Column private String tweetText;
    @Column private String userName;
    @SerializedName("image_url")
    @Column private String imageURL;
    @Column private String userAvatarURL;
    @Column private int favoriteCount;
    @Column private int retweetCount;
    @Column private boolean retweeted;
    @Column
    private boolean favorite;
    private List<String> hashtags;
    private List<String> mentions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAvatarURL() {
        return userAvatarURL;
    }

    public void setUserAvatarURL(String userAvatarURL) {
        this.userAvatarURL = userAvatarURL;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getTweetUrl(){
        return BASE_TWEET_URL + this.id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public List<String> getMentions() {
        return mentions;
    }

    public void setMentions(List<String> mentions) {
        this.mentions = mentions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTweet)) return false;

        MyTweet myTweet = (MyTweet) o;

        if (favoriteCount != myTweet.favoriteCount) return false;
        if (retweetCount != myTweet.retweetCount) return false;
        if (!id.equals(myTweet.id)) return false;
        if (!tweetText.equals(myTweet.tweetText)) return false;
        if (!userName.equals(myTweet.userName)) return false;
        return imageURL != null ? imageURL.equals(myTweet.imageURL) : myTweet.imageURL == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tweetText.hashCode();
        result = 31 * result + userName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MyTweet{" +
                "favorite=" + favorite +
                ", retweeted=" + retweeted +
                ", retweetCount=" + retweetCount +
                ", favoriteCount=" + favoriteCount +
                ", imageURL='" + imageURL + '\'' +
                ", userName='" + userName + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
