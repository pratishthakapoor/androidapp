package com.pratishthakapoor.daggermindorks;

import android.app.Activity;
import android.content.Context;

import com.pratishthakapoor.daggermindorks.Annotations.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity)
    {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext()
    {
        return mActivity;
    }

    @Provides
    Context provideActivity()
    {
        return mActivity;
    }
}

