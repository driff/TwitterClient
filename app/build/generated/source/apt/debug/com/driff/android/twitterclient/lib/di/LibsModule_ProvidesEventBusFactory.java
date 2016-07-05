package com.driff.android.twitterclient.lib.di;

import com.driff.android.twitterclient.lib.base.EventBus;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LibsModule_ProvidesEventBusFactory implements Factory<EventBus> {
  private final LibsModule module;
  private final Provider<org.greenrobot.eventbus.EventBus> eventBusProvider;

  public LibsModule_ProvidesEventBusFactory(LibsModule module, Provider<org.greenrobot.eventbus.EventBus> eventBusProvider) {  
    assert module != null;
    this.module = module;
    assert eventBusProvider != null;
    this.eventBusProvider = eventBusProvider;
  }

  @Override
  public EventBus get() {  
    EventBus provided = module.providesEventBus(eventBusProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<EventBus> create(LibsModule module, Provider<org.greenrobot.eventbus.EventBus> eventBusProvider) {  
    return new LibsModule_ProvidesEventBusFactory(module, eventBusProvider);
  }
}

