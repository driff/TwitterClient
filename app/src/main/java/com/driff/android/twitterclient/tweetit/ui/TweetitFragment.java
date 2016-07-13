package com.driff.android.twitterclient.tweetit.ui;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.tweetit.TweetitPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetitFragment extends DialogFragment implements TweetitView {


    @Bind(R.id.txtContent)
    EditText txtContent;
    @Bind(R.id.view)
    TextInputLayout view;
    @Bind(R.id.button)
    ImageButton button;

    @Inject
    TweetitPresenter presenter;
    @Bind(R.id.container)
    RelativeLayout container;

    public TweetitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tweet_create, container, false);
        ButterKnife.bind(this, view);
        presenter.getRtTweet();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    @OnClick(R.id.button)
    public void hideView() {
        dismiss();
    }

    @Override
    public void onError(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(MyTweet item) {
        if (item != null || !item.getTweetText().isEmpty()) {
            txtContent.setText("RT @" + item.getUserName() + " " + item.getTweetText());
        }
    }

}
