package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class ImageDto extends BaseDto {
    @SerializedName("category_id")
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ImageDetailsEntity{" +
                "imageId='" + super.getId() + '\'' +
                "categoryId=" + this.categoryId +
                '}';
    }
}
