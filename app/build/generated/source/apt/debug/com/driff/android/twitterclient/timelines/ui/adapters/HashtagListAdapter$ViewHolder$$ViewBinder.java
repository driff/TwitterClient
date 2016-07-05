// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient.timelines.ui.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HashtagListAdapter$ViewHolder$$ViewBinder<T extends com.driff.android.twitterclient.timelines.ui.adapters.HashtagListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624114, "field 'txtHashtag'");
    target.txtHashtag = finder.castView(view, 2131624114, "field 'txtHashtag'");
  }

  @Override public void unbind(T target) {
    target.txtHashtag = null;
  }
}
