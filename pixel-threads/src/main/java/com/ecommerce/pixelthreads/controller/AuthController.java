package com.ecommerce.pixelthreads.controller;

import com.ecommerce.pixelthreads.persistence.dto.RegisterRequest;
import com.ecommerce.pixelthreads.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

}