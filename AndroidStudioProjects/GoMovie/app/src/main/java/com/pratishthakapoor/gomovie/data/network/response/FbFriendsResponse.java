package com.pratishthakapoor.gomovie.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */

public class FbFriendsResponse {
    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("following")
    @Expose
    public boolean following;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public String getProfilePicture(){
        return "https://graph.facebook.com/"+id+"/picture?type=normal";
    }
}
