package com.pratishthakapoor.gomovie.ui.home.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.data.network.response.ReviewOverview;
import com.pratishthakapoor.gomovie.data.network.response.UserInfoResponse;
import com.pratishthakapoor.gomovie.ui.base.BaseFragment;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsPresenter;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsView;
import com.pratishthakapoor.gomovie.util.AppConstants;

public class AccountFragment extends BaseFragment implements AccountView {

    private OnFragmentInteractionListener mListener;

    @Inject
    AccountPresenter<AccountView> presenter;

    @Inject
    FeedsPresenter<FeedsView> feedsPresenter;

    @BindView(R.id.user_name)
    TextView username;
    @BindView(R.id.user_profile)
    ImageView profilePicture;

    @BindView(R.id.wishlist_count)
    TextView wishlistCount;

    @BindView(R.id.seenlist_count)
    TextView seenListCount;

    @BindView(R.id.followers_count)
    TextView followersCount;

    @BindView(R.id.following_count)
    TextView followingCount;

    @BindView(R.id.review_container)
    LinearLayout reviewContainer;

    private static String ARG_USER_ID = "user_id";
    String userId;
    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account, container, false);
        getActivityComponent().inject(this);

        ButterKnife.bind(this,view);
        Bundle args = getArguments();
        if(args != null){
            userId = getArguments().getString(ARG_USER_ID);
            presenter.setUserId(userId);
        }
        wishlistCount = (TextView) view.findViewById(R.id.wishlist_count);
        presenter.onAttach(this);

        return view;
    }

    public static AccountFragment getInstance(String userId){
        Bundle bundle  = new Bundle();
        bundle.putString(ARG_USER_ID, userId);
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setPresenter(AccountPresenter<AccountView> presenter){
        this.presenter = presenter;
    }

    @Override
    public void setUserInfo(UserInfoResponse user) {
        Picasso.with(getContext())
                .load(user.getProfilePicture())
                .into(profilePicture);
        username.setText(user.getUserName());

        seenListCount.setText(user.getSeenList().size() + "");
        wishlistCount.setText(user.getWishList().size() + "");
        followersCount.setText(user.getFollowers().size() + "");
        followingCount.setText(user.getFollowings().size()+ "");
    }

    @Override
    public void setReviews(List<ReviewOverview> reviews) {
        reviewContainer.removeAllViews();
        for(ReviewOverview review:reviews){
            View layout2 = LayoutInflater.from(getContext()).inflate(R.layout.review_list_item_layout, reviewContainer, false);

            ImageView reviewImage = (ImageView) layout2.findViewById(R.id.review_image);
            TextView reviewHeading = (TextView) layout2.findViewById(R.id.review_heading);
            TextView reviewContent = (TextView) layout2.findViewById(R.id.review_content);
            AppCompatRatingBar reviewRating = (AppCompatRatingBar) layout2.findViewById(R.id.review_rating);

            if(reviewImage != null){
                if(review.getMovieDefaultPhoto().startsWith("/"))
                    review.setMovieDefaultPhoto(AppConstants.GOMOVIE_IMAGE_PREFIX + review.getMovieDefaultPhoto());
                Picasso.with(getContext()).load(review.getMovieDefaultPhoto())
                        .into(reviewImage);
            }
            reviewHeading.setText(review.getMovieName());
            reviewContent.setText(review.getMovieReview());
            reviewRating.setRating(review.getMovieRating());

            reviewContainer.addView(layout2);
        }
    }



    public interface OnFragmentInteractionListener {

    }
}
