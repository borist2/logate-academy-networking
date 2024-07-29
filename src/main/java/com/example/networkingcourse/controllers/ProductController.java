package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.CreateEditProductDTO;
import com.example.networkingcourse.dto.ProductInfoDTO;
import com.example.networkingcourse.model.Product;
import com.example.networkingcourse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductInfoDTO>> listProducts()
    {
        var products = productService.findAll()
                .stream()
                .map(ProductInfoDTO::fromModel)
                .toList();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductInfoDTO> addProduct(@RequestBody CreateEditProductDTO product)
    {
        var createdProduct = productService.addProduct(product.toModel());
        return ResponseEntity.ok(ProductInfoDTO.fromModel(createdProduct));
    }

    @PostMapping("rollback/default")
    public ResponseEntity<ProductInfoDTO> addProductRollbackDefaultBehaviour(@RequestBody CreateEditProductDTO product)
    {
        var createdProduct = productService.addProductRollbackDefaultBehaviour(product.toModel());
        return ResponseEntity.ok(ProductInfoDTO.fromModel(createdProduct));
    }

    @PostMapping("rollback/checked-exception")
    public ResponseEntity<ProductInfoDTO> addProductRollbackCheckedException(@RequestBody CreateEditProductDTO product) throws Exception
    {
        var createdProduct = productService.addProductRollbackCheckedException(product.toModel());
        return ResponseEntity.ok(ProductInfoDTO.fromModel(createdProduct));
    }

    @PostMapping("rollback/checked-exception-explicit")
    public ResponseEntity<ProductInfoDTO> addProductRollbackCheckedExceptionExplicit(@RequestBody CreateEditProductDTO product) throws Exception
    {
        var createdProduct = productService.addProductRollbackCheckedExceptionExplicitRollback(product.toModel());
        return ResponseEntity.ok(ProductInfoDTO.fromModel(createdProduct));
    }

    @PostMapping("/same-transaction")
    public ResponseEntity<String> addProductsInSameTransaction(@RequestBody CreateEditProductDTO product)
    {
        productService.addProductsSameTransaction(product.toModel());
        return ResponseEntity.ok().build();
    }


    @PostMapping("/new-transaction")
    public ResponseEntity<String> addProductsInNewTransaction(@RequestBody CreateEditProductDTO product)
    {
        productService.addProductsNewTransaction(product.toModel());
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/requiresNewTransaction")
//    public ResponseEntity<String> addProductsInRequiresNewTransaction(@RequestBody List<Product> products)
//    {
//        if (products.size() != 2)
//        {
//            return ResponseEntity.badRequest().body("Please provide exactly two products");
//        }
//        productService.addProductsInRequiresNewTransaction(products.get(0), products.get(1));
//        return ResponseEntity.ok("Products added in REQUIRES_NEW transaction");
//    }
}
