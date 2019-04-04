package com.seniorproject.dto;

public class Vote {

    private final long id;
    private final long userId;
    private final long pollId;
    private final long pollOptionId;
    private final Boolean hasVoted;

    public Vote(long id, long userId, long pollId, long pollOptionId, Boolean hasVoted) {
        this.id = id;
        this.userId = userId;
        this.pollId = pollId;
        this.pollOptionId = pollOptionId;
        this.hasVoted = hasVoted;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getPollId() {
        return pollId;
    }

    public long getPollOptionId() {
        return pollOptionId;
    }

    public Boolean getHasVoted() {
        return hasVoted;
    }
    
}