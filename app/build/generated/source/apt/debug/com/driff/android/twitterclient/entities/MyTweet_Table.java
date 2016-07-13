package com.driff.android.twitterclient.entities;

import com.raizlabs.android.dbflow.runtime.BaseContentProvider.PropertyConverter;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.IntProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class MyTweet_Table {
  public static final PropertyConverter PROPERTY_CONVERTER = new PropertyConverter(){ 
  public IProperty fromName(String columnName) {
  return com.driff.android.twitterclient.entities.MyTweet_Table.getProperty(columnName); 
  }
  };

  public static final Property<String> id = new Property<String>(MyTweet.class, "id");

  public static final Property<String> tweetText = new Property<String>(MyTweet.class, "tweetText");

  public static final Property<String> userName = new Property<String>(MyTweet.class, "userName");

  public static final Property<String> imageURL = new Property<String>(MyTweet.class, "imageURL");

  public static final Property<String> userAvatarURL = new Property<String>(MyTweet.class, "userAvatarURL");

  public static final IntProperty favoriteCount = new IntProperty(MyTweet.class, "favoriteCount");

  public static final IntProperty retweetCount = new IntProperty(MyTweet.class, "retweetCount");

  public static final Property<Boolean> retweeted = new Property<Boolean>(MyTweet.class, "retweeted");

  public static final Property<Boolean> favorite = new Property<Boolean>(MyTweet.class, "favorite");

  public static final IProperty[] getAllColumnProperties() {
    return new IProperty[]{id,tweetText,userName,imageURL,userAvatarURL,favoriteCount,retweetCount,retweeted,favorite};
  }

  public static BaseProperty getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch (columnName)  {
      case "`id`":  {
        return id;
      }
      case "`tweetText`":  {
        return tweetText;
      }
      case "`userName`":  {
        return userName;
      }
      case "`imageURL`":  {
        return imageURL;
      }
      case "`userAvatarURL`":  {
        return userAvatarURL;
      }
      case "`favoriteCount`":  {
        return favoriteCount;
      }
      case "`retweetCount`":  {
        return retweetCount;
      }
      case "`retweeted`":  {
        return retweeted;
      }
      case "`favorite`":  {
        return favorite;
      }
      default:  {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }
}
