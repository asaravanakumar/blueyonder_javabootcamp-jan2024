package com.labs.scloud.registry.service;

import com.labs.scloud.registry.model.Product;

import java.util.List;

public interface ProductService {
    public String createProduct(Product product);
    public List<Product> getProducts();
}
