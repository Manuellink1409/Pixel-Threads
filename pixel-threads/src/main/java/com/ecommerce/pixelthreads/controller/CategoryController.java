package com.ecommerce.pixelthreads.controller;

import com.ecommerce.pixelthreads.persistence.dto.CategoryRequest;
import com.ecommerce.pixelthreads.persistence.dto.CategoryResponse;
import com.ecommerce.pixelthreads.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(
            @PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createOneCategory(
            @RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.createOneCategory(request));
    }

}
