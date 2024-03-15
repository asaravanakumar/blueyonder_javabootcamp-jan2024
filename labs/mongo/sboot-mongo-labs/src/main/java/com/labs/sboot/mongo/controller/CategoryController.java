package com.labs.sboot.mongo.controller;

import com.labs.sboot.mongo.model.Category;
import com.labs.sboot.mongo.model.ResponseMessage;
import com.labs.sboot.mongo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Collection<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable(name = "id") Integer id) {
        Optional<Category> categoryOp = categoryService.getCategory(id);
        return ResponseEntity.ok(categoryOp.orElseThrow());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> createCategory(@RequestBody Category category) {
        Integer id = categoryService.createCategory(category);
        ResponseMessage response = null;
        if(id > 0) {
            response = new ResponseMessage("Success", "Category Created Successfully");
            return ResponseEntity.ok().body(response);
        } else {
            response = new ResponseMessage("Failure", "Category Creation Failed");
            return ResponseEntity.ok().body(response);
        }
    }
}
