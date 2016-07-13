package com.raizlabs.android.dbflow.config;

import com.driff.android.twitterclient.db.TweetDatabase;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.entities.MyTweet_Adapter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class TweetDatabaseTweetDB_Database extends DatabaseDefinition {
  public TweetDatabaseTweetDB_Database(DatabaseHolder holder) {
    holder.putDatabaseForTable(MyTweet.class, this);
    models.add(MyTweet.class);
    modelTableNames.put("MyTweet", MyTweet.class);
    modelAdapters.put(MyTweet.class, new MyTweet_Adapter(holder, this));
  }

  @Override
  public final Class getAssociatedDatabaseClassFile() {
    return TweetDatabase.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean isInMemory() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 2;
  }

  @Override
  public final String getDatabaseName() {
    return "TweetDB";
  }
}
