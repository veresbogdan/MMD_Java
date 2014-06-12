package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class ImageDto extends BaseDto {
    @SerializedName("IMAGE")
    private String imageId;

    @SerializedName("CATEGORY")
    private Long categoryId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ImageDetailsEntity{" +
                "imageId='" + imageId + '\'' +
                '}';
    }
}
