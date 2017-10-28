package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 09/04/17.
 */

public class UserOverview{
    @SerializedName("userId")
    @Expose
    public String userId;
    @SerializedName("userName")
    @Expose
    public String userName;
    @SerializedName("profilePicture")
    @Expose
    public String userProfileUrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    public void setUserProfileUrl(String userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }
}
