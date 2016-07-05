package com.driff.android.twitterclient.images;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesInteractorImpl_Factory implements Factory<ImagesInteractorImpl> {
  private final Provider<ImagesRepository> repositoryProvider;

  public ImagesInteractorImpl_Factory(Provider<ImagesRepository> repositoryProvider) {  
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ImagesInteractorImpl get() {  
    return new ImagesInteractorImpl(repositoryProvider.get());
  }

  public static Factory<ImagesInteractorImpl> create(Provider<ImagesRepository> repositoryProvider) {  
    return new ImagesInteractorImpl_Factory(repositoryProvider);
  }
}

