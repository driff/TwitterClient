package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.entities.Image;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesOnItemClickListenerFactory implements Factory<OnItemClickListener<Image>> {
  private final ImagesModule module;

  public ImagesModule_ProvidesOnItemClickListenerFactory(ImagesModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OnItemClickListener<Image> get() {  
    OnItemClickListener<Image> provided = module.providesOnItemClickListener();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OnItemClickListener<Image>> create(ImagesModule module) {  
    return new ImagesModule_ProvidesOnItemClickListenerFactory(module);
  }
}

