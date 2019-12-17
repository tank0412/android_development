package com.example.lab6ad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Snippet {

    @SerializedName("resourceId")
    @Expose
    public ResourceId resourceId;


    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    public String getId() {
        return publishedAt;
    }

    public void setId(String id) {
        this.publishedAt = id;
    }




}