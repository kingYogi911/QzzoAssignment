package com.yogi.models;

import com.yogi.adapters.TrailerAdapter;

public class TrailerModel {
    private String videoPath;
    private String thumbNailPath;

    public TrailerModel(){
        this.videoPath="";
        this.thumbNailPath="";
    }
    public TrailerModel(String videoUrl,String ThumbnailUrl){
        this.videoPath=videoUrl;
        this.thumbNailPath=ThumbnailUrl;
    }
    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getThumbNailPath() {
        return thumbNailPath;
    }

    public void setThumbNailPath(String thumbNailPath) {
        this.thumbNailPath = thumbNailPath;
    }
}
