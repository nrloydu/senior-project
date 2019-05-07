package com.seniorproject.server;

import com.seniorproject.dto.User;
import com.seniorproject.server.repository.UserRepository;

import java.util.Optional;

import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    //runs on production database, this should be changed
    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        User user1 = new User("bob", "johnson", "bob@gmail.com", "passwordbob", "bobtoken");
        User user2 = new User("jan", "stevenson", "jsteven@gmail.com", "passwordjan", "jantoken");
        assertNull(user1.getId());
        assertNull(user2.getId());
        this.repository.save(user1);
        this.repository.save(user2);
    }

    @Test
    public void testFetchData(){
        User userA = repository.findByFirstName("bob");
        assertNotNull(userA);
        Optional<User> userB = repository.findById("1");
        assertNotNull(userB);
        User userC = repository.findByEmail("jan@hotmail.com");
        assertNotNull(userC);
        List<User> users = repository.findAll();
        assertEquals(users.size(), 2);
        
    }

    @After
    public void tearDown() throws Exception {
        this.repository.deleteAll();
    }
}