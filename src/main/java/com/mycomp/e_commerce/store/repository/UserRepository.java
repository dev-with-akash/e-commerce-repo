package com.mycomp.e_commerce.store.repository;

import com.mycomp.e_commerce.store.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
