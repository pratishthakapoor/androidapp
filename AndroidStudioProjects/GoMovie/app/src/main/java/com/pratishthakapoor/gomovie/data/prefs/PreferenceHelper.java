package com.pratishthakapoor.gomovie.data.prefs;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public interface PreferenceHelper {

    void setCurrentUserId(String userId);

    String getCurrentUserid();

    void setCurrentUserName(String userName);

    String getCurrentUserName();

    void setSessionId(String sessionId);

    String getSessionId();

}
