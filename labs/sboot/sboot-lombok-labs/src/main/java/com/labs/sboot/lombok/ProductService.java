package com.labs.sboot.lombok;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {
    public int createProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProduct(int id);
    public String updateProduct(int id, Product product);
    public String deleteProduct(int id);
}
