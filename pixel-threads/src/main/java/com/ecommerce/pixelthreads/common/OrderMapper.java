package com.ecommerce.pixelthreads.common;

import com.ecommerce.pixelthreads.persistence.dto.OrderRequest;
import com.ecommerce.pixelthreads.persistence.dto.OrderResponse;
import com.ecommerce.pixelthreads.persistence.dto.ProductOrder;
import com.ecommerce.pixelthreads.persistence.model.Order;
import com.ecommerce.pixelthreads.persistence.model.OrderProduct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderMapper {

    public OrderProduct toOrderProduct(ProductOrder productOrder, Order order) {
        return OrderProduct
                .builder()
                .productId(productOrder.getProductId())
                .quantity(productOrder.getQuantity())
                .price(productOrder.getPrice())
                .order(order)
                .build();
    }

    public OrderResponse toOrderResponse(Order order) {
        return null;
    }

    public OrderResponse toOrderResponse2(Order order, BigDecimal totalPrice) {
        return OrderResponse
                .builder()
                .state(order.getOrderStatus())
                .totalPrice(totalPrice)
                .products(order.getOrderProducts())
                .userId(order.getId())
                .build();
    }
}
