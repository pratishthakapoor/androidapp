package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.util.Event;
import in.co.gomovie.gomovieapp.util.FeedObjectUtil;

/**
 * Created by tanmayvijayvargiya on 14/06/17.
 */

@Layout(R.layout.aggregate_feed_item)
public class AggregatedFeedItem {

    @View(R.id.feed_container)
    RecyclerView recyclerView;

    @View(R.id.img_feed_actor)
    ImageView feedActor;

    @View(R.id.txt_feed_title)
    TextView feedTitle;
    @View(R.id.txt_feed_message)
    TextView feedMessage;

    List<Feed> feedList;
    FeedAdapter.Callback callback;
    Context context;
    FeedAdapter feedAdapter;
    LinearLayoutManager llm;
    public AggregatedFeedItem(List<Feed> feedList, FeedAdapter.Callback callback, Context context) {
        this.feedList = feedList;
        this.callback = callback;
        this.context = context;
        feedAdapter = new FeedAdapter(feedList, callback, context);
        feedAdapter.setAggregatedMode();
        llm = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

    }

    @Resolve
    public void resolve(){
        String actorName = feedList.get(0).getActorName();
        String verb = feedList.get(0).getVerb();
        String pictureUrl = feedList.get(0).getActorPhotoUrl();

        feedTitle.setText(actorName + " " + FeedObjectUtil.getStringFromVerb(verb, String.valueOf(feedList.size())));

        feedMessage.setVisibility(android.view.View.GONE);

        feedTitle.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Map<String, Object> context = new HashMap<String, Object>();
                Log.d("Account", "User title clicked!");
                if(feedList.get(0).getActor() != null)
                    context.put("userId", feedList.get(0).getActor().split(":")[1]);
                callback.onEvent(Event.USER_TITLE_CLICK, context);
            }
        });
        if(pictureUrl != null && !pictureUrl.equals(""))
            Picasso.with(context).load(pictureUrl).into(feedActor);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(feedAdapter);
    }
}
