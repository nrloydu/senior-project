package com.seniorproject.repository;

import java.util.List;

//needs the right maven dependency to import CrudRepository
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.dto.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByName(String name);
    public List<User> findByEmail(String email);
}