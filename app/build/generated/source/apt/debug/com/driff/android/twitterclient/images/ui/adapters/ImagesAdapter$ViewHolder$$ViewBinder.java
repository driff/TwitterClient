// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient.images.ui.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ImagesAdapter$ViewHolder$$ViewBinder<T extends com.driff.android.twitterclient.images.ui.adapters.ImagesAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624060, "field 'imgMedia'");
    target.imgMedia = finder.castView(view, 2131624060, "field 'imgMedia'");
    view = finder.findRequiredView(source, 2131624054, "field 'txtTweet'");
    target.txtTweet = finder.castView(view, 2131624054, "field 'txtTweet'");
    view = finder.findRequiredView(source, 2131624052, "field 'txtUser'");
    target.txtUser = finder.castView(view, 2131624052, "field 'txtUser'");
  }

  @Override public void unbind(T target) {
    target.imgMedia = null;
    target.txtTweet = null;
    target.txtUser = null;
  }
}
