package com.mycomp.e_commerce.store.service;

import com.mycomp.e_commerce.store.model.Product;
import com.mycomp.e_commerce.store.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
