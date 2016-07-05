// Generated code from Butter Knife. Do not modify!
package com.driff.android.twitterclient;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.driff.android.twitterclient.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624044, "field 'twitterLoginButton'");
    target.twitterLoginButton = finder.castView(view, 2131624044, "field 'twitterLoginButton'");
    view = finder.findRequiredView(source, 2131624043, "field 'container'");
    target.container = finder.castView(view, 2131624043, "field 'container'");
  }

  @Override public void unbind(T target) {
    target.twitterLoginButton = null;
    target.container = null;
  }
}
