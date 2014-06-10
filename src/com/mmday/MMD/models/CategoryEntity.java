package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class CategoryEntity {
    @SerializedName("CATEGORY")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "category='" + category + '\'' +
                '}';
    }
}
