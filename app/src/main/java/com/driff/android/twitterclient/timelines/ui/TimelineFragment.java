package com.driff.android.twitterclient.timelines.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.TwitterClientApp;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.timelines.TimelinePresenter;
import com.driff.android.twitterclient.timelines.di.TimelineComponent;
import com.driff.android.twitterclient.timelines.ui.adapters.TimelineAdapter;
import com.driff.android.twitterclient.tweet.ui.TweetActivity;
import com.driff.android.twitterclient.utils.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnj on 22/6/2016.
 */
public class TimelineFragment extends Fragment implements TimelineView, OnItemClickListener<MyTweet> {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.container)
    FrameLayout container;

    @Inject
    TimelineAdapter adapter;
    @Inject
    TimelinePresenter presenter;

    public TimelineFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        setupInjection();
        setupRecyclerView();
        presenter.getTimelineTweets();
        return view;
    }

    private void setupInjection() {
        TwitterClientApp app = (TwitterClientApp)getActivity().getApplication();
        TimelineComponent timelineComponent = app.getTimelineComponent(this, this, this);
        timelineComponent.inject(this);

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

}
