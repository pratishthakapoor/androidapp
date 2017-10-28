package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.util.FeedObjectUtil;

/**
 * Created by tanmayvijayvargiya on 16/02/17.
 */
@NonReusable
@Layout(R.layout.feed_item)
public class FeedItem {

    @View(R.id.image_post_actor)
    CircleImageView actorImageView;

    @View(R.id.textview_post_actor)
    TextView actorNameTextView;

    @View(R.id.textview_post_time)
    TextView timeTextView;

    @View(R.id.textview_post_message)
    TextView messageTextView;

    @View(R.id.image_post_object)
    ImageView objectImageView;

    @View(R.id.image_post_like)
    ImageView likeImage;

    @View(R.id.button_post_comment)
    Button commentButton;

    @View(R.id.textview_post_likecount)
    TextView likecount;

    @View(R.id.textview_last_comment)
    TextView lastComment;

    @View(R.id.menu_button)
    ImageView menuButtonImage;

    private Callback callback;
    private Context context;
    private Feed feedItem;

    public FeedItem(Callback callback, Context context, Feed feedItem) {
        this.callback = callback;
        this.context = context;
        this.feedItem = feedItem;
    }

    @Resolve
    void onResolved(){
        if(feedItem == null)
            return;
        String objectType = feedItem.getObject().split(":")[0];
        setMainText(feedItem.getActorName(), feedItem.getVerb() +  "ed a", objectType);

        Picasso.with(context).load(R.drawable.profile_default).into(actorImageView);

//        if(feedItem.getTime() != null)
//            timeTextView.setText(DateTimeUtil.getReadableTimeFromISOstring(feedItem.getTime()));

        messageTextView.setText(feedItem.getMessage());

        if(objectType.equals("post") && feedItem.getPost() != null){
            objectImageView.setVisibility(android.view.View.GONE);
            messageTextView.setText(feedItem.getPost().getText());
        }
        else if (objectType.equals("picture") && feedItem.getPhoto() != null){
            String url = feedItem.getPhoto().getUrl();
            Log.d("PHOTO",feedItem.getPhoto().getUrl());
            if(url != null && url != "")
                Picasso.with(context).load(R.drawable.profile_default).into(objectImageView);
            //messageTextView.setVisibility(android.view.View.GONE);
        }
        else if(objectType.equals("video") && feedItem.getVideo() != null){
            String id = feedItem.getVideo().getUrl();
            if(FeedObjectUtil.isValidYoutubeId(id))
                Picasso.with(context).load(FeedObjectUtil.getThumbnailUrlFromId(id)).into(objectImageView);
        }

        objectImageView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                callback.onFeedObjectClick(feedItem);
            }
        });

        if(feedItem.isDoLike()){
            likeImage.setAlpha(1f);
        }
        likecount.setText(feedItem.getLikeCount() + " likes " + feedItem.getCommentCount() + " comments");

        if(feedItem.getLastComment() != null){
            setLastComment(feedItem.getLastComment().getUsername(), feedItem.getLastComment().getText());
        }
        likeImage.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                callback.onFeedLikeClick(feedItem);
            }
        });

        android.view.View.OnClickListener commentClickListener = new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                callback.onFeedCommentClick(feedItem);
            }
        };

        commentButton.setOnClickListener(commentClickListener);
        lastComment.setOnClickListener(commentClickListener);

        menuButtonImage.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                callback.onMenuItemClick(feedItem);
            }
        });

    }



    void setMainText(String actorName, String verb, String object){
        if(actorName == null || verb == null || object == null)
            return;
        final SpannableStringBuilder str = new SpannableStringBuilder(actorName + " " + verb + " " + object + ".");
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0,actorName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), actorName.length() + verb.length() + 2, actorName.length() + verb.length() + object.length() + 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actorNameTextView.setText(str);
    }

    void setLastComment(String username, String comment){
        final SpannableStringBuilder str = new SpannableStringBuilder(username + " " + comment);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0,username.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        lastComment.setText(str);
    }

    public interface Callback {
        void onFeedObjectClick(Feed feed);
        void onFeedActorClick(Feed feed);
        void onFeedLikeClick(Feed feed);
        void onFeedCommentClick(Feed feed);
        void onMenuItemClick(Feed feed);
    }

}
