package com.ecommerce.pixelthreads.persistence.dto;

import com.ecommerce.pixelthreads.persistence.enumeration.OrderState;
import com.ecommerce.pixelthreads.persistence.model.OrderProduct;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class OrderResponse {
    private Long userId;
    private List<OrderProduct> products;
    private OrderState state;
    private BigDecimal totalPrice;
}
