package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.util.FeedViewTypeMapper;

/**
 * Created by tanmayvijayvargiya on 15/06/17.
 */

public class ActivityFeedViewHolder extends BaseFeedViewHolder{

    Feed feed;
    public ActivityFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView, context, callback);
    }

    @Override
    public void bind() {

    }

    public static RecyclerView.ViewHolder getInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback, Feed activity){
        int feedType = FeedViewTypeMapper.getFeedType(activity);
        switch (feedType){
            case FeedViewTypeMapper.IMAGE_FEED:
                return ImageFeedViewHolder.getInstance(parent, context, callback);

            case FeedViewTypeMapper.VIDEO_FEED:
                Log.d("Feed", "Sending a video");
                return VideoFeedViewHolder.getInstance(parent, context, callback);
            case FeedViewTypeMapper.REVIEW_FEED:
                Log.d("Feed", "Sending a Review");
                return ReviewFeedViewHolder.getInstance(parent, context, callback);
            case FeedViewTypeMapper.WANT_WATCH_FEED:
                return WantToWatchFeedViewHolder.getInstance(parent, context, callback);

            default:
                return ImageFeedViewHolder.getInstance(parent, context, callback);
        }
    }
    @Override
    public void fillFromFeed(Feed feed) {
        this.feed = feed;
    }
}
