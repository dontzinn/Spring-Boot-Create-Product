package com.pedro.products.service;

import com.pedro.products.controller.CreateProductDto;
import com.pedro.products.controller.UpdateProductDto;
import com.pedro.products.entity.Product;
import com.pedro.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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

    public Product getProductById(Integer productId){
        return productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("Produto nao encontrado")
        );
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public void updateProductById(Integer productId, UpdateProductDto updateProductDto){
        Optional<Product> productEntity = productRepository.findById(productId);
        //String name, String description, Double price, int quantity
        if(productEntity.isPresent()) {
            Product product = productEntity.get();

            if(updateProductDto.name() != null) {
                product.setName(updateProductDto.name());
            }

            if(updateProductDto.description() != null) {
                product.setDescription(updateProductDto.description());
            }

            if(updateProductDto.price() != null) {
                product.setPrice(updateProductDto.price());
            }

            if(updateProductDto.quantity() != null) {
                product.setQuantity(updateProductDto.quantity());
            }

            productRepository.save(product);
        }
    }

    public void deleteById(Integer productId){
        Boolean productExists = productRepository.existsById(productId);

        if(productExists){
            productRepository.deleteById(productId);
        }
    }

}


