package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.feedViewHolder.FeedViewHolder;
import in.co.gomovie.gomovieapp.util.Event;
import in.co.gomovie.gomovieapp.util.FeedViewTypeMapper;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Feed> feedList;
    Callback callback;
    Context context;

    public static final int AGGREGATED_MODE = 0;
    private static final int FLAT_MODE = 1;
    private int mode = 1;

    public FeedAdapter(List<Feed> feedList, Callback callback, Context context) {
        this.callback = callback;
        this.context = context;
        this.mode = FLAT_MODE;
        addToList(feedList);

    }

    public void setAggregatedMode(){
        this.mode = AGGREGATED_MODE;
    }

    public void setFlatMode(){
        this.mode = FLAT_MODE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mode == FLAT_MODE)
            return FeedViewTypeMapper.getFeedViewHolderInstance(parent,callback, context, viewType, false);
        else
            return FeedViewTypeMapper.getFeedViewHolderInstance(parent,callback, context, viewType, true);
    }

    @Override
    public int getItemViewType(int position) {

        Feed feed = feedList.get(position);
        if(feed == null){
            removeFeedAtPosition(position);
        }
        return FeedViewTypeMapper.getFeedType(feed);
    }

    private void removeFeedAtPosition(int position) {
        feedList.remove(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Feed feed = feedList.get(position);

        if(feed.getObject().startsWith("activity"))
            feed = feed.getActivity();
        FeedViewHolder feedViewHolder = (FeedViewHolder) holder;
        feedViewHolder.fillFromFeed(feed);
        feedViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        if(feedList == null){
            feedList = new ArrayList<Feed>();
        }
        return feedList.size();
    }

    public void addToList(Feed feed){
        if(feedList == null){
            feedList = new ArrayList<Feed>();
        }
        int type = FeedViewTypeMapper.getFeedType(feed);

        if(type != FeedViewTypeMapper.INVALID_FEED )
            feedList.add(feed);
    }

    public void addToList(List<Feed> feedList){

        if(feedList == null)
            return;
        for(Feed feed: feedList) {
            addToList(feed);
        }
        this.notifyDataSetChanged();
    }

    public interface Callback{
        public void onEvent(Event eventType, Map<String, Object> context);
    }
}
