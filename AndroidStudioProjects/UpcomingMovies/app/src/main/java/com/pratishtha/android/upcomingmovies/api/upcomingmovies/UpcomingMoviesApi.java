package com.jlmd.android.newfilmsmvp.api.upcomingmovies;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import java.util.List;

/**
 * @author jlmd
 */
public interface UpcomingMoviesApi {

  static final String BASE_URL = "https://api.themoviedb.org/3/movie";
  //static final String API_KEY = "XXX";
  static final String API_KEY = "e6fc1db7aff91a94f0f0832d4f209453";

  void getUpcomingMovies(Callback callback);

  public interface Callback {

    void onFinish(List<Movie> movies);

    void onError(String errorMessage);
  }
}
