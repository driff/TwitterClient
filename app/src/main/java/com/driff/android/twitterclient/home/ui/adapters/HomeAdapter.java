package com.driff.android.twitterclient.home.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.hashtags.ui.adapters.CustomGridLayoutManager;
import com.driff.android.twitterclient.hashtags.ui.adapters.HashtagListAdapter;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import com.driff.android.twitterclient.utils.OnHomeItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.driff.android.twitterclient.utils.TweetUtils.getFavoriteColor;
import static com.driff.android.twitterclient.utils.TweetUtils.getRetweetColor;

/**
 * Created by johnj on 22/6/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<MyTweet> tweets;
    private OnHomeItemClickListener<MyTweet> clickListener;
    private ImageLoader imgLoader;

    public HomeAdapter(List<MyTweet> tweets, ImageLoader imageLoader, OnHomeItemClickListener<MyTweet> clickListener) {
        this.tweets = tweets;
        this.clickListener = clickListener;
        this.imgLoader = imageLoader;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyTweet tlTweet = tweets.get(position);
        holder.setOnClickListener(tlTweet, clickListener);
        holder.txtUser.setText(tlTweet.getUserName());
        holder.txtTweet.setText(tlTweet.getTweetText());
        holder.btnRT.setColorFilter(getRetweetColor(tlTweet.isRetweeted()));
        holder.btnFav.setColorFilter(getFavoriteColor(tlTweet.isFavorite()));
        if (tlTweet.getImageURL() != null && !tlTweet.getImageURL().isEmpty()) {
            holder.imgMedia.setVisibility(View.VISIBLE);
            imgLoader.load(holder.imgMedia, tlTweet.getImageURL());
        } else {
            holder.imgMedia.setVisibility(View.GONE);
        }
        holder.setItems(tlTweet.getHashtags());
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void setItems(List<MyTweet> items) {
        tweets.addAll(items);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imgMedia)
        ImageView imgMedia;
        @Bind(R.id.txtUser)
        TextView txtUser;
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.recyclerView)
        RecyclerView recyclerView;
        @Bind(R.id.btnFav)
        ImageButton btnFav;
        @Bind(R.id.btnRT)
        ImageButton btnRT;
        @Bind(R.id.btnShare)
        ImageButton btnShare;

        private View view;
        private HashtagListAdapter adapter;
        private ArrayList<String> items;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.view = itemView;

            items = new ArrayList<>();
            adapter = new HashtagListAdapter(items);
            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(context, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        public void setItems(List<String> newItems) {
            items.clear();
            items.addAll(newItems);
            adapter.notifyDataSetChanged();
        }


        public void setOnClickListener(final MyTweet tlTweet, final OnHomeItemClickListener<MyTweet> listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(tlTweet);
                }
            });

            btnFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onFavoriteClick(tlTweet);
                }
            });

            btnRT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onRetweetClick(tlTweet);
                }
            });
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onShareClick(tlTweet);
                }
            });
        }
    }

}