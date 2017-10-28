package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import java.util.Map;

import in.co.gomovie.gomovieapp.ui.base.MvpPresenter;
import in.co.gomovie.gomovieapp.util.Event;

/**
 * Created by tanmayvijayvargiya on 17/02/17.
 */
public interface FeedsPresenter<V extends FeedsView> extends MvpPresenter<V>{
    void addToWishList(String movieId);
    void addToSeenList(String movieId);
    void removeFromWishList(String movieId);
    void removeFromSeenList(String movieId);
    void setMode(String mode);
    void onEvent(Event event, Map<String, Object> context);
    void endOfListReached();
}
