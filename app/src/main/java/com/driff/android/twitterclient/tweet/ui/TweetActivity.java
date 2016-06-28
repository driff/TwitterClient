package com.driff.android.twitterclient.tweet.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.utils.TweetUtils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.driff.android.twitterclient.utils.TweetUtils.getTweetUrl;

public class TweetActivity extends AppCompatActivity {

    @Bind(R.id.txtUser)
    TextView txtUser;
    @Bind(R.id.imgTweet)
    ImageView imgTweet;
    @Bind(R.id.txtTweet)
    TextView txtTweet;
    @Bind(R.id.ibtReply)
    ImageButton ibtReply;
    @Bind(R.id.ibtRetweet)
    ImageButton ibtRetweet;
    @Bind(R.id.ibtLike)
    ImageButton ibtLike;
    @Bind(R.id.container)
    RelativeLayout container;
    private Tweet tweet;
    public static final String TWEET_KEY = "strId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
        ButterKnife.bind(this);
        loadTweet(getIntent());
    }

    private void loadTweet(Intent intent) {
        String tweetId = intent.getStringExtra(TWEET_KEY);
        com.twitter.sdk.android.tweetui.TweetUtils.loadTweet(Long.parseLong(tweetId), new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                tweet = result.data;
                txtUser.setText(TweetUtils.containsUserName(tweet.user) ? "@" + tweet.user.screenName : "Empty");
                String tweetText = tweet.text;
                int index = tweetText.indexOf("http");
                if (index > 0) {
                    tweetText = tweetText.substring(0, index);
                }
                txtTweet.setText(tweetText);
                if (TweetUtils.containsImages(tweet)) {
                    imgTweet.setVisibility(View.VISIBLE);
                    MediaEntity currentPhoto = tweet.entities.media.get(0);
                    String imageUrl = currentPhoto.mediaUrl;
                    Glide.with(getApplicationContext()).load(imageUrl).into(imgTweet);
                }

            }
            @Override
            public void failure(TwitterException exception) {
                Log.e(this.getClass().getSimpleName(), exception.getLocalizedMessage());
            }
        });
    }


    @OnClick({R.id.imgTweet, R.id.ibtReply, R.id.ibtRetweet, R.id.ibtLike})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTweet:
                onImgTweetClick();
                break;
            case R.id.ibtReply:
                Snackbar.make(container, R.string.reply_message, Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.ibtRetweet:
                Snackbar.make(container, "retweet", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.ibtLike:
                Snackbar.make(container, "Like", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    private void onImgTweetClick() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getTweetUrl(tweet.idStr)));
        startActivity(i);
    }

    private void onBtnRetweetClick(){
        TweetComposer composer = TweetComposer.getInstance();
    }

}
