
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
public class Comment extends BaseModel{

    @SerializedName("actorPhotoUrl")
    @Expose
    @Column
    private String actorPhotoUrl;

    @SerializedName("foreign_id")
    @Expose
    @Column
    @PrimaryKey
    private String foreignId;

    @SerializedName("like_count")
    @Expose
    @Column
    private int likeCount;
    @SerializedName("message")
    @Expose
    @Column
    private String message;
    @SerializedName("object")
    @Expose
    @Column
    private String object;
    @SerializedName("time")
    @Expose
    @Column
    private String time;
    @SerializedName("actorName")
    @Expose
    @Column
    private String actorName;

    public String getActorPhotoUrl() {
        return actorPhotoUrl;
    }

    public void setActorPhotoUrl(String actorPhotoUrl) {
        this.actorPhotoUrl = actorPhotoUrl;
    }

    public String getForeignId() {
        return foreignId;
    }

    public void setForeignId(String foreignId) {
        this.foreignId = foreignId;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}
