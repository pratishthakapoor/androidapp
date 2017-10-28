package com.pratishthakapoor.gomovie.data.db;

import com.pratishthakapoor.gomovie.model.MovieStat;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;


/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public interface DbHelper {
    void getMovieStat(String movieId, QueryTransaction.QueryResultSingleCallback<MovieStat> queryCallback, Transaction.Error errorCallback);
}
