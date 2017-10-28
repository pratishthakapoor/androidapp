package com.pratishthakapoor.gomovie.data.db;

import com.pratishthakapoor.gomovie.model.MovieStat;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import javax.inject.Inject;

import in.co.gomovie.gomovieapp.model.MovieStat_Table;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public class DbHelperImpl implements DbHelper {

    @Inject
    public DbHelperImpl() {
    }

    @Override
    public void getMovieStat(String movieId, QueryTransaction.QueryResultSingleCallback<MovieStat> queryCallback , Transaction.Error errorCallback) {
        SQLite.select()
                .from(MovieStat.class)
                .where(MovieStat_Table.movieId.eq(movieId))
                .async()
                .querySingleResultCallback(queryCallback)
                .error(errorCallback)
                .execute();
    }
}
