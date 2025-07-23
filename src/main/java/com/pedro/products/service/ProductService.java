package com.pedro.products.service;

import com.pedro.products.controller.CreateProductDto;
import com.pedro.products.entity.Product;
import com.pedro.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Integer createProduct(CreateProductDto createProductDto){
        var entity = new Product(
                                 createProductDto.name(),
                                 createProductDto.description(),
                                 createProductDto.price(),
                                 createProductDto.quantity()
                                );
        var productSaved = productRepository.saveAndFlush(entity);
        return productSaved.getId();
    }
}
