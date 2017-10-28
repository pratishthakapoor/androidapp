package com.pratishthakapoor.daggermindorks.Data;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@Singleton
public class SharedPrefsHelper {

    public static String PREF_KEY_ACESS_TOKEN = "access-token";

    private SharedPreferences msharedPreferences;

    @Inject
    public SharedPrefsHelper(SharedPreferences sharedPreferences)
    {
        msharedPreferences = sharedPreferences;
    }

    public void put(String key, String value)
    {
        msharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value)
    {
        msharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value)
    {
        msharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value)
    {
        msharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue)
    {
        return msharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue)
    {
        return msharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue)
    {
        return msharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue)
    {
        return msharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key)
    {
        msharedPreferences.edit().remove(key).apply();
    }
}
