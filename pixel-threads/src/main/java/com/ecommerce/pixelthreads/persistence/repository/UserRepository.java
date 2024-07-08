package com.ecommerce.pixelthreads.persistence.repository;

import com.ecommerce.pixelthreads.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
