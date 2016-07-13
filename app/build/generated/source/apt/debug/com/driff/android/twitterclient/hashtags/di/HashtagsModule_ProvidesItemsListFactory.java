package com.driff.android.twitterclient.hashtags.di;

import com.driff.android.twitterclient.entities.MyTweet;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesItemsListFactory implements Factory<List<MyTweet>> {
  private final HashtagsModule module;

  public HashtagsModule_ProvidesItemsListFactory(HashtagsModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public List<MyTweet> get() {  
    List<MyTweet> provided = module.providesItemsList();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<List<MyTweet>> create(HashtagsModule module) {  
    return new HashtagsModule_ProvidesItemsListFactory(module);
  }
}

