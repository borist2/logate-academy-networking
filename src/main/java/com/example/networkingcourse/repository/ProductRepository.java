package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProductRepository extends Repository<Product, Integer>
{
    Product save(Product product);

    List<Product> findAll();
}
