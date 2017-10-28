package com.pratishthakapoor.gomovie.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.pratishthakapoor.gomovie.data.DataManager;
import com.pratishthakapoor.gomovie.data.DataManagerImpl;
import com.pratishthakapoor.gomovie.data.db.DbHelper;
import com.pratishthakapoor.gomovie.data.db.DbHelperImpl;
import com.pratishthakapoor.gomovie.data.network.ApiHelper;
import com.pratishthakapoor.gomovie.data.network.ApiHelperImpl;
import com.pratishthakapoor.gomovie.data.network.ApiService;
import com.pratishthakapoor.gomovie.data.network.OfbizApiHelper;
import com.pratishthakapoor.gomovie.data.network.OfbizApiImpl;
import com.pratishthakapoor.gomovie.data.prefs.PreferenceHelper;
import com.pratishthakapoor.gomovie.data.prefs.PreferenceHelperImpl;
import com.pratishthakapoor.gomovie.di.ApplicationContext;
import com.pratishthakapoor.gomovie.di.PreferenceInfo;
import com.pratishthakapoor.gomovie.util.AppConstants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    @Singleton Application provideApplication(){
        return application;
    }

    @Provides
    @PreferenceInfo
    String providePrefFileName(){
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl dbHelper){
        return dbHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImpl apiHelper){
        return  apiHelper;
    }

    @Provides
    @Singleton
    OfbizApiHelper provideOfbizApiHelper(OfbizApiImpl apiHelper){
        return  apiHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePrefHelper(PreferenceHelperImpl preferenceHelper){
        return preferenceHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImpl dataManager){
        return dataManager;
    }

    @Provides
    @Singleton
    Retrofit provideCall() {
        Retrofit r = null;
        r = new Retrofit.Builder()
                .baseUrl(AppConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return r;
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
