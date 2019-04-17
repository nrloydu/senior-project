package com.seniorproject.server;

import java.util.List;
import java.util.Optional;

import com.seniorproject.dto.User;
import com.seniorproject.server.repository.UserRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<User> getUsers(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{userId}")
    @ResponseBody
    Optional<User> getUser(@PathVariable String userId) {
        return repository.findById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByName/{name}")
    @ResponseBody
    User getUserByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByEmail/{email}")
    @ResponseBody
    User getUserByEmail(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    User add(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    @ResponseBody
    void delete(@PathVariable String userId) {
        repository.deleteById(userId);
    }
}