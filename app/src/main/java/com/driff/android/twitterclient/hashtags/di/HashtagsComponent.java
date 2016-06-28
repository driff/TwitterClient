package com.driff.android.twitterclient.hashtags.di;

import com.driff.android.twitterclient.hashtags.ui.HashtagsFragment;
import com.driff.android.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnj on 18/6/2016.
 */

@Singleton @Component(modules = {HashtagsModule.class, LibsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
    //ImagesPresenter getPresenter();
}
