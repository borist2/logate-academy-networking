package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.CreateOrderDTO;
import com.example.networkingcourse.dto.OrderInfoDTO;
import com.example.networkingcourse.model.OrderItem;
import com.example.networkingcourse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderInfoDTO> createOrder(@RequestBody CreateOrderDTO createOrderDTO)
    {
        var savedOrder = orderService.saveOrder(createOrderDTO.toDomain());
        return ResponseEntity.ok(OrderInfoDTO.fromModel(savedOrder));
    }

    @GetMapping
    public ResponseEntity<List<OrderInfoDTO>> listOrders()
    {
        var orders = orderService.listOrders()
                .stream()
                .map(OrderInfoDTO::fromModel)
                .toList();

        return ResponseEntity.ok(orders);
    }
}
