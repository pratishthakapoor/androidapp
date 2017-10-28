package com.pratishthakapoor.gomovie.ui.comment;

import com.pratishthakapoor.gomovie.ui.base.MvpPresenter;
import com.pratishthakapoor.gomovie.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 15/06/17.
 */

public interface CommentPresenter<V extends CommentView & MvpView> extends MvpPresenter<V>{
    void publishComment(String comment);
    void endOfListReached();
    void getComments();
}
