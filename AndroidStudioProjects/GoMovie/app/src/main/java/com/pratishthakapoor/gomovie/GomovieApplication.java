package com.pratishthakapoor.gomovie;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.di.component.ApplicationComponent;
import com.pratishthakapoor.gomovie.di.component.DaggerApplicationComponent;
import com.pratishthakapoor.gomovie.di.module.ApplicationModule;

/**
 * Created by tanmayvijayvargiya on 13/12/16.
 */
public class GomovieApplication extends Application {

    @Inject
    in.co.gomovie.gomovieapp.data.DataManager dataManager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
        FacebookSdk.sdkInitialize(this);
        FlowManager.init(new FlowConfig.Builder(this).build());
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public DataManager getDataManager(){
        return dataManager;
    }
}
