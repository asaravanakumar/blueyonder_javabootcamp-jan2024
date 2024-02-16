package com.labs.scloud.registry.repo;

import com.labs.scloud.registry.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
