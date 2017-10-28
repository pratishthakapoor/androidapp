package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.util.AppConstants;

/**
 * Created by tanmayvijayvargiya on 10/04/17.
 */

public class ReviewFeedViewHolder extends BaseFeedViewHolder implements FeedViewHolder {

    float rating = 0;
    String moviePosterUrl = "";

    AppCompatRatingBar ratingBar;
    ImageView moviePoster;
    ImageView reviewBackground;
    TextView movieName;
    TextView reviewContent;
    String movieNameString;
    String reviewContentString;

    private final boolean isSmall;

    public ReviewFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView, context, callback);
        ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.feed_ratingbar);
        moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
        reviewBackground = (ImageView) itemView.findViewById(R.id.review_background);
        isSmall = false;
    }
    public ReviewFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback, boolean isSmall) {
        super(itemView, context, callback);

        reviewBackground = (ImageView) itemView.findViewById(R.id.review_background);

        if(isSmall){
            movieName = (TextView) itemView.findViewById(R.id.review_heading);
            reviewContent = (TextView) itemView.findViewById(R.id.review_content);
            moviePoster = (ImageView) itemView.findViewById(R.id.review_image);
            ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.review_rating);

        }else{
            moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.feed_ratingbar);

        }

        this.isSmall = isSmall;
    }


    public static RecyclerView.ViewHolder getInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_feed_layout, parent, false);
        return new ReviewFeedViewHolder(itemView, context, callback);
    }
    public static RecyclerView.ViewHolder getSmallInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_feed_layout_small, parent, false);
        return new ReviewFeedViewHolder(itemView, context, callback,true);
    }

    @Override
    public void bind() {
        super.bind();
        ratingBar.setRating(rating);
        if(moviePosterUrl != null && !moviePosterUrl.equals("") && moviePoster != null){
            Picasso.with(context)
                    .load(moviePosterUrl)
                    .into(moviePoster);

            Picasso.with(context)
                    .load(moviePosterUrl)
                    .into(reviewBackground);
        }
        if(movieName != null){
            movieName.setText(movieNameString);
        }
        if(reviewContent != null){
            reviewContent.setText(reviewContentString);
        }
    }

    @Override
    public void fillFromFeed(Feed feed) {
        super.fillFromFeed(feed);
        if(feed.getReview() != null){
            rating = feed.getReview().getMovieRating();
            movieNameString = feed.getReview().getMovieName();
            reviewContentString = feed.getReview().getMovieReview();
            Log.d("Review", reviewContentString);
            if(feed.getReview().getMovieDefaultPhoto() != null){
                moviePosterUrl = feed.getReview().getMovieDefaultPhoto();
                moviePosterUrl = moviePosterUrl.replace(" ", "%20");
                if(moviePosterUrl.startsWith("/")){
                    moviePosterUrl = AppConstants.GOMOVIE_IMAGE_PREFIX + moviePosterUrl;
                }
            }
        }
    }
}
