package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import de.hdodenhof.circleimageview.CircleImageView;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.model.FeedGroup;

/**
 * Created by tanmayvijayvargiya on 16/02/17.
 */
@NonReusable
@Layout(R.layout.feed_item)
public class FeedGroupItem {

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
    private FeedGroup feedGroup;

    public FeedGroupItem(Callback callback, Context context, FeedGroup feedGroup) {
        this.callback = callback;
        this.context = context;
        this.feedGroup = feedGroup;
    }

    @Resolve
    private void onResolved(){
        if(feedGroup == null)
            return;
        setMainText("Feed Count: "+ feedGroup.getFeedCount(), feedGroup.getVerb() +  "ed a","Actor Count:" + feedGroup.getActor_count());


        menuButtonImage.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                showMenuPopup();
            }
        });

    }

    private void showMenuPopup() {
        PopupMenu popup = new PopupMenu(context, menuButtonImage);
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.feed_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        popup.show();//showing popup menu
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
        void onMenuItemClick(Feed feed, int menu_id);
    }

}
