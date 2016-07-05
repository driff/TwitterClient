package com.driff.android.twitterclient.lib.di;

import dagger.internal.Factory;
import javax.annotation.Generated;
import org.greenrobot.eventbus.EventBus;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LibsModule_ProvidesLibraryEventBusFactory implements Factory<EventBus> {
  private final LibsModule module;

  public LibsModule_ProvidesLibraryEventBusFactory(LibsModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public EventBus get() {  
    EventBus provided = module.providesLibraryEventBus();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<EventBus> create(LibsModule module) {  
    return new LibsModule_ProvidesLibraryEventBusFactory(module);
  }
}

