package com.seniorproject.server.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.dto.Poll;

@Repository
public interface PollRepository extends MongoRepository<Poll, String> {
    public Optional<Poll> findById(String id);
    public List<Poll> findByOwnerId(String ownerId);
    //public List<Poll> findByVoterIdInVoterIds(String voterId);
}