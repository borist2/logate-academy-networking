package com.example.networkingcourse.dto;

import com.example.networkingcourse.model.Product;

public record ProductInfoDTO(Integer id, String name, Double price)
{
    public static ProductInfoDTO fromModel(Product product)
    {
        return new ProductInfoDTO(product.getId(), product.getName(), product.getPrice());
    }
}
