package com.codetoart.android.upcomingmovieapp.ui.base;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codetoart.android.upcomingmovieapp.UpcomingMovieApplication;
import com.codetoart.android.upcomingmovieapp.injection.component.ActivityComponent;
import com.codetoart.android.upcomingmovieapp.injection.component.DaggerActivityComponent;
import com.codetoart.android.upcomingmovieapp.injection.module.ActivityModule;

/**
 * Created by mahavir on 9/1/16.
 */
public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(UpcomingMovieApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }
}