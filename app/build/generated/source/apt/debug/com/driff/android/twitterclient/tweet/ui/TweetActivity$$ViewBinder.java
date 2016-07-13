// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient.tweet.ui;

import android.view.View;

import com.driff.android.twitterclient.popups.TweetActivity;

import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TweetActivity$$ViewBinder<T extends TweetActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624052, "field 'txtUser'");
    target.txtUser = finder.castView(view, 2131624052, "field 'txtUser'");
    view = finder.findRequiredView(source, 2131624053, "field 'imgTweet' and method 'onClick'");
    target.imgTweet = finder.castView(view, 2131624053, "field 'imgTweet'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624054, "field 'txtTweet'");
    target.txtTweet = finder.castView(view, 2131624054, "field 'txtTweet'");
    view = finder.findRequiredView(source, 2131624056, "field 'ibtReply' and method 'onClick'");
    target.ibtReply = finder.castView(view, 2131624056, "field 'ibtReply'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624057, "field 'ibtRetweet' and method 'onClick'");
    target.ibtRetweet = finder.castView(view, 2131624057, "field 'ibtRetweet'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624058, "field 'ibtLike' and method 'onClick'");
    target.ibtLike = finder.castView(view, 2131624058, "field 'ibtLike'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624046, "field 'container'");
    target.container = finder.castView(view, 2131624046, "field 'container'");
  }

  @Override public void unbind(T target) {
    target.txtUser = null;
    target.imgTweet = null;
    target.txtTweet = null;
    target.ibtReply = null;
    target.ibtRetweet = null;
    target.ibtLike = null;
    target.container = null;
  }
}
