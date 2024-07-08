package com.ecommerce.pixelthreads.service;

import com.ecommerce.pixelthreads.common.UserMapper;
import com.ecommerce.pixelthreads.persistence.dto.RegisterRequest;
import com.ecommerce.pixelthreads.persistence.model.User;
import com.ecommerce.pixelthreads.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long register(RegisterRequest request) {
        var user = userMapper.toUser(request);
        return userRepository.save(user).getId();
    }
}
