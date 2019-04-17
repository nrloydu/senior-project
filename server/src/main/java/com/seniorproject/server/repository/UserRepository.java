package com.seniorproject.server.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.dto.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findById(String id);
    public User findByName(String name);
    public User findByEmail(String email);
}