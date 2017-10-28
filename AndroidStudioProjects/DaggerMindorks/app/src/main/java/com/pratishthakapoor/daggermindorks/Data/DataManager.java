package com.pratishthakapoor.daggermindorks.Data;

import android.content.Context;
import android.content.res.Resources;

import com.pratishthakapoor.daggermindorks.Annotations.ApplicationContext;
import com.pratishthakapoor.daggermindorks.Model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper)
    {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken)
    {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACESS_TOKEN, accessToken);
    }

    public String getAccessToken()
    {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception
    {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException
    {
        return mDbHelper.getUser(userId);
    }
}
