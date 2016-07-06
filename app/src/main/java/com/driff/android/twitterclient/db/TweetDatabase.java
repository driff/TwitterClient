package com.driff.android.twitterclient.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by johnj on 4/7/2016.
 * dbFlow creator
 */
@Database(name = TweetDatabase.NAME, version = TweetDatabase.VERSION)
public class TweetDatabase {
    public static final String NAME = "TweetDB";
    public static final int VERSION = 1;
}
