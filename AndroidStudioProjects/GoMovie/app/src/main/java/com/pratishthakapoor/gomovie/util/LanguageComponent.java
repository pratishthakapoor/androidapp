package com.pratishthakapoor.gomovie.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanmayvijayvargiya on 14/12/16.
 */
public final class LanguageComponent {
    @Expose
    @SerializedName("name")
    private final String name;

    @Expose
    @SerializedName("id")
    private final String id;

    public LanguageComponent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                " 'name' : " + name +
                " , 'id' : " + id + " }";
    }

    public static List<String> convertToIdList(List<LanguageComponent> languageComponents){
        List<String> languageNames = new ArrayList<String>();
        for(LanguageComponent languageComponent : languageComponents){
            languageNames.add(languageComponent.getId());
        }
        return languageNames;
    }
}
