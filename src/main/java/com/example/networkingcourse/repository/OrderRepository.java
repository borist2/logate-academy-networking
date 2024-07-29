package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Order;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface OrderRepository extends Repository<Order, Integer>
{
    Order save(Order order);
}
