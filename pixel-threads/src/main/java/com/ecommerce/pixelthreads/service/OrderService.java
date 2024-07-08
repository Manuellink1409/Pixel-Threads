package com.ecommerce.pixelthreads.service;

import com.ecommerce.pixelthreads.common.OrderMapper;
import com.ecommerce.pixelthreads.persistence.dto.OrderRequest;
import com.ecommerce.pixelthreads.persistence.dto.OrderResponse;
import com.ecommerce.pixelthreads.persistence.enumeration.OrderState;
import com.ecommerce.pixelthreads.persistence.model.Order;
import com.ecommerce.pixelthreads.persistence.model.OrderProduct;
import com.ecommerce.pixelthreads.persistence.model.User;
import com.ecommerce.pixelthreads.persistence.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserService userService;

    public OrderResponse updateOrderStatusById(Long id) {
        return null;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        var user = userService.userExists(1L);
        Order order = new Order();
        var orderProducts = orderRequest.getOrderProducts().stream()
                            .map(each -> orderMapper.toOrderProduct(each, order))
                            .toList();
        BigDecimal totalPrice = orderProducts.stream()
                .map(op -> op.getPrice().multiply(op.getQuantity()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setUser(user);
        order.setOrderProducts(orderProducts);
        order.setOrderStatus(OrderState.CONFIRMED);
        orderRepository.save(order);
        return orderMapper.toOrderResponse2(order,totalPrice);
    }
}
