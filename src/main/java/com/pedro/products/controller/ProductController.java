package com.pedro.products.controller;

import com.pedro.products.entity.Product;
import com.pedro.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/products")

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @ResponseBody
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductDto createProductDto){
        Integer productId = productService.createProduct(createProductDto);
        return ResponseEntity.ok().build();
    }
    /*
    public Product createProduct(@RequestBody Product product){
        Product product1 = new Product(product.getName(), product.getDescription(),product.getPrice(), product.getQuantity());
        return product1;
    }*/
}
