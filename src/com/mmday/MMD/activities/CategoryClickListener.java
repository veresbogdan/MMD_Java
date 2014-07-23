package com.mmday.MMD.activities;

import android.view.View;
import com.mmday.MMD.models.CategoryDto;

/**
 * Created by albert on 20.07.2014.
 */
public class CategoryClickListener implements View.OnClickListener {
    private final CategoryClickHandler handler;
    private CategoryDto categoryDto;

    public CategoryClickListener(CategoryDto categoryDto, CategoryClickHandler handler) {
        this.categoryDto = categoryDto;
        this.handler = handler;
    }

    @Override
    public void onClick(View v) {
        this.handler.onClick(this.categoryDto);
    }
}
