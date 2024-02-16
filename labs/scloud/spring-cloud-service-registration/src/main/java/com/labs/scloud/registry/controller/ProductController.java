package com.labs.scloud.registry.controller;

import com.labs.scloud.registry.service.ProductService;
import com.labs.scloud.registry.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }
}
