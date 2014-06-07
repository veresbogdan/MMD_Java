package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class CategoryDetailsEntity {
    @SerializedName("ID")
    private String id;

    @SerializedName("NAME")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDetailsEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
