package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesOnItemClickListenerFactory implements Factory<OnItemClickListener<MyTweet>> {
  private final ImagesModule module;

  public ImagesModule_ProvidesOnItemClickListenerFactory(ImagesModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OnItemClickListener<MyTweet> get() {  
    OnItemClickListener<MyTweet> provided = module.providesOnItemClickListener();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OnItemClickListener<MyTweet>> create(ImagesModule module) {  
    return new ImagesModule_ProvidesOnItemClickListenerFactory(module);
  }
}

