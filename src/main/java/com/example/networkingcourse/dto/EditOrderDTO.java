package com.example.networkingcourse.dto;

import com.example.networkingcourse.model.Order;
import com.example.networkingcourse.model.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record EditOrderDTO(String customerName, List<EditOrderItemDTO> items)
{
    public Order toDomain(Integer id)
    {
        var order = new Order();
        order.setId(id);
        order.setCustomerName(customerName);

        var items = Optional.ofNullable(this.items)
                .orElseGet(() -> new ArrayList<>(0))
                .stream()
                .map(i -> i.toDomain(order))
                .toList();

        order.setItems(items);

        return order;
    }

    private record EditOrderItemDTO(Integer id, String productName, Double price)
    {
        private OrderItem toDomain(Order order)
        {
            var orderItem = new OrderItem();
            orderItem.setId(this.id);
            orderItem.setProductName(this.productName);
            orderItem.setPrice(this.price);
            orderItem.setOrder(order);

            return orderItem;
        }
    }
}
