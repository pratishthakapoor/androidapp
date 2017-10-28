package com.pratishthakapoor.daggermindorks;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IntegerRes;

import com.pratishthakapoor.daggermindorks.Annotations.ApplicationContext;
import com.pratishthakapoor.daggermindorks.Annotations.DatabaseInfo;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@Module
class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {

        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion()
    {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs()
    {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
