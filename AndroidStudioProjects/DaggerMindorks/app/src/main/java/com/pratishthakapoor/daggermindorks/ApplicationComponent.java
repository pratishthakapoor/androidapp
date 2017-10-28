package com.pratishthakapoor.daggermindorks;

import android.app.Application;
import android.content.Context;

import com.pratishthakapoor.daggermindorks.Annotations.ApplicationContext;
import com.pratishthakapoor.daggermindorks.Data.DataManager;
import com.pratishthakapoor.daggermindorks.Data.DbHelper;
import com.pratishthakapoor.daggermindorks.Data.SharedPrefsHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pratishtha on 9/20/2017.
 */


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();
    Application getApplication();
    DataManager getDataManager();
    SharedPrefsHelper getPreferenceHelper();
    DbHelper getDbHelper();
}
