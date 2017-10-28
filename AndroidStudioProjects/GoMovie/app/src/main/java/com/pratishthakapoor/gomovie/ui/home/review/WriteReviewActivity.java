package com.pratishthakapoor.gomovie.ui.home.review;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.ui.base.BaseActivity;

public class WriteReviewActivity extends BaseActivity implements WriteReviewView {

    String movieName;
    String movieId;
    float rating;

    @Inject
    WriteReviewPresenter<WriteReviewView> presenter;
    @BindView(R.id.title_text_view)
    TextView titleTextView;
    @BindView(R.id.review_edit_text)
    EditText reviewEditText;
    @BindView(R.id.rating_bar)
    AppCompatRatingBar ratingBar;
    @BindView(R.id.publish_button)
    Button publishButton;
    public static String ARG_MOVIE_NAME = "movie_name";
    public static String ARG_MOVIE_ID = "movie_id";
    public static String ARG_MOVIE_RATING = "movie_rating";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
        Intent i = getIntent();
        movieId = i.getStringExtra(ARG_MOVIE_ID);
        movieName = i.getStringExtra(ARG_MOVIE_NAME);
        rating = i.getFloatExtra(ARG_MOVIE_RATING, 0.0f);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        presenter.onAttach(this);

        titleTextView.setText(movieName + " Review");
        ratingBar.setRating(rating);
        ratingBar.setIsIndicator(false);
        reviewEditText.requestFocus();

    }

    public static Intent getStartIntent(String movieId, String movieName, float defaultRating, Context context){
        Intent i = new Intent(context, WriteReviewActivity.class);
        i.putExtra(ARG_MOVIE_ID, movieId);
        i.putExtra(ARG_MOVIE_NAME, movieName);
        i.putExtra(ARG_MOVIE_RATING, defaultRating);
        return i;
    }

    @OnClick(R.id.publish_button)
    public void publish(View v){
        Log.d("Review",reviewEditText.getText().toString());
        Log.d("Review",movieId);
        Log.d("Review"," " + ratingBar.getRating());
        presenter.setMovieId(movieId);
        presenter.onRatingChange(ratingBar.getRating());
        presenter.onReviewChange(reviewEditText.getText().toString());
        presenter.onPublishRequest();
    }

    @Override
    public void exit() {
        finish();
    }
}
