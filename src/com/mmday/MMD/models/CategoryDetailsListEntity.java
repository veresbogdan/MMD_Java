package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class CategoryDetailsListEntity {
    @SerializedName("CATEGORIES")
    private Collection<CategoryDetailsEntity> categories;

    public Collection<CategoryDetailsEntity> getList(){
        return categories;
    }
}
