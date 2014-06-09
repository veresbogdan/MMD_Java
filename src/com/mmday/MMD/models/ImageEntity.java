package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class ImageEntity {
    @SerializedName("IMAGE")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ImageDetailsEntity{" +
                "id='" + id + '\'' +
                '}';
    }
}
