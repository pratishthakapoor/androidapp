package com.pratishthakapoor.gomovie.ui.movieInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.data.network.response.MovieInfoResponse;
import com.pratishthakapoor.gomovie.ui.base.BaseActivity;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsFragment;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsPresenter;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsView;
import com.pratishthakapoor.gomovie.util.AppConstants;
import com.pratishthakapoor.gomovie.util.MenuComponent;
import com.pratishthakapoor.gomovie.util.ViewPagerAdapter;

public class MovieInfoActivity extends BaseActivity implements MovieInfoView {

    @Inject
    MovieInfoPresenter<MovieInfoView> presenter;
    @Inject
    FeedsPresenter<FeedsView> presenter1;
    @Inject
    FeedsPresenter<FeedsView> presenter2;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbar_layout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.cover_image)
    ImageView coverImage;
    @BindView(R.id.writers)
    TextView writers;
    @BindView(R.id.cast)
    TextView cast;
    @BindView(R.id.directors)
    TextView directors;
    @BindView(R.id.genre)
    TextView genre;
    @BindView(R.id.runtime)
    TextView runtime;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.synopsis)
    TextView synopsis;
    private static String ARG_MOVIE_ID = "ARG_MOVIE_ID";
    private String movieId;
    List<MenuComponent> menuList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getActivityComponent().inject(this);
        movieId = getIntent().getStringExtra(ARG_MOVIE_ID);
        presenter.onAttach(this);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        FeedsFragment movieFeedFragment = new FeedsFragment();
        presenter1.setMode(AppConstants.MOVIE_FEED_MODE);
        movieFeedFragment.setPresenter(presenter1);
        adapter.addFragment(movieFeedFragment, "My Feed");
        FeedsFragment timelineFragment = new FeedsFragment();
        presenter2.setMode(AppConstants.TIMELINE_MODE);
        timelineFragment.setPresenter(presenter2);
        adapter.addFragment(timelineFragment, "Timeline");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        if(movieId != null){
            presenter.setMovieId(movieId);
        }


    }

    public static Intent getStartIntent(String movieId, Context context){
        Intent i = new Intent(context, MovieInfoActivity.class);
        i.putExtra(ARG_MOVIE_ID, movieId);
        return i;
    }

    @Override
    public void setMovieInfo(MovieInfoResponse movieInfoResponse) {
        updateView(movieInfoResponse);
    }

    private void updateView(MovieInfoResponse movieInfoResponse) {
        Log.d("MovieInfo","Name:" + movieInfoResponse.getName());
        Log.d("MovieInfo","Genre:" + movieInfoResponse.getGenres());
        toolbar_layout.setTitle(movieInfoResponse.getName());
        Picasso.with(getApplicationContext()).load(AppConstants.GOMOVIE_IMAGE_PREFIX + movieInfoResponse.getDefaultImage())
                .into(coverImage);
        String castText = "Actors: ";
        String writerText = "Actors: ";
        String directorText = "Actors: ";
        if(movieInfoResponse.getParties() != null){
            if(movieInfoResponse.getParties().actors != null)
                for(String actorString: movieInfoResponse.getParties().actors)
                    castText += actorString + ", ";
            if(movieInfoResponse.getParties().writers != null)
                for(String writerString: movieInfoResponse.getParties().writers)
                    writerText += writerString+ ", ";
            if(movieInfoResponse.getParties().directors != null)
                for(String directorString: movieInfoResponse.getParties().directors)
                    directorText += directorString + ", ";
        }
        cast.setText(castText);
        directors.setText(directorText);
        writers.setText(writerText);
        synopsis.setText(movieInfoResponse.getSynopsis());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.follow_select,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_follow :

                    break;
                case R.id.menu_skip:
                    hideMenuOverlay();
                    break;
            }
            return super.onOptionsItemSelected(item);

    }
}
