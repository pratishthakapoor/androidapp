package com.pratishthakapoor.gomovie.ui.home.search;

import java.util.List;

import in.co.gomovie.gomovieapp.data.network.response.SearchResponse;
import in.co.gomovie.gomovieapp.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 07/04/17.
 */

public interface SearchView extends MvpView{
    void setRecentSearches(List<String> recentSearches);
    void setMovies(List<SearchResponse.MovieOverview> movies);
    void setUsers(List<SearchResponse.UserOverview> users);
}
