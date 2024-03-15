package com.labs.sboot.mongo.repo;

import com.labs.sboot.mongo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Integer> {

}
