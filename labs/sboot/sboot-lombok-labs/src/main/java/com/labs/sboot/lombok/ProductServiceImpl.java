package com.labs.sboot.lombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;

    @Override
    public int createProduct(Product product) {
        return productRepo.save(product).getId();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String updateProduct(int id, Product product) {
        Product productForUpdate = productRepo.findById(id).get();
        product.setId(id);
        productRepo.save(product);
        return productForUpdate != null ? "Product update successful" : "Product update failed";
    }

    @Override
    public String deleteProduct(int id) {
        Product productForDelete = productRepo.findById(id).get();
        productRepo.deleteById(id);
        return productForDelete != null ?  "Product delete successful" : "Product delete failed";
    }
}
