package com.driff.android.twitterclient.timelines.di;

import com.driff.android.twitterclient.lib.di.LibsModule;
import com.driff.android.twitterclient.timelines.ui.TimelineFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnj on 22/6/2016.
 */
@Singleton
@Component(modules = {TimelineModule.class, LibsModule.class})
public interface TimelineComponent {

    void inject(TimelineFragment fragment);

}
