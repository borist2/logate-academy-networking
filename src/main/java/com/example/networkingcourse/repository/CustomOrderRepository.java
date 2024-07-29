package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Order;

public interface CustomOrderRepository
{
    Order findByIdQueryDSL (Integer id);
}
