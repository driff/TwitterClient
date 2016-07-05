package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.images.ImagesRepository;
import com.driff.android.twitterclient.lib.base.EventBus;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesImagesRepositoryFactory implements Factory<ImagesRepository> {
  private final ImagesModule module;
  private final Provider<EventBus> eventBusProvider;
  private final Provider<CustomTwitterApiClient> clientProvider;

  public ImagesModule_ProvidesImagesRepositoryFactory(ImagesModule module, Provider<EventBus> eventBusProvider, Provider<CustomTwitterApiClient> clientProvider) {  
    assert module != null;
    this.module = module;
    assert eventBusProvider != null;
    this.eventBusProvider = eventBusProvider;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public ImagesRepository get() {  
    ImagesRepository provided = module.providesImagesRepository(eventBusProvider.get(), clientProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ImagesRepository> create(ImagesModule module, Provider<EventBus> eventBusProvider, Provider<CustomTwitterApiClient> clientProvider) {  
    return new ImagesModule_ProvidesImagesRepositoryFactory(module, eventBusProvider, clientProvider);
  }
}

