package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.entities.MyTweet;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesItemsListFactory implements Factory<List<MyTweet>> {
  private final ImagesModule module;

  public ImagesModule_ProvidesItemsListFactory(ImagesModule module) {  
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

  public static Factory<List<MyTweet>> create(ImagesModule module) {  
    return new ImagesModule_ProvidesItemsListFactory(module);
  }
}

