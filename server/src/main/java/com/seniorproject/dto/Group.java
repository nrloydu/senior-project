package com.seniorproject.dto;

public class Group{

    private final long id;
    private final String groupName;

    public Group(long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }


}