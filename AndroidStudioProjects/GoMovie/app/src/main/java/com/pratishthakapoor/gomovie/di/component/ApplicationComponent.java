package com.pratishthakapoor.gomovie.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.pratishthakapoor.gomovie.GomovieApplication;
import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.di.ApplicationContext;
import com.pratishthakapoor.gomovie.di.module.ApplicationModule;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    //Kick start [iniy]
    void inject(GomovieApplication app);

    //Remaining
    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
