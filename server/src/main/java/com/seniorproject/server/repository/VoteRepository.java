package com.seniorproject.server.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.dto.Vote;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {
    public Optional<Vote> findByUserIdAndPollId(String userId, String pollId);
}