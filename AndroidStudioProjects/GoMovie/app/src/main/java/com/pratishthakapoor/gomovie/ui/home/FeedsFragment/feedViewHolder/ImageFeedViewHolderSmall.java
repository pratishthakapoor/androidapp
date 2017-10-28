package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
 * Created by tanmayvijayvargiya on 14/06/17.
 */

public class ImageFeedViewHolderSmall extends RecyclerView.ViewHolder implements FeedViewHolder  {
    ImageView likeButton;
    Button commentButton;

    String imgObjectUrl;
    ImageView imgFeedObject;

    FeedAdapter.Callback callback;
    Context context;

    public ImageFeedViewHolderSmall(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;

        likeButton = (ImageView) itemView.findViewById(R.id.button_like);
        commentButton = (Button) itemView.findViewById(R.id.button_comment);
        imgFeedObject = (ImageView) itemView.findViewById(R.id.image_post_object);
    }

    public void fillFromFeed(Feed feed){
        if(feed.getPhoto() != null)
            imgObjectUrl = feed.getPhoto().getUrl();
        if(imgObjectUrl.startsWith("/")){
            imgObjectUrl = AppConstants.GOMOVIE_IMAGE_PREFIX + imgObjectUrl;
        }
    }
    public static RecyclerView.ViewHolder getInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_feed_layout_small, parent, false);
        return new ImageFeedViewHolderSmall(itemView, context, callback);

    }

    public void bind(){
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
