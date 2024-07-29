package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.OrderItem;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface OrderItemRepository extends Repository<OrderItem, Integer>
{
    OrderItem save(OrderItem item);
}
