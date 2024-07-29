package com.example.networkingcourse.service;

import com.example.networkingcourse.model.Product;
import com.example.networkingcourse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnotherProductService
{
    private final ProductRepository productRepository;

    //    @Transactional
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product saveProduct(Product product)
    {
        var product2 = new Product();
        product2.setPrice(product.getPrice());
        product2.setName(product.getName() + " copied in another method");
        return productRepository.save(product2);
    }


    @Transactional
    public Product saveProductWithExceptionSameTransaction(Product product)
    {
        var product2 = new Product();
        product2.setPrice(product.getPrice());
        product2.setName(product.getName() + " copied in another method");
        productRepository.save(product2);

        throw new RuntimeException("Something");
    }

    //    @Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product saveProductWithExceptionNewTransaction(Product product)
    {
        var product2 = new Product();
        product2.setPrice(product.getPrice());
        product2.setName(product.getName() + " copied in another method");
        productRepository.save(product2);

        throw new RuntimeException("Something");
    }


}
