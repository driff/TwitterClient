package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.images.ui.adapters.ImagesAdapter;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesAdapterFactory implements Factory<ImagesAdapter> {
  private final ImagesModule module;
  private final Provider<List<MyTweet>> datasetProvider;
  private final Provider<ImageLoader> imageLoaderProvider;
  private final Provider<OnItemClickListener<MyTweet>> clickListenerProvider;

  public ImagesModule_ProvidesAdapterFactory(ImagesModule module, Provider<List<MyTweet>> datasetProvider, Provider<ImageLoader> imageLoaderProvider, Provider<OnItemClickListener<MyTweet>> clickListenerProvider) {  
    assert module != null;
    this.module = module;
    assert datasetProvider != null;
    this.datasetProvider = datasetProvider;
    assert imageLoaderProvider != null;
    this.imageLoaderProvider = imageLoaderProvider;
    assert clickListenerProvider != null;
    this.clickListenerProvider = clickListenerProvider;
  }

  @Override
  public ImagesAdapter get() {  
    ImagesAdapter provided = module.providesAdapter(datasetProvider.get(), imageLoaderProvider.get(), clickListenerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ImagesAdapter> create(ImagesModule module, Provider<List<MyTweet>> datasetProvider, Provider<ImageLoader> imageLoaderProvider, Provider<OnItemClickListener<MyTweet>> clickListenerProvider) {  
    return new ImagesModule_ProvidesAdapterFactory(module, datasetProvider, imageLoaderProvider, clickListenerProvider);
  }
}

