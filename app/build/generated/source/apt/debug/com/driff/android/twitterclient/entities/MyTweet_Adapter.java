package com.driff.android.twitterclient.entities;

import android.content.ContentValues;
import android.database.Cursor;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.sql.language.ConditionGroup;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

public final class MyTweet_Adapter extends ModelAdapter<MyTweet> {
  public MyTweet_Adapter(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<MyTweet> getModelClass() {
    return MyTweet.class;
  }

  public final String getTableName() {
    return "`MyTweet`";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return MyTweet_Table.getAllColumnProperties();
  }

  @Override
  public final void bindToInsertValues(ContentValues values, MyTweet model) {
    if (model.getId() != null) {
      values.put(MyTweet_Table.id.getCursorKey(), model.getId());
    } else {
      values.putNull(MyTweet_Table.id.getCursorKey());
    }
    if (model.getTweetText() != null) {
      values.put(MyTweet_Table.tweetText.getCursorKey(), model.getTweetText());
    } else {
      values.putNull(MyTweet_Table.tweetText.getCursorKey());
    }
    if (model.getUserName() != null) {
      values.put(MyTweet_Table.userName.getCursorKey(), model.getUserName());
    } else {
      values.putNull(MyTweet_Table.userName.getCursorKey());
    }
    if (model.getImageURL() != null) {
      values.put(MyTweet_Table.imageURL.getCursorKey(), model.getImageURL());
    } else {
      values.putNull(MyTweet_Table.imageURL.getCursorKey());
    }
    if (model.getUserAvatarURL() != null) {
      values.put(MyTweet_Table.userAvatarURL.getCursorKey(), model.getUserAvatarURL());
    } else {
      values.putNull(MyTweet_Table.userAvatarURL.getCursorKey());
    }
    values.put(MyTweet_Table.favoriteCount.getCursorKey(), model.getFavoriteCount());
    values.put(MyTweet_Table.retweetCount.getCursorKey(), model.getRetweetCount());
    values.put(MyTweet_Table.retweeted.getCursorKey(), model.isRetweeted() ? 1 : 0);
    values.put(MyTweet_Table.favorite.getCursorKey(), model.isFavorite() ? 1 : 0);
  }

  @Override
  public final void bindToContentValues(ContentValues values, MyTweet model) {
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, MyTweet model, int start) {
    if (model.getId() != null) {
      statement.bindString(1 + start, model.getId());
    } else {
      statement.bindNull(1 + start);
    }
    if (model.getTweetText() != null) {
      statement.bindString(2 + start, model.getTweetText());
    } else {
      statement.bindNull(2 + start);
    }
    if (model.getUserName() != null) {
      statement.bindString(3 + start, model.getUserName());
    } else {
      statement.bindNull(3 + start);
    }
    if (model.getImageURL() != null) {
      statement.bindString(4 + start, model.getImageURL());
    } else {
      statement.bindNull(4 + start);
    }
    if (model.getUserAvatarURL() != null) {
      statement.bindString(5 + start, model.getUserAvatarURL());
    } else {
      statement.bindNull(5 + start);
    }
    statement.bindLong(6 + start, model.getFavoriteCount());
    statement.bindLong(7 + start, model.getRetweetCount());
    statement.bindLong(8 + start, model.isRetweeted() ? 1 : 0);
    statement.bindLong(9 + start, model.isFavorite() ? 1 : 0);
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, MyTweet model) {
    bindToInsertStatement(statement, model, 0);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `MyTweet`(`id`,`tweetText`,`userName`,`imageURL`,`userAvatarURL`,`favoriteCount`,`retweetCount`,`retweeted`,`favorite`) VALUES (?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `MyTweet`(`id`,`tweetText`,`userName`,`imageURL`,`userAvatarURL`,`favoriteCount`,`retweetCount`,`retweeted`,`favorite`) VALUES (?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `MyTweet`(`id` TEXT,`tweetText` TEXT,`userName` TEXT,`imageURL` TEXT,`userAvatarURL` TEXT,`favoriteCount` INTEGER,`retweetCount` INTEGER,`retweeted` INTEGER,`favorite` INTEGER, PRIMARY KEY(`id`)" + ");";
  }

  @Override
  public final void loadFromCursor(Cursor cursor, MyTweet model) {
    int indexid = cursor.getColumnIndex("id");
    if (indexid != -1 && !cursor.isNull(indexid)) {
      model.setId(cursor.getString(indexid));
    } else {
      model.setId(null);
    }
    int indextweetText = cursor.getColumnIndex("tweetText");
    if (indextweetText != -1 && !cursor.isNull(indextweetText)) {
      model.setTweetText(cursor.getString(indextweetText));
    } else {
      model.setTweetText(null);
    }
    int indexuserName = cursor.getColumnIndex("userName");
    if (indexuserName != -1 && !cursor.isNull(indexuserName)) {
      model.setUserName(cursor.getString(indexuserName));
    } else {
      model.setUserName(null);
    }
    int indeximageURL = cursor.getColumnIndex("imageURL");
    if (indeximageURL != -1 && !cursor.isNull(indeximageURL)) {
      model.setImageURL(cursor.getString(indeximageURL));
    } else {
      model.setImageURL(null);
    }
    int indexuserAvatarURL = cursor.getColumnIndex("userAvatarURL");
    if (indexuserAvatarURL != -1 && !cursor.isNull(indexuserAvatarURL)) {
      model.setUserAvatarURL(cursor.getString(indexuserAvatarURL));
    } else {
      model.setUserAvatarURL(null);
    }
    int indexfavoriteCount = cursor.getColumnIndex("favoriteCount");
    if (indexfavoriteCount != -1 && !cursor.isNull(indexfavoriteCount)) {
      model.setFavoriteCount(cursor.getInt(indexfavoriteCount));
    } else {
      model.setFavoriteCount(0);
    }
    int indexretweetCount = cursor.getColumnIndex("retweetCount");
    if (indexretweetCount != -1 && !cursor.isNull(indexretweetCount)) {
      model.setRetweetCount(cursor.getInt(indexretweetCount));
    } else {
      model.setRetweetCount(0);
    }
    int indexretweeted = cursor.getColumnIndex("retweeted");
    if (indexretweeted != -1 && !cursor.isNull(indexretweeted)) {
      model.setRetweeted(cursor.getInt(indexretweeted) == 1 ? true : false);
    } else {
      model.setRetweeted(false);
    }
    int indexfavorite = cursor.getColumnIndex("favorite");
    if (indexfavorite != -1 && !cursor.isNull(indexfavorite)) {
      model.setFavorite(cursor.getInt(indexfavorite) == 1 ? true : false);
    } else {
      model.setFavorite(false);
    }
  }

  @Override
  public final boolean exists(MyTweet model, DatabaseWrapper wrapper) {
    return new Select(Method.count()).from(MyTweet.class).where(getPrimaryConditionClause(model)).count(wrapper) > 0;
  }

  @Override
  public final ConditionGroup getPrimaryConditionClause(MyTweet model) {
    ConditionGroup clause = ConditionGroup.clause();
    clause.and(MyTweet_Table.id.eq(model.getId()));return clause;
  }

  @Override
  public final MyTweet newInstance() {
    return new MyTweet();
  }

  @Override
  public final BaseProperty getProperty(String name) {
    return MyTweet_Table.getProperty(name);
  }
}
