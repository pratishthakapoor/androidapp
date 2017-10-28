package com.pratishthakapoor.gomovie.ui.home.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.data.network.response.SearchResponse;
import in.co.gomovie.gomovieapp.ui.base.BaseActivity;

import static com.raizlabs.android.dbflow.config.FlowManager.getContext;

public class SearchActivity extends BaseActivity implements SearchView,MovieOverviewItem.Callback,
UserOverviewItem.Callback{

    @Inject
    SearchPresenter<SearchView> presenter;

    @BindView(R.id.search_edit_text)
    EditText searchText;
    @BindView(R.id.people_container)
    PlaceHolderView peopleContainer;
    @BindView(R.id.movies_container)
    PlaceHolderView moviesContainer;

    @BindView(R.id.cancel_button)
    Button cancelButton;

    List<MovieOverviewItem> movieOverviewItems;
    List<UserOverviewItem> userOverviewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        movieOverviewItems = new ArrayList<MovieOverviewItem>();
        userOverviewItems = new ArrayList<UserOverviewItem>();
        presenter.onAttach(this);
        searchText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchText, InputMethodManager.SHOW_IMPLICIT);
        peopleContainer.getBuilder()
                .setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String queryText = charSequence.toString();
                presenter.onSearchValueChange(queryText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cancelButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                finish();
                return false;
            }
        });


    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(parent, name, context, attrs);
        return view;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public static Intent getStartIntent(Context context){
        return new Intent(context, SearchActivity.class);
    }

    @Override
    public void setRecentSearches(List<String> recentSearches) {

    }

    @Override
    public void setMovies(List<SearchResponse.MovieOverview> movies) {

        removeAllMovies();
        for(SearchResponse.MovieOverview movie: movies){
            MovieOverviewItem item = new MovieOverviewItem(movie, this, this);
            moviesContainer.addView(item);
            movieOverviewItems.add(item);
        }
    }

    private void removeAllMovies() {
        for(MovieOverviewItem item: movieOverviewItems){
            moviesContainer.removeView(item);
        }
        movieOverviewItems.clear();
    }

    @Override
    public void setUsers(List<SearchResponse.UserOverview> users) {

        removeAllUsers();
        for(SearchResponse.UserOverview user: users){
            UserOverviewItem item = new UserOverviewItem(user, this, this);
            peopleContainer.addView(item);
            userOverviewItems.add(item);
        }
    }

    private void removeAllUsers() {
        for(UserOverviewItem item: userOverviewItems){
            peopleContainer.removeView(item);
        }
        userOverviewItems.clear();
    }


    @Override
    public void onFollowClick(SearchResponse.MovieOverview movieOverview) {

    }

    @Override
    public void onItemClick(SearchResponse.MovieOverview movieOverview) {

    }

    @Override
    public void onItemClick(UserOverviewItem item) {

    }
}
