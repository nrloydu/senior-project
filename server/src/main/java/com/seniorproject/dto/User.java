package com.seniorproject.dto;

public class User {

    private final long id;
    private final String name;
    private final String passwordHash;

    public User(long id, String name, String passwordHash ) {
        this.id = id;
        this.name = name;
        this.passwordHash = passwordHash;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
