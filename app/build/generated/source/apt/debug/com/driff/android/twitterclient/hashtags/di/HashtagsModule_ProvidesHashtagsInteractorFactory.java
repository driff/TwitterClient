package com.driff.android.twitterclient.hashtags.di;

import com.driff.android.twitterclient.hashtags.HashtagsInteractor;
import com.driff.android.twitterclient.hashtags.HashtagsRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesHashtagsInteractorFactory implements Factory<HashtagsInteractor> {
  private final HashtagsModule module;
  private final Provider<HashtagsRepository> repositoryProvider;

  public HashtagsModule_ProvidesHashtagsInteractorFactory(HashtagsModule module, Provider<HashtagsRepository> repositoryProvider) {  
    assert module != null;
    this.module = module;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HashtagsInteractor get() {  
    HashtagsInteractor provided = module.providesHashtagsInteractor(repositoryProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<HashtagsInteractor> create(HashtagsModule module, Provider<HashtagsRepository> repositoryProvider) {  
    return new HashtagsModule_ProvidesHashtagsInteractorFactory(module, repositoryProvider);
  }
}

