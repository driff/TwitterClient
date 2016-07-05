package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.images.ui.ImagesView;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesImagesViewFactory implements Factory<ImagesView> {
  private final ImagesModule module;

  public ImagesModule_ProvidesImagesViewFactory(ImagesModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public ImagesView get() {  
    ImagesView provided = module.providesImagesView();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ImagesView> create(ImagesModule module) {  
    return new ImagesModule_ProvidesImagesViewFactory(module);
  }
}

