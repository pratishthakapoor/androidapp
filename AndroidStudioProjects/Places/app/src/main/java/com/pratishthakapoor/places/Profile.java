package com.pratishthakapoor.places;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pratishtha on 9/20/2017.
 */

class Profile {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String imageUrl;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("weather")
    @Expose
    private String weather;

    // Getter method

    public String getName()
    {
        return name;
    }
    public String getImageUrl()
    {
        return imageUrl;
    }
    public String getLocation()
    {
        return location;
    }
    public String getDescription()
    {
        return description;
    }
    public String getWeather()
    {
        return weather;
    }

    // Setter Method
    public void setName(String name)
    {
        this.name = name;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setWeather(String weather)
    {
        this.weather = weather;
    }
}
