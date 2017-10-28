package com.pratishthakapoor.gomovie.ui.review;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.PlaceHolderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.ui.base.BaseFragment;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public class ReviewListFragment extends BaseFragment implements ReviewListView {

    @BindView(R.id.review_container)
    PlaceHolderView reviewContainer;

    @Inject
    ReviewListPresenter<ReviewListView> presenter;
    String userId;
    String movieId;
    private static String ARG_USER_ID = "user_id";
    private static String ARG_MOVIE_ID = "movie_id";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_list_layout, container, false);
        ButterKnife.bind(this,view);
        getActivityComponent().inject(this);

        presenter.onAttach(this);

        Bundle args = getArguments();
        if(args != null){
            String userId = args.getString(ARG_USER_ID);
            String movieId = args.getString(ARG_MOVIE_ID);
        }
        return view;
    }

    public static ReviewListFragment getInstance(String userId, String movieId){
        Bundle bundle  = new Bundle();
        bundle.putString(ARG_USER_ID, userId);
        if(movieId != null){
            bundle.putString(ARG_MOVIE_ID, movieId);
        }
        ReviewListFragment fragment = new ReviewListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
