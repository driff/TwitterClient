package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.images.ImagesInteractor;
import com.driff.android.twitterclient.images.ImagesRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesImagesInteractorFactory implements Factory<ImagesInteractor> {
  private final ImagesModule module;
  private final Provider<ImagesRepository> repositoryProvider;

  public ImagesModule_ProvidesImagesInteractorFactory(ImagesModule module, Provider<ImagesRepository> repositoryProvider) {  
    assert module != null;
    this.module = module;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ImagesInteractor get() {  
    ImagesInteractor provided = module.providesImagesInteractor(repositoryProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ImagesInteractor> create(ImagesModule module, Provider<ImagesRepository> repositoryProvider) {  
    return new ImagesModule_ProvidesImagesInteractorFactory(module, repositoryProvider);
  }
}

