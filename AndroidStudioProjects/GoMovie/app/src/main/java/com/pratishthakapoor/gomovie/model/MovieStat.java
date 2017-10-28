package com.pratishthakapoor.gomovie.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import com.pratishthakapoor.gomovie.util.MyDatabase;

/**
 * Created by tanmayvijayvargiya on 19/04/17.
 */

@Table(database = MyDatabase.class, insertConflict = ConflictAction.REPLACE)
public class MovieStat extends BaseModel {
    @Column
    @PrimaryKey
    String movieId;
    @Column
    boolean inSeenList;
    @Column
    boolean inWantToWatchList;


    public MovieStat(){

    }
    public MovieStat(String movieId) {
        this.movieId = movieId;
        this.inSeenList = false;
        this.inWantToWatchList = false;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public boolean isInSeenList() {
        return inSeenList;
    }

    public void setInSeenList(boolean inSeenList) {
        this.inSeenList = inSeenList;
    }

    public boolean isInWantToWatchList() {
        return inWantToWatchList;
    }

    public void setInWantToWatchList(boolean inWantToWatchList) {
        this.inWantToWatchList = inWantToWatchList;
    }
}
