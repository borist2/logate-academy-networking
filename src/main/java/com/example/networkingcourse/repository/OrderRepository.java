package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface OrderRepository extends Repository<Order, Integer>, CustomOrderRepository
{
    Order save(Order order);

    @EntityGraph(attributePaths = "items")
    List<Order> findAll();

    @Query("SELECT o FROM Order o JOIN FETCH o.items WHERE o.id = :id")
    Order findByIdWithOrderItems(@Param("id") Long id);
}
