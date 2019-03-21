package com.seniorproject.dto;

public class Poll {

    private final long id;
    private final long ownerId;
    private final String question;
    private final String pollTitle;
    private final long deadline;    // Epoch time.

    public Poll(long id, long ownerId, String question, String pollTitle, long deadline ) {
        this.id = id;
        this.ownerId = ownerId;
        this.question = question;
        this.pollTitle = pollTitle;
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getQuestion() {
        return question;
    }

    public String getPollTitle() {
        return pollTitle;
    }

    public long getDeadline() {
        return deadline;
    }
}
