package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.model.FeedGroup;
import in.co.gomovie.gomovieapp.ui.base.BaseFragment;
import in.co.gomovie.gomovieapp.ui.comment.CommentActivity;
import in.co.gomovie.gomovieapp.ui.home.review.WriteReviewActivity;
import in.co.gomovie.gomovieapp.ui.youtube.YoutubeActivity;
import in.co.gomovie.gomovieapp.util.Event;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedsFragment extends BaseFragment implements FeedsView, FeedAdapter.Callback {

    FeedsPresenter<FeedsView> presenter;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @BindView(R.id.feed_recycler_view)
    RecyclerView recyclerView;
    FeedAdapter feedAdapter;
    LinearLayoutManager mLayoutManager;
    Interactor interactor;
    public FeedsFragment() {
    }
    long lastAction = new Date().getTime();
    boolean scrollDown = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        feedAdapter = new FeedAdapter(new ArrayList<Feed>(), this, getContext());
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(dy > 0) //check for scroll down
                {
                    if(interactor != null && checkForTime() && !scrollDown){
                        scrollDown = true;
                        interactor.hiderActionBar();
                    }
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
                    Log.d("Values",visibleItemCount + " +" + totalItemCount + ">= " + pastVisiblesItems);
                    if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                    {
                        loading = false;
                        presenter.endOfListReached();
                    }

                }else{
                    if(interactor != null && checkForTime() && scrollDown){
                        scrollDown = false;
                        interactor.showActionBar();
                    }
                }
            }
        });
        if(presenter != null){
            presenter.onAttach(this);
        }
        return view;

    }

    private boolean checkForTime() {
        long now = new Date().getTime();
        long diff = now - lastAction;
        if(diff > 500){
            lastAction = now;
            return true;
        }
        else
            return false;
    }

    @Override
    public void addFeeds(List<Feed> feeds) {
        Log.d("feed", "Adding " + feeds.size());
        if(feedAdapter != null)
            feedAdapter.addToList(feeds);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactor = null;
    }

    @Override
    public void addFeedGroups(List<FeedGroup> feedGroups) {

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
        //this.getActivity().finish();
    }

    @Override
    public void showUserAccountFragment(String userId) {
        if(interactor != null)
            interactor.showAccountFragment(userId);
    }

    @Override
    public void onEvent(Event eventType, Map<String, Object> context) {
        presenter.onEvent(eventType, context);
    }

    public interface Interactor{
        void hiderActionBar();
        void showActionBar();
        void showAccountFragment(String userId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interactor = (Interactor) context;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        interactor = (Interactor) context;
    }


}
