package com.labs.sboot.mongo.service;

import com.labs.sboot.mongo.model.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {
    public Integer createCategory(Category category);
    public boolean updateCategory(Integer id, Category category);
    public boolean deleteCategory(Integer id);
    public Optional<Category> getCategory(Integer id);
    public Collection<Category> getAllCategories();
}
