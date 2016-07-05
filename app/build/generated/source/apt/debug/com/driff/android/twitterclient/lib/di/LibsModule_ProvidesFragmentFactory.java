package com.driff.android.twitterclient.lib.di;

import android.support.v4.app.Fragment;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LibsModule_ProvidesFragmentFactory implements Factory<Fragment> {
  private final LibsModule module;

  public LibsModule_ProvidesFragmentFactory(LibsModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Fragment get() {  
    Fragment provided = module.providesFragment();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Fragment> create(LibsModule module) {  
    return new LibsModule_ProvidesFragmentFactory(module);
  }
}

