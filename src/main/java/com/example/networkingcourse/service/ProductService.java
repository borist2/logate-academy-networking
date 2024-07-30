package com.example.networkingcourse.service;

import com.example.networkingcourse.model.Product;
import com.example.networkingcourse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;
    private final AnotherProductService anotherProductService;

    @Transactional(readOnly = true)
    public List<Product> findAll()
    {
        var products = productRepository.findAll();
//        if (!products.isEmpty())
//        {
//            var product = products.get(0);
//            product.setName(product.getName() + " Updated from method");
//            anotherProductService.saveProduct(product);
//        }

        return products;
    }

    @Transactional
    public Product addProduct(Product product)
    {
        return productRepository.save(product);
    }

    @Transactional
    public Product addProductAnotherMethod(Product product)
    {
        return productRepository.save(product);
    }

    @Transactional
    public Product addProductRollbackDefaultBehaviour(Product product)
    {
        productRepository.save(product);

        throw new RuntimeException("Exception");
    }

    @Transactional
    public Product addProductRollbackCheckedException(Product product) throws Exception
    {
        productRepository.save(product);

        throw new Exception("Exception");
    }

    @Transactional(rollbackFor = Exception.class)
    public Product addProductRollbackCheckedExceptionExplicitRollback(Product product) throws Exception
    {
        productRepository.save(product);

        throw new Exception("Exception");
    }

    @Transactional
    public void addProductsSameTransaction(Product mainProduct)
    {
        addProduct(mainProduct);

        try
        {
            anotherProductService.saveProductWithExceptionSameTransaction(mainProduct);
        } catch (RuntimeException ex)
        {

        }
    }

    @Transactional
    public void addProductsNewTransaction(Product mainProduct)
    {
        addProduct(mainProduct);

        try
        {
            anotherProductService.saveProductWithExceptionNewTransaction(mainProduct);
        } catch (RuntimeException ex)
        {

        }
    }

}
