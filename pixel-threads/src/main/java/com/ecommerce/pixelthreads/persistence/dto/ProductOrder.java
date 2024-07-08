package com.ecommerce.pixelthreads.persistence.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductOrder {
    private Long productId;
    private BigDecimal price;
    private BigDecimal quantity;
}
