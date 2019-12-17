package com.example.lab6ad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResourceId {
    @SerializedName("videoId")
    @Expose
    private String videoId;

    public String getId() {
        return videoId;
    }

    public void setId(String id) {
        this.videoId = id;
    }
}
