package com.pratishthakapoor.gomovie.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import com.pratishthakapoor.gomovie.di.ApplicationContext;
import com.pratishthakapoor.gomovie.di.PreferenceInfo;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public class PreferenceHelperImpl implements PreferenceHelper {

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_SESSION_ID = "PREF_KEY_SESSION_ID";

    private final SharedPreferences prefs;

    @Inject
    public PreferenceHelperImpl(@ApplicationContext Context context, @PreferenceInfo String prefFileName){
        prefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
    @Override
    public void setCurrentUserId(String userId) {
        prefs.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply();
    }

    @Override
    public String getCurrentUserid() {
        return prefs.getString(PREF_KEY_CURRENT_USER_ID, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        prefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserName() {
        return prefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setSessionId(String sessionId) {
        prefs.edit().putString(PREF_KEY_SESSION_ID, sessionId).apply();
    }

    @Override
    public String getSessionId() {
        return prefs.getString(PREF_KEY_SESSION_ID, null);
    }
}
