package com.labs.sboot.lombok;

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
//        product.setName(product.getName().toUpperCase());
//        System.out.println(product.getId() + " " + product.getName());
//        Product product1 = new Product(101, "Dell Inspiron", "Laptop", "Dell", 75000);
         int id = service.createProduct(product);
         return "Product created successfully - " + id;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable(name = "id") int id) {
        return  service.getProduct(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable(name = "id") int id) {
        return  service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        return service.deleteProduct(id);
    }



}
