package com.seniorproject.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@TypeAlias("user")
public class User {

    @Id
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
