package com.pratishthakapoor.gomovie.ui.home.FeedContainerFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.ui.base.BaseFragment;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsFragment;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsPresenter;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsView;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder.FollowingFeedFragment;
import com.pratishthakapoor.gomovie.util.AppConstants;
import com.pratishthakapoor.gomovie.util.ViewPagerAdapter;


public class FeedContainerFragment extends BaseFragment {

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Inject
    FeedsPresenter<FeedsView> feedsPresenter1;
    @Inject
    FeedsPresenter<FeedsView> feedsPresenter2;

    public FeedContainerFragment() {
        // Required empty public constructor
    }

    public static FeedContainerFragment newInstance() {
        FeedContainerFragment fragment = new FeedContainerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_container, container, false);
        getActivityComponent().inject(this);
        ButterKnife.bind(this, view);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        FeedsFragment movieFeedFragment = new FeedsFragment();
        feedsPresenter1.setMode(AppConstants.MOVIE_FEED_MODE);
        movieFeedFragment.setPresenter(feedsPresenter1);
        adapter.addFragment(movieFeedFragment, "Movie Feed");

        FollowingFeedFragment followingFeedFragment = new FollowingFeedFragment();
        feedsPresenter2.setMode(AppConstants.FOLLOWING_MODE);
        followingFeedFragment.setPresenter(feedsPresenter2);
        adapter.addFragment(followingFeedFragment, "Following Feed");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
