package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.pratishthakapoor.gomovie.model.MovieOverview;

/**
 * Created by tanmayvijayvargiya on 21/03/17.
 */
public class UserInfoResponse {
    @SerializedName("userId")
    @Expose
    String userId;
    @SerializedName("userName")
    @Expose
    String userName;
    @SerializedName("emailId")
    @Expose
    String emailId;
    @SerializedName("profilePicture")
    @Expose
    String profilePicture;

    @SerializedName("wishList")
    @Expose
    List<MovieOverview> wishList;
    @SerializedName("seenList")
    @Expose
    List<MovieOverview> seenList;
    @SerializedName("followers")
    @Expose
    List<FollowOverview> followers;

    @SerializedName("following")
    @Expose
    List<FollowOverview> followings;

    public List<FollowOverview> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowOverview> followers) {
        this.followers = followers;
    }

    public List<FollowOverview> getFollowings() {
        return followings;
    }

    public void setFollowings(List<FollowOverview> followings) {
        this.followings = followings;
    }

    public class FollowOverview{
        @SerializedName("feed_id")
        @Expose
        String feedId;
        @SerializedName("target_id")
        @Expose
        String targetId;
    }
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<MovieOverview> getWishList() {
        return wishList;
    }

    public void setWishList(List<MovieOverview> wishList) {
        this.wishList = wishList;
    }

    public List<MovieOverview> getSeenList() {
        return seenList;
    }

    public void setSeenList(List<MovieOverview> seenList) {
        this.seenList = seenList;
    }
}
