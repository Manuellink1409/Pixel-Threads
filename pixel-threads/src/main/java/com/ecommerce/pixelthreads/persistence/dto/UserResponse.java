package com.ecommerce.pixelthreads.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phone;

}
