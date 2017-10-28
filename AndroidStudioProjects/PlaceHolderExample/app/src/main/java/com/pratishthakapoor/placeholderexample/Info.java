package com.pratishthakapoor.placeholderexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pratishtha on 9/19/2017.
 */

class Info {

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("caption")
    @Expose
    private String caption;

    @SerializedName("time")
    @Expose
    private String time;

    //Getter methods Implementation

    public String getTitle()
    {
        return title;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getCaption()
    {
        return caption;
    }

    public String getTime()
    {
        return time;
    }

    //Setter methods implementation

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public void setCaption(String caption)
    {
        this.caption = caption;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
}
