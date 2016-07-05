package com.driff.android.twitterclient.timelines.ui;

import android.support.v4.app.Fragment;
import com.driff.android.twitterclient.timelines.HashtagsPresenter;
import com.driff.android.twitterclient.timelines.ui.adapters.HashtagsAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsFragment_MembersInjector implements MembersInjector<HashtagsFragment> {
  private final MembersInjector<Fragment> supertypeInjector;
  private final Provider<HashtagsAdapter> adapterProvider;
  private final Provider<HashtagsPresenter> presenterProvider;

  public HashtagsFragment_MembersInjector(MembersInjector<Fragment> supertypeInjector, Provider<HashtagsAdapter> adapterProvider, Provider<HashtagsPresenter> presenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public void injectMembers(HashtagsFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.adapter = adapterProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static MembersInjector<HashtagsFragment> create(MembersInjector<Fragment> supertypeInjector, Provider<HashtagsAdapter> adapterProvider, Provider<HashtagsPresenter> presenterProvider) {  
      return new HashtagsFragment_MembersInjector(supertypeInjector, adapterProvider, presenterProvider);
  }
}

