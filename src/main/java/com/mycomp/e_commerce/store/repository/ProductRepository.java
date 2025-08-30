package com.mycomp.e_commerce.store.repository;

import com.mycomp.e_commerce.store.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
