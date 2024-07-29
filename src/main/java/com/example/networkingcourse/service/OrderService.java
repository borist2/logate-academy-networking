package com.example.networkingcourse.service;

import com.example.networkingcourse.model.Order;
import com.example.networkingcourse.repository.OrderItemRepository;
import com.example.networkingcourse.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public Order saveOrder(Order order)
    {
        var savedOrder = orderRepository.save(order);
        savedOrder.getItems().forEach(orderItemRepository::save);

        return savedOrder;
    }
}
