package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 21/03/17.
 */
public class LoginResponse {
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("sessionId")
    @Expose
    String sessionId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
