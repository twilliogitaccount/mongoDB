package com.mongo.repository;

import com.mongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends MongoRepository<Product, Long> {

}
