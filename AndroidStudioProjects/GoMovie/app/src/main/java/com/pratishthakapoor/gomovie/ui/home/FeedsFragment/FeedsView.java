package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import java.util.List;

import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.model.FeedGroup;
import in.co.gomovie.gomovieapp.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 17/02/17.
 */
public interface FeedsView extends MvpView{
    void addFeeds(List<Feed> feeds);
    void addFeedGroups(List<FeedGroup> feedGroups);
    void setPresenter(FeedsPresenter<FeedsView> presenter);
    void openReviewActivity(String movieId, String movieName);
    void playVideo(String videoId);
    void showCommentActivity(String foreign_id);
    void showUserAccountFragment(String userId);
}
