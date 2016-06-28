package com.driff.android.twitterclient.api;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Created by johnj on 17/6/2016.
 */
public class CustomTwitterApiClient extends TwitterApiClient {

    public CustomTwitterApiClient(Session session){
        super(session);
    }

    public TimelineService getTimelineService(){
        return getService(TimelineService.class);
    }

}
