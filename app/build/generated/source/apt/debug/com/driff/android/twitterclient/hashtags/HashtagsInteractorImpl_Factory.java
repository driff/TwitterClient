package com.driff.android.twitterclient.hashtags;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsInteractorImpl_Factory implements Factory<HashtagsInteractorImpl> {
  private final Provider<HashtagsRepository> repositoryProvider;

  public HashtagsInteractorImpl_Factory(Provider<HashtagsRepository> repositoryProvider) {  
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HashtagsInteractorImpl get() {  
    return new HashtagsInteractorImpl(repositoryProvider.get());
  }

  public static Factory<HashtagsInteractorImpl> create(Provider<HashtagsRepository> repositoryProvider) {  
    return new HashtagsInteractorImpl_Factory(repositoryProvider);
  }
}

