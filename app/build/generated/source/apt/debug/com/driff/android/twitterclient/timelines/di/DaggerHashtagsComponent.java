package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.api.CustomTwitterApiClient;
import com.driff.android.twitterclient.entities.Hashtag;
import com.driff.android.twitterclient.lib.base.EventBus;
import com.driff.android.twitterclient.lib.di.LibsModule;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesEventBusFactory;
import com.driff.android.twitterclient.lib.di.LibsModule_ProvidesLibraryEventBusFactory;
import com.driff.android.twitterclient.timelines.HashtagsInteractor;
import com.driff.android.twitterclient.timelines.HashtagsPresenter;
import com.driff.android.twitterclient.timelines.HashtagsRepository;
import com.driff.android.twitterclient.timelines.ui.HashtagsFragment;
import com.driff.android.twitterclient.timelines.ui.HashtagsFragment_MembersInjector;
import com.driff.android.twitterclient.timelines.ui.HashtagsView;
import com.driff.android.twitterclient.timelines.ui.adapters.HashtagsAdapter;
import com.driff.android.twitterclient.timelines.ui.adapters.OnItemClickListener;
import com.twitter.sdk.android.core.TwitterSession;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerHashtagsComponent implements HashtagsComponent {
  private Provider<List<Hashtag>> providesItemsListProvider;
  private Provider<OnItemClickListener> providesOnItemClickListenerProvider;
  private Provider<HashtagsAdapter> providesAdapterProvider;
  private Provider<org.greenrobot.eventbus.EventBus> providesLibraryEventBusProvider;
  private Provider<EventBus> providesEventBusProvider;
  private Provider<HashtagsView> providesHashtagsViewProvider;
  private Provider<TwitterSession> providesTwitterSessionProvider;
  private Provider<CustomTwitterApiClient> providesCustomTwitterApiClientProvider;
  private Provider<HashtagsRepository> providesHashtagsRepositoryProvider;
  private Provider<HashtagsInteractor> providesHashtagsInteractorProvider;
  private Provider<HashtagsPresenter> providesHashtagsPresenterProvider;
  private MembersInjector<HashtagsFragment> hashtagsFragmentMembersInjector;

  private DaggerHashtagsComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.providesItemsListProvider = ScopedProvider.create(HashtagsModule_ProvidesItemsListFactory.create(builder.hashtagsModule));
    this.providesOnItemClickListenerProvider = ScopedProvider.create(HashtagsModule_ProvidesOnItemClickListenerFactory.create(builder.hashtagsModule));
    this.providesAdapterProvider = HashtagsModule_ProvidesAdapterFactory.create(builder.hashtagsModule, providesItemsListProvider, providesOnItemClickListenerProvider);
    this.providesLibraryEventBusProvider = ScopedProvider.create(LibsModule_ProvidesLibraryEventBusFactory.create(builder.libsModule));
    this.providesEventBusProvider = ScopedProvider.create(LibsModule_ProvidesEventBusFactory.create(builder.libsModule, providesLibraryEventBusProvider));
    this.providesHashtagsViewProvider = ScopedProvider.create(HashtagsModule_ProvidesHashtagsViewFactory.create(builder.hashtagsModule));
    this.providesTwitterSessionProvider = ScopedProvider.create(HashtagsModule_ProvidesTwitterSessionFactory.create(builder.hashtagsModule));
    this.providesCustomTwitterApiClientProvider = ScopedProvider.create(HashtagsModule_ProvidesCustomTwitterApiClientFactory.create(builder.hashtagsModule, providesTwitterSessionProvider));
    this.providesHashtagsRepositoryProvider = ScopedProvider.create(HashtagsModule_ProvidesHashtagsRepositoryFactory.create(builder.hashtagsModule, providesEventBusProvider, providesCustomTwitterApiClientProvider));
    this.providesHashtagsInteractorProvider = ScopedProvider.create(HashtagsModule_ProvidesHashtagsInteractorFactory.create(builder.hashtagsModule, providesHashtagsRepositoryProvider));
    this.providesHashtagsPresenterProvider = ScopedProvider.create(HashtagsModule_ProvidesHashtagsPresenterFactory.create(builder.hashtagsModule, providesEventBusProvider, providesHashtagsViewProvider, providesHashtagsInteractorProvider));
    this.hashtagsFragmentMembersInjector = HashtagsFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), providesAdapterProvider, providesHashtagsPresenterProvider);
  }

  @Override
  public void inject(HashtagsFragment fragment) {  
    hashtagsFragmentMembersInjector.injectMembers(fragment);
  }

  public static final class Builder {
    private HashtagsModule hashtagsModule;
    private LibsModule libsModule;
  
    private Builder() {  
    }
  
    public HashtagsComponent build() {  
      if (hashtagsModule == null) {
        throw new IllegalStateException("hashtagsModule must be set");
      }
      if (libsModule == null) {
        throw new IllegalStateException("libsModule must be set");
      }
      return new DaggerHashtagsComponent(this);
    }
  
    public Builder hashtagsModule(HashtagsModule hashtagsModule) {  
      if (hashtagsModule == null) {
        throw new NullPointerException("hashtagsModule");
      }
      this.hashtagsModule = hashtagsModule;
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

