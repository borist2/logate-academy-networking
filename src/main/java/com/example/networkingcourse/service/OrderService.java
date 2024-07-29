package com.example.networkingcourse.service;

import com.example.networkingcourse.model.Order;
import com.example.networkingcourse.repository.OrderItemRepository;
import com.example.networkingcourse.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
//    private final OrderItemRepository orderItemRepository;
//    private final EntityManager entityManager;

    @Transactional
    public Order saveOrder(Order order)
    {
        var savedOrder = orderRepository.save(order);
//        savedOrder.getItems().forEach(orderItemRepository::save);

        return savedOrder;
    }

    @Transactional(readOnly = true)
    public List<Order> listOrders()
    {
        var orders = orderRepository.findAll();
        return orders;
    }


//    @Transactional(readOnly = true)
//    public Order getOrderWithItemsCriteria(Long id) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Order> query = cb.createQuery(Order.class);
//        Root<Order> orderRoot = query.from(Order.class);
//        orderRoot.fetch("orderItems", JoinType.LEFT);
//        query.select(orderRoot).where(cb.equal(orderRoot.get("id"), id));
//        return entityManager.createQuery(query).getSingleResult();
//    }


}
