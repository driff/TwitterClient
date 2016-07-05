package com.driff.android.twitterclient.timelines.di;

import com.twitter.sdk.android.core.TwitterSession;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesTwitterSessionFactory implements Factory<TwitterSession> {
  private final HashtagsModule module;

  public HashtagsModule_ProvidesTwitterSessionFactory(HashtagsModule module) {  
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

  public static Factory<TwitterSession> create(HashtagsModule module) {  
    return new HashtagsModule_ProvidesTwitterSessionFactory(module);
  }
}

