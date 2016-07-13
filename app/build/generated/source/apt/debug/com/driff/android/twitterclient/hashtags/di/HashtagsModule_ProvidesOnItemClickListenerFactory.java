package com.driff.android.twitterclient.hashtags.di;

import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesOnItemClickListenerFactory implements Factory<OnItemClickListener<MyTweet>> {
  private final HashtagsModule module;

  public HashtagsModule_ProvidesOnItemClickListenerFactory(HashtagsModule module) {  
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

  public static Factory<OnItemClickListener<MyTweet>> create(HashtagsModule module) {  
    return new HashtagsModule_ProvidesOnItemClickListenerFactory(module);
  }
}

