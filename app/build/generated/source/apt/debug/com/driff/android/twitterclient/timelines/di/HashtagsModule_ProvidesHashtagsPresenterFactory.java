package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.timelines.HashtagsInteractor;
import com.driff.android.twitterclient.timelines.HashtagsPresenter;
import com.driff.android.twitterclient.timelines.ui.HashtagsView;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HashtagsModule_ProvidesHashtagsPresenterFactory implements Factory<HashtagsPresenter> {
  private final HashtagsModule module;
  private final Provider<EventBus> eventBusProvider;
  private final Provider<HashtagsView> viewProvider;
  private final Provider<HashtagsInteractor> interactorProvider;

  public HashtagsModule_ProvidesHashtagsPresenterFactory(HashtagsModule module, Provider<EventBus> eventBusProvider, Provider<HashtagsView> viewProvider, Provider<HashtagsInteractor> interactorProvider) {  
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
  public HashtagsPresenter get() {  
    HashtagsPresenter provided = module.providesHashtagsPresenter(eventBusProvider.get(), viewProvider.get(), interactorProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<HashtagsPresenter> create(HashtagsModule module, Provider<EventBus> eventBusProvider, Provider<HashtagsView> viewProvider, Provider<HashtagsInteractor> interactorProvider) {  
    return new HashtagsModule_ProvidesHashtagsPresenterFactory(module, eventBusProvider, viewProvider, interactorProvider);
  }
}

