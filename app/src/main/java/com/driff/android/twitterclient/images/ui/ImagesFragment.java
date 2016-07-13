package com.driff.android.twitterclient.images.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.TwitterClientApp;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.images.ImagesPresenter;
import com.driff.android.twitterclient.images.di.ImagesComponent;
import com.driff.android.twitterclient.images.ui.adapters.ImagesAdapter;
import com.driff.android.twitterclient.popups.TweetActivity;
import com.driff.android.twitterclient.utils.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnj on 18/6/2016.
 */
public class ImagesFragment extends Fragment implements ImagesView, OnItemClickListener<MyTweet> {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.container)
    FrameLayout container;
    @Inject
    ImagesPresenter presenter;
    @Inject
    ImagesAdapter adapter;

    public ImagesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        setupInjection();
        presenter.getImageTweets();
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
    }

    /*private void setupAdapter() {
        adapter.setItems(new ArrayList<Image>());
        recyclerView.setAdapter(adapter);
    }*/

    private void setupInjection() {
        TwitterClientApp app = (TwitterClientApp)getActivity().getApplication();
        ImagesComponent imagesComponent = app.getImagesComponent(this, this, this);
        imagesComponent.inject(this);
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
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showImages() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImages() {
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
        /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(image.getTweetUrl()));*/
        Intent i = new Intent(getContext(), TweetActivity.class);
        i.putExtra(TweetActivity.TWEET_KEY, tweet.getId());
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
