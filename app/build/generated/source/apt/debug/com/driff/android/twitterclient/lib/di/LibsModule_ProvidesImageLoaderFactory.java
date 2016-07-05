package com.driff.android.twitterclient.lib.di;

import com.bumptech.glide.RequestManager;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LibsModule_ProvidesImageLoaderFactory implements Factory<ImageLoader> {
  private final LibsModule module;
  private final Provider<RequestManager> requestManagerProvider;

  public LibsModule_ProvidesImageLoaderFactory(LibsModule module, Provider<RequestManager> requestManagerProvider) {  
    assert module != null;
    this.module = module;
    assert requestManagerProvider != null;
    this.requestManagerProvider = requestManagerProvider;
  }

  @Override
  public ImageLoader get() {  
    ImageLoader provided = module.providesImageLoader(requestManagerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ImageLoader> create(LibsModule module, Provider<RequestManager> requestManagerProvider) {  
    return new LibsModule_ProvidesImageLoaderFactory(module, requestManagerProvider);
  }
}

