// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient.images.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ImagesFragment$$ViewBinder<T extends com.driff.android.twitterclient.images.ui.ImagesFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624100, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131624100, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131624056, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131624056, "field 'recyclerView'");
    view = finder.findRequiredView(source, 2131624043, "field 'container'");
    target.container = finder.castView(view, 2131624043, "field 'container'");
  }

  @Override public void unbind(T target) {
    target.progressBar = null;
    target.recyclerView = null;
    target.container = null;
  }
}
