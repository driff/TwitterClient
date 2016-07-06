package com.driff.android.twitterclient.images.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.driff.android.twitterclient.R;
import com.driff.android.twitterclient.entities.MyTweet;
import com.driff.android.twitterclient.lib.base.ImageLoader;
import com.driff.android.twitterclient.utils.OnItemClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnj on 18/6/2016.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private List<MyTweet> dataset;
    private ImageLoader imageLoader;
    private OnItemClickListener<MyTweet> clickListener;

    public ImagesAdapter(List<MyTweet> dataset, ImageLoader imageLoader, OnItemClickListener<MyTweet> clickListener) {
        this.dataset = dataset;
        this.imageLoader = imageLoader;
        this.clickListener = clickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyTweet imageTweet = dataset.get(position);
        holder.setOnClickListener(imageTweet, clickListener);
        holder.txtTweet.setText(imageTweet.getTweetText());
        holder.txtUser.setText(imageTweet.getUserName());
        imageLoader.load(holder.imgMedia, imageTweet.getImageURL());
    }

    public void setItems(List<MyTweet> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        @Bind(R.id.imgMedia)
        ImageView imgMedia;
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.txtUser)
        TextView txtUser;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }

        public void setOnClickListener(final MyTweet image, final OnItemClickListener<MyTweet> listener) {
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(image);
                }
            });
        }

    }

}
