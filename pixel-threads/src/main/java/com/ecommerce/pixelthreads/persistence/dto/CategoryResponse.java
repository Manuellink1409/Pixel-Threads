package com.ecommerce.pixelthreads.persistence.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CategoryResponse {

    private Long id;
    private String name;

}
