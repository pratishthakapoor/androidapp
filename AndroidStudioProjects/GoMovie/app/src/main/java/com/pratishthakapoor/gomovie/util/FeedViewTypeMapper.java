package com.pratishthakapoor.gomovie.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.pratishthakapoor.gomovie.model.Feed;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedAdapter;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder.ImageFeedViewHolder;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder.ReviewFeedViewHolder;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder.VideoFeedViewHolder;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder.WantToWatchFeedViewHolder;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

public class FeedViewTypeMapper {
    public final static int VIDEO_FEED = 0;
    public final static int IMAGE_FEED = 1;
    public final static int REVIEW_FEED = 2;
    public final static int WANT_WATCH_FEED = 3;
    public final static int INVALID_FEED = -1;

    public static int getFeedType(Feed feed){
        String actorType = feed.getActorType();
        String objectType = feed.getObject().split(":")[0];
        if(objectType.equals("activity")){
            objectType = feed.getActivity().getObject().split(":")[0];
        }
        if(objectType.equals("picture")){
            return IMAGE_FEED;
        }
        if(objectType.equals("video")){
            return VIDEO_FEED;
        }
        if(objectType.equals("review") && feed.getReview() != null){
            return REVIEW_FEED;
        }
        if(feed.getVerb().equals("WANT_WATCH")){
            return WANT_WATCH_FEED;
        }

        return  INVALID_FEED;
    }

    public static RecyclerView.ViewHolder getFeedViewHolderInstance(ViewGroup parent, FeedAdapter.Callback callback, Context context, int feedType, boolean smallLayout){
        switch (feedType){
            case FeedViewTypeMapper.IMAGE_FEED:
                return smallLayout?ImageFeedViewHolder.getSmallInstance(parent,context,callback):
                        ImageFeedViewHolder.getInstance(parent, context, callback);
            case FeedViewTypeMapper.VIDEO_FEED:
                return smallLayout?VideoFeedViewHolder.getSmallInstance(parent,context,callback):
                        VideoFeedViewHolder.getInstance(parent, context, callback);
            case FeedViewTypeMapper.REVIEW_FEED:
                return smallLayout? ReviewFeedViewHolder.getSmallInstance(parent,context,callback):
                        ReviewFeedViewHolder.getInstance(parent, context, callback);
            case FeedViewTypeMapper.WANT_WATCH_FEED:
                return WantToWatchFeedViewHolder.getInstance(parent, context, callback);

            default:
                return ImageFeedViewHolder.getInstance(parent, context, callback);
        }
    }
}
