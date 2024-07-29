package com.example.networkingcourse.dto;

import com.example.networkingcourse.model.Order;
import com.example.networkingcourse.model.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record OrderInfoDTO(Integer id, String customerName, List<OrderItemInfoDTO> items)
{
    public static OrderInfoDTO fromModel(Order order)
    {
        var items = Optional.ofNullable(order.getItems())
                .orElseGet(() -> new ArrayList<>(0))
                .stream()
                .map(OrderItemInfoDTO::fromModel)
                .toList();

        return new OrderInfoDTO(order.getId(), order.getCustomerName(), items);
    }

    private record OrderItemInfoDTO(Integer id, String productName, Double price)
    {
        static OrderItemInfoDTO fromModel(OrderItem orderItem)
        {
            return new OrderItemInfoDTO(orderItem.getId(), orderItem.getProductName(), orderItem.getPrice());
        }
    }
}
