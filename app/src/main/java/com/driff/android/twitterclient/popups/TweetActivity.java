package com.driff.android.twitterclient.popups;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.entities.MyTweet_Table;
import com.driff.android.twitterclient.utils.TweetUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.driff.android.twitterclient.utils.TweetUtils.getTweetUrl;

public class TweetActivity extends AppCompatActivity {

    public static final String TWEET_KEY = "strId";
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
        ButterKnife.bind(this);
        loadTweet(getIntent());
    }

    private void loadTweet(Intent intent) {
        final String tweetId = intent.getStringExtra(TWEET_KEY);
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
                //final MyTweet[] t = new MyTweet[1];
                FlowManager.getDatabaseForTable(MyTweet.class)
                        .beginTransactionAsync(new QueryTransaction.Builder<>(
                                SQLite.select()
                                        .from(MyTweet.class)
                                        .where(MyTweet_Table.id.is(tweetId)))
                                .queryResult(new QueryTransaction.QueryResultCallback<MyTweet>() {
                                    @Override
                                    public void onQueryResult(QueryTransaction transaction, @NonNull CursorResult<MyTweet> tResult) {
                                        MyTweet myTweet = tResult.toModelClose();
                                        txtUser.setText("@" + myTweet.getUserName());
                                        String tweetText = myTweet.getTweetText();
                                        int index = tweetText.indexOf("http");
                                        if (index > 0) {
                                            tweetText = tweetText.substring(0, index);
                                        }
                                        txtTweet.setText(tweetText);
                                        if (!myTweet.getImageURL().isEmpty()) {
                                            //String imageUrl = currentPhoto.mediaUrl;
                                            Glide.with(getApplicationContext()).load(myTweet.getImageURL()).into(imgTweet);
                                        }
                                    }
                                }).build())
                        .build().execute();
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

    /*private void onBtnRetweetClick(){
        TweetComposer composer = TweetComposer.getInstance();
    }*/

}
