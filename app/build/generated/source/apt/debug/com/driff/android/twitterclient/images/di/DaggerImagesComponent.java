package com.driff.android.twitterclient.images.di;

import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;
import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.Image;
import com.driff.android.twitterclient.images.ImagesInteractor;
import com.driff.android.twitterclient.images.ImagesPresenter;
import com.driff.android.twitterclient.images.ImagesRepository;
import com.driff.android.twitterclient.images.ui.ImagesFragment;
import com.driff.android.twitterclient.images.ui.ImagesFragment_MembersInjector;
import com.driff.android.twitterclient.images.ui.ImagesView;
import com.driff.android.twitterclient.images.ui.adapters.ImagesAdapter;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import com.driff.android.twitterclient.lib.di.LibsModule;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesEventBusFactory;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesFragmentFactory;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesImageLoaderFactory;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesLibraryEventBusFactory;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesRequestManagerFactory;
import com.driff.android.twitterclient.utils.OnItemClickListener;
import com.twitter.sdk.android.core.TwitterSession;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerImagesComponent implements ImagesComponent {
  private Provider<org.greenrobot.eventbus.EventBus> providesLibraryEventBusProvider;
  private Provider<EventBus> providesEventBusProvider;
  private Provider<ImagesView> providesImagesViewProvider;
  private Provider<TwitterSession> providesTwitterSessionProvider;
  private Provider<CustomTwitterApiClient> providesCustomTwitterApiClientProvider;
  private Provider<ImagesRepository> providesImagesRepositoryProvider;
  private Provider<ImagesInteractor> providesImagesInteractorProvider;
  private Provider<ImagesPresenter> providesImagesPresenterProvider;
  private Provider<List<Image>> providesItemsListProvider;
  private Provider<Fragment> providesFragmentProvider;
  private Provider<RequestManager> providesRequestManagerProvider;
  private Provider<ImageLoader> providesImageLoaderProvider;
  private Provider<OnItemClickListener<Image>> providesOnItemClickListenerProvider;
  private Provider<ImagesAdapter> providesAdapterProvider;
  private MembersInjector<ImagesFragment> imagesFragmentMembersInjector;

  private DaggerImagesComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.providesLibraryEventBusProvider = ScopedProvider.create(LibsModule_ProvidesLibraryEventBusFactory.create(builder.libsModule));
    this.providesEventBusProvider = ScopedProvider.create(LibsModule_ProvidesEventBusFactory.create(builder.libsModule, providesLibraryEventBusProvider));
    this.providesImagesViewProvider = ScopedProvider.create(ImagesModule_ProvidesImagesViewFactory.create(builder.imagesModule));
    this.providesTwitterSessionProvider = ScopedProvider.create(ImagesModule_ProvidesTwitterSessionFactory.create(builder.imagesModule));
    this.providesCustomTwitterApiClientProvider = ScopedProvider.create(ImagesModule_ProvidesCustomTwitterApiClientFactory.create(builder.imagesModule, providesTwitterSessionProvider));
    this.providesImagesRepositoryProvider = ScopedProvider.create(ImagesModule_ProvidesImagesRepositoryFactory.create(builder.imagesModule, providesEventBusProvider, providesCustomTwitterApiClientProvider));
    this.providesImagesInteractorProvider = ScopedProvider.create(ImagesModule_ProvidesImagesInteractorFactory.create(builder.imagesModule, providesImagesRepositoryProvider));
    this.providesImagesPresenterProvider = ScopedProvider.create(ImagesModule_ProvidesImagesPresenterFactory.create(builder.imagesModule, providesEventBusProvider, providesImagesViewProvider, providesImagesInteractorProvider));
    this.providesItemsListProvider = ScopedProvider.create(ImagesModule_ProvidesItemsListFactory.create(builder.imagesModule));
    this.providesFragmentProvider = ScopedProvider.create(LibsModule_ProvidesFragmentFactory.create(builder.libsModule));
    this.providesRequestManagerProvider = ScopedProvider.create(LibsModule_ProvidesRequestManagerFactory.create(builder.libsModule, providesFragmentProvider));
    this.providesImageLoaderProvider = ScopedProvider.create(LibsModule_ProvidesImageLoaderFactory.create(builder.libsModule, providesRequestManagerProvider));
    this.providesOnItemClickListenerProvider = ScopedProvider.create(ImagesModule_ProvidesOnItemClickListenerFactory.create(builder.imagesModule));
    this.providesAdapterProvider = ImagesModule_ProvidesAdapterFactory.create(builder.imagesModule, providesItemsListProvider, providesImageLoaderProvider, providesOnItemClickListenerProvider);
    this.imagesFragmentMembersInjector = ImagesFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), providesImagesPresenterProvider, providesAdapterProvider);
  }

  @Override
  public void inject(ImagesFragment fragment) {  
    imagesFragmentMembersInjector.injectMembers(fragment);
  }

  public static final class Builder {
    private ImagesModule imagesModule;
    private LibsModule libsModule;
  
    private Builder() {  
    }
  
    public ImagesComponent build() {  
      if (imagesModule == null) {
        throw new IllegalStateException("imagesModule must be set");
      }
      if (libsModule == null) {
        throw new IllegalStateException("libsModule must be set");
      }
      return new DaggerImagesComponent(this);
    }
  
    public Builder imagesModule(ImagesModule imagesModule) {  
      if (imagesModule == null) {
        throw new NullPointerException("imagesModule");
      }
      this.imagesModule = imagesModule;
      return this;
    }
  
    public Builder libsModule(LibsModule libsModule) {  
      if (libsModule == null) {
        throw new NullPointerException("libsModule");
      }
      this.libsModule = libsModule;
      return this;
    }
  }
}

