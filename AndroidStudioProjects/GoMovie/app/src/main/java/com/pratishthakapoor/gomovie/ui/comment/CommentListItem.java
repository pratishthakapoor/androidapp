package com.pratishthakapoor.gomovie.ui.comment;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.model.Comment;
import com.pratishthakapoor.gomovie.util.DateTimeUtil;

/**
 * Created by tanmayvijayvargiya on 15/06/17.
 */

@Layout(R.layout.comment_item)
public class CommentListItem {
    Comment comment;
    CommentCallback callback;
    Context context;

    @View(R.id.user_profile)
    ImageView userProfile;

    @View(R.id.textview_comment_text)
    TextView commentText;

    @View(R.id.textview_comment_user_time)
    TextView commentUserTimeText;

    public CommentListItem(Comment comment, CommentCallback callback, Context context) {
        this.comment = comment;
        this.callback = callback;
        this.context = context;
    }


    @Resolve
    public void resolve(){
        if(comment.getActorPhotoUrl() != null || comment.getActorPhotoUrl().equals(""))
            Picasso.with(context).load(comment.getActorPhotoUrl()).into(userProfile);
        if(comment.getActorPhotoUrl() != null){
            commentUserTimeText.setText(comment.getActorName() + " | " + DateTimeUtil.getReadableTimeFromISOstring(comment.getTime()));
        }
        if(comment.getMessage() != null){
            commentText.setText(comment.getMessage());
        }
    }
}
