package com.mmday.MMD.activities;

import android.view.View;
import com.mmday.MMD.models.CategoryDto;

public class CategoryClickListener implements View.OnClickListener {
    private final CategoryClickHandler handler;
    private CategoryDto categoryDto;

    public CategoryClickListener(CategoryDto category, CategoryClickHandler categoryClickHandler) {
        categoryDto = category;
        handler = categoryClickHandler;
    }

    @Override
    public void onClick(View v) {
        handler.onClick(categoryDto);
    }
}
