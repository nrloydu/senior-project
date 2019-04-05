package com.seniorproject.server;

import com.seniorproject.dto.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class UserController {

    @RequestMapping("/user")
    public User getUser(@RequestParam String username) {
        //this will access the database, for now it just returns a made-up user with the given name
        return new User(456, "Hello, " + username, "555");
    }

    /*@RequestMapping("/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
    }*/
    
    @RequestMapping("/userByEmail")
    public User getUserByEmail(@RequestParam String email) {
        //this will access the database, for now it just returns a made-up user with the given name
        return new User(456, "Hello, " + email, "555");
    }

    @RequestMapping("/userByGroup")
    public User getUserByGroup(@RequestParam String groupName) {
        //this will access the database, for now it just returns a made-up user with the given name
        return new User(456, "Hello, " + groupName, "555");
    }

    @RequestMapping("/addUser")
    public String addNewUser(@RequestParam long id, @RequestParam String username, @RequestParam String passwordHash) {
        
        //User n = new User(id, username, passwordHash);
        //add the user to the DB

        return "Saved";
    }
    

}