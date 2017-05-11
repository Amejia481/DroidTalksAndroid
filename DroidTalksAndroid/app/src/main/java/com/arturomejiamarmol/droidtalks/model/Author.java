package com.arturomejiamarmol.droidtalks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {
    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Author() {
    }
    
    /**
     *
     * @param twitter
     * @param name
     */
    public Author(String name, String twitter) {
        super();
        this.name = name;
        this.twitter = twitter;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTwitter() {
        return twitter;
    }
    
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
}