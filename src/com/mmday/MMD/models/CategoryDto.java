package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class CategoryDto extends BaseDto{
    @SerializedName("CATEGORY")
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
