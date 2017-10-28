package com.pratishthakapoor.gomovie.util;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by tanmayvijayvargiya on 13/12/16.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    public static final String NAME = "GoMovieDatabase";

    public static final int VERSION = 1;
}
