// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient.main;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.driff.android.twitterclient.main.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624050, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131624050, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131624051, "field 'tabs'");
    target.tabs = finder.castView(view, 2131624051, "field 'tabs'");
    view = finder.findRequiredView(source, 2131624046, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131624046, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    target.toolbar = null;
    target.tabs = null;
    target.viewPager = null;
  }
}
