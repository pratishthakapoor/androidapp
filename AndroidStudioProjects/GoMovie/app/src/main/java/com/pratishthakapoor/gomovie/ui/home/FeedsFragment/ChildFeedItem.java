package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.content.Context;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

@Layout(R.layout.feed_item)
public class ChildFeedItem extends FeedItem{

    public ChildFeedItem(Callback callback, Context context, Feed feedItem) {
        super(callback, context, feedItem);
        feedItem.setVerb("Fucked");
    }

    @Override
    @Resolve
    void onResolved() {
        super.onResolved();
    }
}
