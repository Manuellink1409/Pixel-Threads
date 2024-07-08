package com.ecommerce.pixelthreads.service;

import com.ecommerce.pixelthreads.common.CategoryMapper;
import com.ecommerce.pixelthreads.persistence.dto.CategoryRequest;
import com.ecommerce.pixelthreads.persistence.dto.CategoryResponse;
import com.ecommerce.pixelthreads.persistence.model.Category;
import com.ecommerce.pixelthreads.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryResponse> getAllCategories() {
        List<Category> category = categoryRepository.findAll();
        return category.stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found with id: "+id));
        return categoryMapper.toCategoryResponse(category);
    }

    public CategoryResponse createOneCategory(CategoryRequest request) {
        var category = categoryMapper.toCategory(request);
        var categoryResponse = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(categoryResponse);
    }
}
