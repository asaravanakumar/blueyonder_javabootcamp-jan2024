package com.labs.sboot.mongo.service;

import com.labs.sboot.mongo.model.Category;
import com.labs.sboot.mongo.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    SequenceGeneratorService seqGenerator;

    @Override
    public Integer createCategory(Category category) {
        category.setId(seqGenerator.generateSequence(Category.SEQUENCE_NAME));
        Category savedCategory = categoryRepo.save(category);
        return savedCategory.getId();
    }

    @Override
    public boolean updateCategory(Integer id, Category category) {
        Optional<Category> categoryOp = categoryRepo.findById(id);
        Category categoryForUpdate = categoryOp.orElseThrow();
        category.setId(categoryForUpdate.getId());
        Category updatedCategory = categoryRepo.save(categoryForUpdate);
        return updatedCategory != null ? true : false;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        Optional<Category> categoryOp = categoryRepo.findById(id);
        Category categoryForUpdate = categoryOp.orElseThrow();
        categoryRepo.deleteById(id);
        return true;
    }

    @Override
    public Optional<Category> getCategory(Integer id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Collection<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
