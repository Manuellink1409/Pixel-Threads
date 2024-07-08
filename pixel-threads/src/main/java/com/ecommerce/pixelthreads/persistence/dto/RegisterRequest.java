package com.ecommerce.pixelthreads.persistence.dto;

import com.ecommerce.pixelthreads.persistence.enumeration.UserType;
import lombok.Getter;

@Getter
public class RegisterRequest {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phone;
    private String password;

}
