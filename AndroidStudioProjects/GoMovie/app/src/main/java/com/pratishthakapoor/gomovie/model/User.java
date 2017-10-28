package com.pratishthakapoor.gomovie.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import com.pratishthakapoor.gomovie.util.MyDatabase;

/**
 * Created by tanmayvijayvargiya on 13/12/16.
 */
@Table(database = MyDatabase.class, insertConflict = ConflictAction.REPLACE)
public class User extends BaseModel{

    @PrimaryKey
    @Column
    String id;

    @Column
    String name;

    @Column
    String emailId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFacebookProfilePictureUrl(){
        return "https://graph.facebook.com/"+id+"/picture?type=normal";
    }

}
