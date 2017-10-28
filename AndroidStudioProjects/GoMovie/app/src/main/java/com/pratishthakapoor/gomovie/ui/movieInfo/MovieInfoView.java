package com.pratishthakapoor.gomovie.ui.movieInfo;

import com.pratishthakapoor.gomovie.data.network.response.MovieInfoResponse;
import com.pratishthakapoor.gomovie.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 02/04/17.
 */
public interface MovieInfoView extends MvpView{
    void setMovieInfo(MovieInfoResponse movieInfoResponse);
}
