package com.driff.android.twitterclient.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.TwitterClientApp;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.home.HomePresenter;
import com.driff.android.twitterclient.home.di.HomeComponent;
import com.driff.android.twitterclient.home.ui.adapters.HomeAdapter;
import com.driff.android.twitterclient.popups.TweetActivity;
import com.driff.android.twitterclient.utils.OnHomeItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnj on 22/6/2016.
 */
public class HomeFragment extends Fragment implements HomeView, OnHomeItemClickListener<MyTweet> {

    private static final int TWEET_COMPOSER_REQUEST_CODE = 100;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.container)
    FrameLayout container;

    @Inject
    HomeAdapter adapter;
    @Inject
    HomePresenter presenter;
    @Bind(R.id.refresh)
    SwipeRefreshLayout refresh;

    public HomeFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        setupInjection();
        setupRecyclerView();
        setupRefresh();
        presenter.getHomeTweets();
        return view;
    }

    private void setupRefresh() {
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getHomeTweets();
                refresh.setRefreshing(false);
            }
        });
    }

    private void setupInjection() {
        TwitterClientApp app = (TwitterClientApp) getActivity().getApplication();
        HomeComponent homeComponent = app.getTimelineComponent(this, this, this);
        homeComponent.inject(this);

    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        presenter.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showTimeline() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTimeline() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(List<MyTweet> items) {
        adapter.setItems(items);
    }

    @Override
    public void onItemClick(MyTweet tweet) {
        Intent i = new Intent(getContext(), TweetActivity.class);
        i.putExtra(TweetActivity.TWEET_KEY, tweet.getId());
        startActivity(i);
    }

    @Override
    public void onRetweetClick(MyTweet tweet) {
        Log.i(this.getClass().getCanonicalName(), "Retweeted tweet");
        presenter.setRetweet(!tweet.isRetweeted(), tweet);
    }

    @Override
    public void onShareClick(MyTweet tweet) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.tweet_share_subject)+tweet.getUserName());
        intent.putExtra(Intent.EXTRA_TEXT, tweet.getTweetText() + "\n" + getString(R.string.tweet_share_source) + tweet.getTweetUrl());
        startActivity(intent);
    }

    @Override
    public void onFavoriteClick(MyTweet tweet) {
        presenter.setFavorite(!tweet.isFavorite(), tweet);
    }

}
