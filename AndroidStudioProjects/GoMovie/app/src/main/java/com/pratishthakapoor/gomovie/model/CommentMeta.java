
package com.pratishthakapoor.gomovie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import com.pratishthakapoor.gomovie.util.MyDatabase;

@Table(database = MyDatabase.class, insertConflict = ConflictAction.REPLACE)
public class CommentMeta extends BaseModel{

    @SerializedName("foreign_id")
    @Expose
    @Column
    @PrimaryKey
    private String foreign_id;
    @SerializedName("username")
    @Expose
    @Column
    private String username;
    @SerializedName("text")
    @Expose
    @Column
    private String text;
    @SerializedName("profilePicture")
    @Expose
    @Column
    private String profilePicture;



    public String getForeign_id() {
        return foreign_id;
    }

    public void setForeign_id(String foreign_id) {
        this.foreign_id = foreign_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
