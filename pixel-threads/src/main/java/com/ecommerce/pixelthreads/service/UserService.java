package com.ecommerce.pixelthreads.service;

import com.ecommerce.pixelthreads.common.UserMapper;
import com.ecommerce.pixelthreads.persistence.dto.PageResponse;
import com.ecommerce.pixelthreads.persistence.dto.UserResponse;
import com.ecommerce.pixelthreads.persistence.model.User;
import com.ecommerce.pixelthreads.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public PageResponse<UserResponse> getAllUsers(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageable);
        List<UserResponse> userResponse = userPage.stream()
                .map(userMapper::toUserResponse)
                .toList();
        return new PageResponse<>(
                userResponse,
                userPage.getSize(),
                userPage.getNumber(),
                userPage.getTotalPages(),
                userPage.isLast(),
                userPage.isFirst()
        );
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found with id: "+id));
        return userMapper.toUserResponse(user);
    }

    public User userExists(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found with id: "+id));
    }
}
