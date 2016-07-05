package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesCustomTwitterApiClientFactory implements Factory<CustomTwitterApiClient> {
  private final ImagesModule module;
  private final Provider<TwitterSession> sessionProvider;

  public ImagesModule_ProvidesCustomTwitterApiClientFactory(ImagesModule module, Provider<TwitterSession> sessionProvider) {  
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

  public static Factory<CustomTwitterApiClient> create(ImagesModule module, Provider<TwitterSession> sessionProvider) {  
    return new ImagesModule_ProvidesCustomTwitterApiClientFactory(module, sessionProvider);
  }
}

