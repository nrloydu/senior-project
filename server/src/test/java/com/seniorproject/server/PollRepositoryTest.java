package com.seniorproject.server;

//import com.seniorproject.dto.Poll;
import com.seniorproject.dto.User;
import com.seniorproject.server.repository.PollRepository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollRepositoryTest {
    
    //runs on production database, this should be changed
    @Autowired
    private PollRepository repository;

    @Before
    public void setUp() throws Exception {
        User user1 = new User("bob", "jackie", "bjackie@gmail.com", "bobpassword", "bobtoken");
        //Poll poll1 = new Poll(user1.getId(), "on Monday", "shall we go to the meeting?", 1556662425, ["yes","no"]);
    }
}