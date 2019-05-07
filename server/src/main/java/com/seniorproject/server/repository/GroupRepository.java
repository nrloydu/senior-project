package com.seniorproject.server.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.dto.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {
    public Optional<Group> findById(String groupId);
    public Group findByName(String groupName);
    public List<Group> findByUserId(String userId);
}