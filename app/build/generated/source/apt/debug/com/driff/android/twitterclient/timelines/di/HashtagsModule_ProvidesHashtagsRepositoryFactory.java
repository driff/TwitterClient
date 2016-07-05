package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.timelines.HashtagsRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesHashtagsRepositoryFactory implements Factory<HashtagsRepository> {
  private final HashtagsModule module;
  private final Provider<EventBus> eventBusProvider;
  private final Provider<CustomTwitterApiClient> clientProvider;

  public HashtagsModule_ProvidesHashtagsRepositoryFactory(HashtagsModule module, Provider<EventBus> eventBusProvider, Provider<CustomTwitterApiClient> clientProvider) {  
    assert module != null;
    this.module = module;
    assert eventBusProvider != null;
    this.eventBusProvider = eventBusProvider;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public HashtagsRepository get() {  
    HashtagsRepository provided = module.providesHashtagsRepository(eventBusProvider.get(), clientProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<HashtagsRepository> create(HashtagsModule module, Provider<EventBus> eventBusProvider, Provider<CustomTwitterApiClient> clientProvider) {  
    return new HashtagsModule_ProvidesHashtagsRepositoryFactory(module, eventBusProvider, clientProvider);
  }
}

