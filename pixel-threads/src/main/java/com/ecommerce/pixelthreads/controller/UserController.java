package com.ecommerce.pixelthreads.controller;

import com.ecommerce.pixelthreads.persistence.dto.PageResponse;
import com.ecommerce.pixelthreads.persistence.dto.UserResponse;
import com.ecommerce.pixelthreads.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<PageResponse<UserResponse>> getAllUsers(
            @RequestParam(required = false, defaultValue = "20") int size,
            @RequestParam(required = false, defaultValue = "0") int page
            ) {
        return ResponseEntity.ok(userService.getAllUsers(size,page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
