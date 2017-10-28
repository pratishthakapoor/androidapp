package com.pratishthakapoor.gomovie.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 17/02/17.
 */
public class NetworkResponse {
    @SerializedName("message")
    @Expose
    private String message;

    public NetworkResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
