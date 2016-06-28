package com.driff.android.twitterclient.images.di;

import com.driff.android.twitterclient.images.ui.ImagesFragment;
import com.driff.android.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnj on 18/6/2016.
 */

@Singleton @Component(modules = {ImagesModule.class, LibsModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    //ImagesPresenter getPresenter();
}
