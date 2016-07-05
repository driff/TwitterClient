package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.entities.Hashtag;
import com.driff.android.twitterclient.timelines.ui.adapters.HashtagsAdapter;
import com.driff.android.twitterclient.timelines.ui.adapters.OnItemClickListener;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesAdapterFactory implements Factory<HashtagsAdapter> {
  private final HashtagsModule module;
  private final Provider<List<Hashtag>> datasetProvider;
  private final Provider<OnItemClickListener> clickListenerProvider;

  public HashtagsModule_ProvidesAdapterFactory(HashtagsModule module, Provider<List<Hashtag>> datasetProvider, Provider<OnItemClickListener> clickListenerProvider) {  
    assert module != null;
    this.module = module;
    assert datasetProvider != null;
    this.datasetProvider = datasetProvider;
    assert clickListenerProvider != null;
    this.clickListenerProvider = clickListenerProvider;
  }

  @Override
  public HashtagsAdapter get() {  
    HashtagsAdapter provided = module.providesAdapter(datasetProvider.get(), clickListenerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<HashtagsAdapter> create(HashtagsModule module, Provider<List<Hashtag>> datasetProvider, Provider<OnItemClickListener> clickListenerProvider) {  
    return new HashtagsModule_ProvidesAdapterFactory(module, datasetProvider, clickListenerProvider);
  }
}

