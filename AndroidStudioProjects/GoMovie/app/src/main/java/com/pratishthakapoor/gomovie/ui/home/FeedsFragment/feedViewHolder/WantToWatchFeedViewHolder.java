package com.pratishthakapoor.gomovie.ui.home.FeedsFragment.feedViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedAdapter;
import in.co.gomovie.gomovieapp.util.AppConstants;
import in.co.gomovie.gomovieapp.util.Event;

/**
 * Created by tanmayvijayvargiya on 15/06/17.
 */

public class WantToWatchFeedViewHolder extends BaseFeedViewHolder implements FeedViewHolder{
    String moviePosterUrl;
    ImageView imgObject;
    ImageView imgBgObject;
    TextView movieName;

    String movieNameText;

    public WantToWatchFeedViewHolder(View itemView, Context context, FeedAdapter.Callback callback) {
        super(itemView, context, callback);
        imgObject = (ImageView) itemView.findViewById(R.id.movie_poster);
        imgBgObject = (ImageView) itemView.findViewById(R.id.movie_background);
        movieName = (TextView) itemView.findViewById(R.id.movie_name);
    }

    public static RecyclerView.ViewHolder getInstance(ViewGroup parent, Context context, FeedAdapter.Callback callback){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.want_to_watch_feed_layout_small, parent, false);
        return new WantToWatchFeedViewHolder(itemView, context, callback);
    }

    @Override
    public void bind() {
        super.bind();
        moviePosterUrl = moviePosterUrl.replace(" ", "%20");
        if(moviePosterUrl != null && !moviePosterUrl.equals("") && imgObject != null){
            Picasso.with(context).load(moviePosterUrl).into(imgObject);
            Picasso.with(context).load(moviePosterUrl).into(imgBgObject);
        }

        if(movieName != null){
            movieName.setText(movieNameText);
        }
        imgObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> context = new HashMap<String, Object>();
                context.put("photoUrl", moviePosterUrl);
                callback.onEvent(Event.IMAGE_CLICK, context);
            }
        });
    }

    @Override
    public void fillFromFeed(Feed feed) {
        super.fillFromFeed(feed);
        if(feed != null){
            if(feed.getMovie() != null){
                moviePosterUrl = feed.getMovie().getPosterImage();
                moviePosterUrl = moviePosterUrl == null? "" : moviePosterUrl;
                Log.d("MoviePoster", moviePosterUrl);
                if(moviePosterUrl.startsWith("/")){
                    moviePosterUrl = AppConstants.GOMOVIE_IMAGE_PREFIX + moviePosterUrl;
                }
                movieNameText = feed.getMovie().getName();
            }
        }
    }
}
