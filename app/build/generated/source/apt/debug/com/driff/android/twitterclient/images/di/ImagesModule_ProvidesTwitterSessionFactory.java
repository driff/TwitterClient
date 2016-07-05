package com.driff.android.twitterclient.images.di;

import com.twitter.sdk.android.core.TwitterSession;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesTwitterSessionFactory implements Factory<TwitterSession> {
  private final ImagesModule module;

  public ImagesModule_ProvidesTwitterSessionFactory(ImagesModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public TwitterSession get() {  
    TwitterSession provided = module.providesTwitterSession();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<TwitterSession> create(ImagesModule module) {  
    return new ImagesModule_ProvidesTwitterSessionFactory(module);
  }
}

