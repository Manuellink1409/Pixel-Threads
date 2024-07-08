package com.ecommerce.pixelthreads.persistence.repository;

import com.ecommerce.pixelthreads.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
