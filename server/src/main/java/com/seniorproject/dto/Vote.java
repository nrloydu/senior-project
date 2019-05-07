package com.seniorproject.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Document(collection = "groups")
@TypeAlias("group")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String userId;
    private String pollId;
    private String pollOptionId;
    private Boolean hasVoted;

    
    public Vote(String userId, String pollId, Boolean hasVoted) {
        this.userId = userId;
        this.pollId = pollId;
        this.hasVoted = false;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPollId() {
        return pollId;
    }

    public String getPollOptionId() {
        return pollOptionId;
    }

    public Boolean getHasVoted() {
        return hasVoted;
    }
    
}