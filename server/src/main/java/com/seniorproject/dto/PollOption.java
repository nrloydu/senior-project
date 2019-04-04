package com.seniorproject.dto;

public class PollOption {

    private final long id;
    private final long pollId;
    private final String optionText;
    private final long numVotes;

    public PollOption(long id, long pollId, String optionText, long numVotes) {
        this.id = id;
        this.pollId = pollId;
        this.optionText = optionText;
        this.numVotes = numVotes;
    }

    public long getId() {
        return id;
    }

    public long getPollId() {
        return pollId;
    }

    public String getOptionText() {
        return optionText;
    }

    public long getNumVotes() {
        return numVotes;
    }

}