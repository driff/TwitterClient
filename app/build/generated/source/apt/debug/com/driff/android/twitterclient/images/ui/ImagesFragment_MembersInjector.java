package com.driff.android.twitterclient.images.ui;

import android.support.v4.app.Fragment;
import com.driff.android.twitterclient.images.ImagesPresenter;
import com.driff.android.twitterclient.images.ui.adapters.ImagesAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesFragment_MembersInjector implements MembersInjector<ImagesFragment> {
  private final MembersInjector<Fragment> supertypeInjector;
  private final Provider<ImagesPresenter> presenterProvider;
  private final Provider<ImagesAdapter> adapterProvider;

  public ImagesFragment_MembersInjector(MembersInjector<Fragment> supertypeInjector, Provider<ImagesPresenter> presenterProvider, Provider<ImagesAdapter> adapterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  @Override
  public void injectMembers(ImagesFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.presenter = presenterProvider.get();
    instance.adapter = adapterProvider.get();
  }

  public static MembersInjector<ImagesFragment> create(MembersInjector<Fragment> supertypeInjector, Provider<ImagesPresenter> presenterProvider, Provider<ImagesAdapter> adapterProvider) {  
      return new ImagesFragment_MembersInjector(supertypeInjector, presenterProvider, adapterProvider);
  }
}

