package com.driff.android.twitterclient.lib.di;

import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LibsModule_ProvidesRequestManagerFactory implements Factory<RequestManager> {
  private final LibsModule module;
  private final Provider<Fragment> fragmentProvider;

  public LibsModule_ProvidesRequestManagerFactory(LibsModule module, Provider<Fragment> fragmentProvider) {  
    assert module != null;
    this.module = module;
    assert fragmentProvider != null;
    this.fragmentProvider = fragmentProvider;
  }

  @Override
  public RequestManager get() {  
    RequestManager provided = module.providesRequestManager(fragmentProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<RequestManager> create(LibsModule module, Provider<Fragment> fragmentProvider) {  
    return new LibsModule_ProvidesRequestManagerFactory(module, fragmentProvider);
  }
}

