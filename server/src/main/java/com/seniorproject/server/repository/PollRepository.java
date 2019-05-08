package com.seniorproject.server.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seniorproject.dto.Poll;

@Repository
public interface PollRepository extends MongoRepository<Poll, String> {
    public Optional<Poll> findById(String id);
    
    @Query("{ownerId: '?0'}")
    public List<Poll> findByOwnerId(String ownerId);



    @Query("{voterIds: '?0'}")
    public List<Poll> findByVoterIds(String voterId);

    /*@Override
    public List<Poll> findVoters(String voterId){
        Query query = new Query();
        query.addCriteria(Criteria.where())
    }*/
}