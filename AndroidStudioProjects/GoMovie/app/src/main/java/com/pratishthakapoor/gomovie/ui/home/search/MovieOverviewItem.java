package com.pratishthakapoor.gomovie.ui.home.search;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.data.network.response.SearchResponse;
import in.co.gomovie.gomovieapp.util.AppConstants;

/**
 * Created by tanmayvijayvargiya on 08/04/17.
 */


@Layout(R.layout.movie_overview)
public class MovieOverviewItem {
    private SearchResponse.MovieOverview movie;
    private Context context;

    private Callback callback;

    @View(R.id.poster_image_view)
    ImageView posterImageView;
    @View(R.id.name_text_view)
    TextView nameTextView;
    @View(R.id.follow_button)
    Button followButton;

    public MovieOverviewItem(SearchResponse.MovieOverview movie, Context context, Callback callback) {
        this.movie = movie;
        this.context = context;
        this.callback = callback;
    }

    @Resolve
    void onResolve(){
        Picasso.with(context).load(AppConstants.GOMOVIE_IMAGE_PREFIX+movie.moviePosterUrl)
                .into(posterImageView);
        nameTextView.setText(movie.movieName);

    }

    public interface Callback{
        void onFollowClick(SearchResponse.MovieOverview movieOverview);
        void onItemClick(SearchResponse.MovieOverview movieOverview);
    }
}
