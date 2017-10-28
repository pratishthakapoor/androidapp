package com.pratishthakapoor.gomovie.ui.comment;

import java.util.List;

import com.pratishthakapoor.gomovie.model.Comment;
import com.pratishthakapoor.gomovie.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 15/06/17.
 */

public interface CommentView extends MvpView{
    public void addComment(List<Comment> comment);
    public String getForeignId();
    public void onPublish();
}
