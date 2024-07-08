package com.ecommerce.pixelthreads.persistence.repository;

import com.ecommerce.pixelthreads.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
