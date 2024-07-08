package com.ecommerce.pixelthreads.controller;

import com.ecommerce.pixelthreads.persistence.dto.OrderRequest;
import com.ecommerce.pixelthreads.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.pixelthreads.persistence.dto.OrderResponse;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateOrderStatusById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.updateOrderStatusById(id));
    }

}
