package com.labs.scloud.registry.service;

import com.labs.scloud.registry.model.Product;
import com.labs.scloud.registry.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;
    @Override
    public String createProduct(Product product) {
        return String.valueOf(productRepo.save(product).getId());
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
