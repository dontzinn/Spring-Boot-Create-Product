package com.pedro.products.controller;

public record CreateProductDto(Integer id,String name, String description, Double price, int quantity) {

}
