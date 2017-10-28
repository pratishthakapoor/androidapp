package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.util.AppConstants;
import in.co.gomovie.gomovieapp.util.Event;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

public class ImageFeedViewHolder extends BaseFeedViewHolder implements FeedViewHolder{

    ImageView imgFeedObject;
    String imgObjectUrl ="";

    public ImageFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView, context, callback);
        imgFeedObject = (ImageView) itemView.findViewById(R.id.img_feed_object);
    }

    @Override
    public void fillFromFeed(Feed feed) {
        super.fillFromFeed(feed);
        if(feed.getPhoto() != null)
            imgObjectUrl = feed.getPhoto().getUrl();
        if(imgObjectUrl.startsWith("/")){
            imgObjectUrl = AppConstants.GOMOVIE_IMAGE_PREFIX + imgObjectUrl;
        }
        Log.d("Image Filling", imgObjectUrl);
    }

    public static RecyclerView.ViewHolder getInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_feed_layout, parent, false);
        return new ImageFeedViewHolder(itemView, context, callback);

    }
    public static RecyclerView.ViewHolder getSmallInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_feed_layout_small, parent, false);
        return new ImageFeedViewHolder(itemView, context, callback);

    }

    @Override
    public void bind() {
        super.bind();
        imgObjectUrl = imgObjectUrl.replace(" ", "%20");
        Log.d("Image", imgObjectUrl);
        if(imgObjectUrl != null && !imgObjectUrl.equals(""))
            Picasso.with(context).load(imgObjectUrl).into(imgFeedObject);
        imgFeedObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> context = new HashMap<String, Object>();
                context.put("photoUrl", imgObjectUrl);
                callback.onEvent(Event.IMAGE_CLICK, context);
            }
        });
    }
}
