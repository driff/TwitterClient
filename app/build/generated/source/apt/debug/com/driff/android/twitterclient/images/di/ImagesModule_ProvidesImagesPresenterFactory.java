package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.images.ImagesInteractor;
import com.driff.android.twitterclient.images.ImagesPresenter;
import com.driff.android.twitterclient.images.ui.ImagesView;
import com.driff.android.twitterclient.lib.base.EventBus;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ImagesModule_ProvidesImagesPresenterFactory implements Factory<ImagesPresenter> {
  private final ImagesModule module;
  private final Provider<EventBus> eventBusProvider;
  private final Provider<ImagesView> viewProvider;
  private final Provider<ImagesInteractor> interactorProvider;

  public ImagesModule_ProvidesImagesPresenterFactory(ImagesModule module, Provider<EventBus> eventBusProvider, Provider<ImagesView> viewProvider, Provider<ImagesInteractor> interactorProvider) {  
    assert module != null;
    this.module = module;
    assert eventBusProvider != null;
    this.eventBusProvider = eventBusProvider;
    assert viewProvider != null;
    this.viewProvider = viewProvider;
    assert interactorProvider != null;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public ImagesPresenter get() {  
    ImagesPresenter provided = module.providesImagesPresenter(eventBusProvider.get(), viewProvider.get(), interactorProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ImagesPresenter> create(ImagesModule module, Provider<EventBus> eventBusProvider, Provider<ImagesView> viewProvider, Provider<ImagesInteractor> interactorProvider) {  
    return new ImagesModule_ProvidesImagesPresenterFactory(module, eventBusProvider, viewProvider, interactorProvider);
  }
}

