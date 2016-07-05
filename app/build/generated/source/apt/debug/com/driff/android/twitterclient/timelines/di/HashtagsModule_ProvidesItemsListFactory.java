package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.entities.Hashtag;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesItemsListFactory implements Factory<List<Hashtag>> {
  private final HashtagsModule module;

  public HashtagsModule_ProvidesItemsListFactory(HashtagsModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public List<Hashtag> get() {  
    List<Hashtag> provided = module.providesItemsList();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<List<Hashtag>> create(HashtagsModule module) {  
    return new HashtagsModule_ProvidesItemsListFactory(module);
  }
}

