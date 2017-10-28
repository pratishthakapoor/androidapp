package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.util.AppConstants;
import in.co.gomovie.gomovieapp.util.Event;
import in.co.gomovie.gomovieapp.util.FeedObjectUtil;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

public abstract class BaseFeedViewHolder extends RecyclerView.ViewHolder {

    TextView feedTitle;
    TextView feedTimeStamp;
    ImageView feedActor;
    ImageView feedMenuButton;
    TextView feedMessage;
    LikeButton likeButton;
    ImageButton commentButton;
    TextView lastCommentTextView;

    String message = "";
    String actorName="";
    String objectType ="";
    String verb ="";
    String timeStamp ="";
    boolean doLike = false;
    String pictureUrl ="";
    String lastComment = "No Comment";
    Feed feed;
    FeedAdapter.Callback callback;

    Context context;
    public BaseFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView);
        feedTitle = (TextView) itemView.findViewById(R.id.txt_feed_title);
        feedActor = (ImageView) itemView.findViewById(R.id.img_feed_actor);
        feedMenuButton = (ImageView) itemView.findViewById(R.id.img_feed_menu);
        feedMessage = (TextView) itemView.findViewById(R.id.txt_feed_message);
        likeButton = (LikeButton) itemView.findViewById(R.id.button_like);
        commentButton = (ImageButton
                ) itemView.findViewById(R.id.button_comment);
        lastCommentTextView = (TextView) itemView.findViewById(R.id.feed_last_comment);
        this.context = context;
        this.callback = callback;
    }

    public void bind(){
        if(feedTitle != null && feedMessage != null && feedMenuButton != null){
            feedTitle.setText(actorName + " " + FeedObjectUtil.getStringFromVerb(verb) + objectType);
            if(message != null && message != ""){
                feedMessage.setVisibility(View.VISIBLE);
                feedMessage.setText(message);
            }
            else{
                feedMessage.setVisibility(View.GONE);
            }

            if(pictureUrl != null && !pictureUrl.equals(""))
                Picasso.with(context).load(pictureUrl).into(feedActor);
        }

        if(lastCommentTextView != null)
            lastCommentTextView.setText(lastComment);

        if(likeButton != null)
            likeButton.setLiked(doLike);

        handleListners();

    }

    private void handleListners() {
        if(feed != null){
            final Map<String, Object> context = new HashMap<String, Object>();
            final Event event;
            final Event menuEvent;

            if(feed.getActorType().equals("movie")){
                context.put("movieId", feed.getActor().split(":")[1]);
                context.put("movieName", feed.getActorName());
                event = Event.MOVIE_TITLE_CLICK;
                menuEvent = Event.MOVIE_MENU_CLICK;
            }else
            if(feed.getActorType().equals("user")){
                context.put("userId", feed.getActor().split(":")[1]);
                event = Event.USER_TITLE_CLICK;
                menuEvent = Event.USER_MENU_CLICK;
            }else {
                event = null;
                menuEvent = null;
            }
            if(feedTitle != null && feedMenuButton != null){
                feedTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.onEvent(event, context);
                    }
                });
                feedMenuButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.onEvent(menuEvent, context);
                    }
                });
            }

            if(likeButton != null && commentButton != null){
                likeButton.setOnLikeListener(new OnLikeListener() {
                    @Override
                    public void liked(LikeButton likeButton) {
                        context.put("foreign_id", feed.getForeignId());
                        callback.onEvent(Event.LIKE_FEED,context);
                        feed.setDoLike(true);
                    }

                    @Override
                    public void unLiked(LikeButton likeButton) {
                        context.put("foreign_id", feed.getForeignId());
                        callback.onEvent(Event.UNLIKE_FEED,context);
                        feed.setDoLike(false);
                    }
                });


                commentButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.put("foreign_id", feed.getForeignId());
                        callback.onEvent(Event.COMMENT_CLICK,context);
                    }
                });
            }

        }
    }

    public void fillFromFeed(Feed feed){
        if(feed != null){
            this.feed = feed;
            actorName = feed.getActorName();
            pictureUrl = feed.getActorPhotoUrl();

            if(pictureUrl == null){
                pictureUrl = "";
            }

            if(pictureUrl.startsWith("/")){
                pictureUrl = AppConstants.GOMOVIE_IMAGE_PREFIX + pictureUrl;
            }
            pictureUrl = pictureUrl.replace(" ", "%20");

            verb = feed.getVerb();
            doLike = feed.isDoLike();
            objectType = feed.getObject().split(":")[0];
            if(feed.getMessage() != null){
                message = feed.getMessage();
            }
            if(feed.getLastComment() != null){
                lastComment = feed.getLastComment().getUsername() + ": " + feed.getLastComment().getText();
                if(lastComment.length() > 50){
                    lastComment = lastComment.substring(0,45) + "...";
                }
            }else{
                lastComment = "No Comments";
            }
        }
    }


}
