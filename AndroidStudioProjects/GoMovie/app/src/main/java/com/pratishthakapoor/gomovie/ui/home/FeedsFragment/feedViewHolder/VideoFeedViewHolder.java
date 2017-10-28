package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.util.Event;
import in.co.gomovie.gomovieapp.util.FeedObjectUtil;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

public class VideoFeedViewHolder extends ImageFeedViewHolder implements FeedViewHolder {

    public VideoFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView, context, callback);
    }

    public static RecyclerView.ViewHolder getInstance(ViewGroup parent,
                                                      Context context,
                                                      FeedAdapter.Callback callback){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_feed_layout, parent,false);
        return new VideoFeedViewHolder(itemView, context, callback);
    }
    public static RecyclerView.ViewHolder getSmallInstance(ViewGroup parent,
                                                      Context context,
                                                      FeedAdapter.Callback callback){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_feed_layout_small, parent,false);
        return new VideoFeedViewHolder(itemView, context, callback);
    }

    @Override
    public void fillFromFeed(Feed feed) {
        super.fillFromFeed(feed);
        if(feed.getVideo() != null)
            imgObjectUrl = FeedObjectUtil.getThumbnailUrlFromId(feed.getVideo().getUrl());
    }

    @Override
    public void bind() {
        super.bind();
        imgFeedObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> context = new HashMap<String, Object>();
                context.put("videoId", feed.getVideo().getUrl());
                callback.onEvent(Event.VIDEO_CLICK, context);
            }
        });
    }
}
