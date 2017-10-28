package com.pratishthakapoor.gomovie.ui.home.account;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.model.MovieOverview;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
@NonReusable
@Layout(R.layout.movie_item)
public class MovieItem {

    private Context context;
    private MovieOverview movieOverview;

    @View(R.id.movie_name)
    TextView movieName;

    @View(R.id.movie_poster)
    ImageView moviePoster;

    public MovieItem(Context context, MovieOverview movieOverview) {
        this.context = context;
        this.movieOverview = movieOverview;
    }

    @Resolve
    public void onResolved(){
        movieName.setText(movieOverview.getUrl());
        Picasso.with(context).load(movieOverview.getDefaultImage()).into(moviePoster);
    }
}
