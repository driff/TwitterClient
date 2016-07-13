package com.driff.android.twitterclient.home.di;

import com.driff.android.twitterclient.home.ui.HomeFragment;
import com.driff.android.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnj on 22/6/2016.
 */
@Singleton
@Component(modules = {HomeModule.class, LibsModule.class})
public interface HomeComponent {

    void inject(HomeFragment fragment);

}
