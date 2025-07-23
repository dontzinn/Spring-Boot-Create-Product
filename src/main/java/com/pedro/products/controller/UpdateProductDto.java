package com.pedro.products.controller;

public record UpdateProductDto(String name, String description, Double price, int quantity) {
}
