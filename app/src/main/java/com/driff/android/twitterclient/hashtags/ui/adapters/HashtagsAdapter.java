package com.driff.android.twitterclient.hashtags.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.entities.Hashtag;
import com.driff.android.twitterclient.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnj on 19/6/2016.
 */
public class HashtagsAdapter extends RecyclerView.Adapter<HashtagsAdapter.ViewHolder> {

    private List<Hashtag> dataset;
    private OnItemClickListener<Hashtag> clickListener;

    public HashtagsAdapter(List<Hashtag> dataset, OnItemClickListener<Hashtag> clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_hashtags, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hashtag hashtagTweet = dataset.get(position);
        holder.setOnClickListener(hashtagTweet, clickListener);
        holder.txtTweet.setText(hashtagTweet.getTweetText());
        //Log.i("hastagAdapter.user: ",hashtagTweet.getUserName());
        holder.txtUser.setText(hashtagTweet.getUserName());
        holder.setItems(hashtagTweet.getHashtags());
    }

    public void setItems(List<Hashtag> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.recyclerView)
        RecyclerView recyclerView;
        @Bind(R.id.txtUser)
        TextView txtUser;

        private HashtagListAdapter adapter;
        private ArrayList<String> items;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;

            items = new ArrayList<>();
            adapter = new HashtagListAdapter(items);
           // Log.i(this.getClass().getSimpleName(), "Context for CustomGridLayoutManager= "+context.toString());
            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(context, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        public void setItems(List<String> newItems){
            items.clear();
            items.addAll(newItems);
            adapter.notifyDataSetChanged();
        }

        public void setOnClickListener(final Hashtag hashtag, final OnItemClickListener<Hashtag> listener) {
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hashtag);
                }
            });
        }

    }

}
