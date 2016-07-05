package com.driff.android.twitterclient.hashtags.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesCustomTwitterApiClientFactory implements Factory<CustomTwitterApiClient> {
  private final HashtagsModule module;
  private final Provider<TwitterSession> sessionProvider;

  public HashtagsModule_ProvidesCustomTwitterApiClientFactory(HashtagsModule module, Provider<TwitterSession> sessionProvider) {  
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public CustomTwitterApiClient get() {  
    CustomTwitterApiClient provided = module.providesCustomTwitterApiClient(sessionProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<CustomTwitterApiClient> create(HashtagsModule module, Provider<TwitterSession> sessionProvider) {  
    return new HashtagsModule_ProvidesCustomTwitterApiClientFactory(module, sessionProvider);
  }
}

