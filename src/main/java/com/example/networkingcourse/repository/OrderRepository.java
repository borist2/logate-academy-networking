package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Order;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface OrderRepository extends Repository<Order, Integer>
{
    Order save(Order order);

    List<Order> findAll();
}
