
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
public class Post extends BaseModel {

    @SerializedName("id")
    @Expose
    @Column
    @PrimaryKey
    private String id;
    @SerializedName("text")
    @Expose
    @Column
    private String text;
    @SerializedName("ownerId")
    @Expose
    @Column
    private String ownerId;
    @SerializedName("type")
    @Expose
    @Column
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
