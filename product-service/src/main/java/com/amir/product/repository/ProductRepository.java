package com.amir.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amir.product.model.Product;

public interface ProductRepository  extends MongoRepository<Product , String>  {
    
}
