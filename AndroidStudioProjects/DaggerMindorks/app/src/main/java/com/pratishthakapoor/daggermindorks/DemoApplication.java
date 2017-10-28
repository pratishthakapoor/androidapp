package com.pratishthakapoor.daggermindorks;

import android.app.Application;
import android.content.Context;

import com.pratishthakapoor.daggermindorks.Data.DataManager;

import javax.inject.Inject;

/**
 * Created by Pratishtha on 9/20/2017.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context)
    {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                                    .builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent()
    {
        return applicationComponent;
    }
}
