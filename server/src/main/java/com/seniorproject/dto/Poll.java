package com.seniorproject.dto;

import java.util.Arrays;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Poll {

    /*public static class PollOption {

        private final String optionText;
        private final long numVotes;
    
        public PollOption(String optionText) {
            this.optionText = optionText;
            this.numVotes = 0;
        }
    
        public String getOptionText() {
            return optionText;
        }
    
        public long getNumVotes() {
            return numVotes;
        }
    
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    private final String ownerId;
    private final String question;
    private final String pollTitle;
    private final long deadline;    // Epoch time.
    private String[] optionTexts;
    private int[] voteCounts;
    //private PollOption[] options;
    private String[] voterIds;


    public Poll(String ownerId, String question, String pollTitle, long deadline, String[] optionTexts, int[] voteCounts, String[] voterIds) {
        this.ownerId = ownerId;
        this.question = question;
        this.pollTitle = pollTitle;
        this.deadline = deadline;
        this.optionTexts = optionTexts;
        this.voteCounts = voteCounts;
        /*this.options = new PollOption[optionTexts.length];
        for(int i = 0; i < optionTexts.length; i++) {
            options[i] = new PollOption(optionTexts[i]);
        }*/
        this.voterIds = voterIds;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
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

    public String[] getOptionTexts() {
        return optionTexts;
    }

    public int[] getVoteCounts() {
        return voteCounts;
    }

    /*public PollOption[] getOptions() {
        return options;
    }*/

    public String[] getVoterIds(){
        return voterIds;
    }
}
