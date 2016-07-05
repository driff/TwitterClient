package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.timelines.ui.adapters.OnItemClickListener;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesOnItemClickListenerFactory implements Factory<OnItemClickListener> {
  private final HashtagsModule module;

  public HashtagsModule_ProvidesOnItemClickListenerFactory(HashtagsModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OnItemClickListener get() {  
    OnItemClickListener provided = module.providesOnItemClickListener();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OnItemClickListener> create(HashtagsModule module) {  
    return new HashtagsModule_ProvidesOnItemClickListenerFactory(module);
  }
}

