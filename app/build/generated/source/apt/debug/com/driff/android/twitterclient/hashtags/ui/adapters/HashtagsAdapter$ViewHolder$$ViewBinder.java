// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient.hashtags.ui.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HashtagsAdapter$ViewHolder$$ViewBinder<T extends com.driff.android.twitterclient.hashtags.ui.adapters.HashtagsAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624054, "field 'txtTweet'");
    target.txtTweet = finder.castView(view, 2131624054, "field 'txtTweet'");
    view = finder.findRequiredView(source, 2131624059, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131624059, "field 'recyclerView'");
    view = finder.findRequiredView(source, 2131624052, "field 'txtUser'");
    target.txtUser = finder.castView(view, 2131624052, "field 'txtUser'");
  }

  @Override public void unbind(T target) {
    target.txtTweet = null;
    target.recyclerView = null;
    target.txtUser = null;
  }
}
