package com.pedro.products.controller;

import com.pedro.products.entity.Product;
import com.pedro.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductId(@PathVariable("productId") Integer productId){
        Product product = productService.getProductById(productId);

        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productService.listProducts();

        return ResponseEntity.ok(products);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProductById(@PathVariable("productId") Integer productId, @RequestBody UpdateProductDto updateProductDto){
        productService.updateProductById(productId, updateProductDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("productId") Integer productId ){
        productService.deleteById(productId);
        return ResponseEntity.ok().build();
    }
}
