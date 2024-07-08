package com.ecommerce.pixelthreads.persistence.repository;

import com.ecommerce.pixelthreads.persistence.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
