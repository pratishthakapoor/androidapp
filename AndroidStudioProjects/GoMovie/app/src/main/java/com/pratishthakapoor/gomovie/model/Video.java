
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
public class Video extends BaseModel{

    @SerializedName("id")
    @Expose
    @Column
    @PrimaryKey
    private String id;
    @SerializedName("url")
    @Expose
    @Column
    private String url;
    @SerializedName("caption")
    @Expose
    @Column
    private String caption;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
