package com.ecommerce.pixelthreads.common;

import com.ecommerce.pixelthreads.persistence.dto.RegisterRequest;
import com.ecommerce.pixelthreads.persistence.dto.UserResponse;
import com.ecommerce.pixelthreads.persistence.enumeration.UserType;
import com.ecommerce.pixelthreads.persistence.model.User;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(@NonNull RegisterRequest request) {
        return User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .address(request.getAddress())
                .password(request.getPassword())
                .phone(request.getPhone())
                .email(request.getEmail())
                .userType(UserType.USER)
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .build();
    }
}
