package com.driff.android.twitterclient.hashtags.di;

import com.driff.android.twitterclient.hashtags.ui.HashtagsView;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesHashtagsViewFactory implements Factory<HashtagsView> {
  private final HashtagsModule module;

  public HashtagsModule_ProvidesHashtagsViewFactory(HashtagsModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public HashtagsView get() {  
    HashtagsView provided = module.providesHashtagsView();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<HashtagsView> create(HashtagsModule module) {  
    return new HashtagsModule_ProvidesHashtagsViewFactory(module);
  }
}

