package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.CreateOrderDTO;
import com.example.networkingcourse.dto.EditOrderDTO;
import com.example.networkingcourse.dto.OrderInfoDTO;
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
        var orders = orderService.listOrders();
        var responseOrders = orders
                .stream()
                .map(OrderInfoDTO::fromModel)
                .toList();

//        orders.get(0).getItems(); // No Loading
//        orders.get(0).getItems().size(); // Loading

        return ResponseEntity.ok(responseOrders);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderInfoDTO> editOrder(@PathVariable Integer id, @RequestBody EditOrderDTO editOrderDTO)
    {
        var orderForSave = editOrderDTO.toDomain(id);
        var savedOrder = orderService.saveOrder(orderForSave);
        return ResponseEntity.ok(OrderInfoDTO.fromModel(savedOrder));
    }
}
