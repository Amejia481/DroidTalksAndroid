        package com.arturomejiamarmol.droidtalks.model;
        
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Talk {
    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("slides")
    @Expose
    private String slides;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("type")
    @Expose
    private String type;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Talk() {
    }
    
    /**
     *
     * @param topic
     * @param slides
     * @param name
     * @param type
     * @param video
     */
    public Talk(String name, String video, String slides, String topic, String type) {
        super();
        this.name = name;
        this.video = video;
        this.slides = slides;
        this.topic = topic;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getVideo() {
        return video;
    }
    
    public void setVideo(String video) {
        this.video = video;
    }
    
    public String getSlides() {
        return slides;
    }
    
    public void setSlides(String slides) {
        this.slides = slides;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
}