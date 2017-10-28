package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.gomovie.gomovieapp.GomovieApplication;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.data.DataManager;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.model.FeedGroup;
import in.co.gomovie.gomovieapp.ui.base.BaseFragment;
import in.co.gomovie.gomovieapp.ui.comment.CommentActivity;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.AggregatedFeedItem;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedsFragment;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedsPresenter;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedsView;
import in.co.gomovie.gomovieapp.ui.home.review.WriteReviewActivity;
import in.co.gomovie.gomovieapp.ui.youtube.YoutubeActivity;
import in.co.gomovie.gomovieapp.util.Event;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowingFeedFragment extends BaseFragment implements FeedsView, FeedAdapter.Callback {


    FeedsPresenter<FeedsView> presenter;
    public FollowingFeedFragment() {
        // Required empty public constructor
    }

    FeedsFragment.Interactor interactor;
    View view;
    @BindView(R.id.following_feed_container)
    PlaceHolderView followingFeedContainer;
    DataManager dm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_following_feed, container, false);
        ButterKnife.bind(this,view);
        if(presenter != null){
            presenter.onAttach(this);
        }
        dm = ((GomovieApplication)getActivity().getApplication()).getDataManager();
        return  view;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.interactor = null;
    }

    @Override
    public void addFeeds(List<Feed> feeds) {

    }

    @Override
    public void addFeedGroups(List<FeedGroup> feedGroups) {

        for(FeedGroup fg:feedGroups)
            followingFeedContainer.addView(new AggregatedFeedItem(fg.getFeeds(),FollowingFeedFragment.this, FollowingFeedFragment.this.getContext()));
    }

    @Override
    public void setPresenter(FeedsPresenter<FeedsView> presenter) {
        this.presenter = presenter;
    }

    @Override
    public void openReviewActivity(String movieId, String movieName) {
        startActivity(WriteReviewActivity.getStartIntent(movieId, movieName, 0.0f, getContext()));
    }

    @Override
    public void playVideo(String videoId) {
        startActivity(YoutubeActivity.getStartIntent(getContext(), videoId));
    }

    @Override
    public void showCommentActivity(String foreign_id) {
        startActivity(CommentActivity.getStartIntent(foreign_id, this.getActivity()));
    }

    @Override
    public void showUserAccountFragment(String userId) {
        if(interactor != null){
            interactor.showAccountFragment(userId);
        }
    }



    @Override
    public void onEvent(Event eventType, Map<String, Object> context) {
        presenter.onEvent(eventType, context);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interactor = (FeedsFragment.Interactor) context;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        interactor = (FeedsFragment.Interactor) context;
    }

}
