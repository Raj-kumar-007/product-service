package com.flipart.productService.core.dao;

import com.flipart.productService.core.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDao extends MongoRepository<Product, UUID> {


}
