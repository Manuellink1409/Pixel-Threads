package com.ecommerce.pixelthreads.common;

import com.ecommerce.pixelthreads.persistence.dto.CategoryRequest;
import com.ecommerce.pixelthreads.persistence.dto.CategoryResponse;
import com.ecommerce.pixelthreads.persistence.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category toCategory(CategoryRequest request) {
        return Category
                .builder()
                .name(request.getName())
                .build();
    }
}
