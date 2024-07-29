package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.CreateOrderDTO;
import com.example.networkingcourse.model.Order;
import com.example.networkingcourse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO createOrderDTO)
    {
        var savedOrder = orderService.saveOrder(createOrderDTO.toDomain());
        return ResponseEntity.ok(savedOrder);
    }
}
