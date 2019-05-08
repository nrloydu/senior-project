package com.seniorproject.server;

import java.util.List;
import java.util.Optional;

import com.seniorproject.dto.Auth;
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

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByFirstName/{name}")
    @ResponseBody
    User getUserByFirstName(@PathVariable String name) {
        return repository.findByFirstName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByLastName/{name}")
    @ResponseBody
    User getUserByLastName(@PathVariable String name) {
        return repository.findByLastName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByFullName/{name}")
    @ResponseBody
    User getUserByFullName(@PathVariable String name) {
        return repository.findByFullName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByEmail/{email}")
    @ResponseBody
    User getUserByEmail(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    @ResponseBody
    User auth(@RequestBody Auth auth) {
        return repository.findByUsernameAndPassword(auth.getUsername(), auth.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseBody
    User register(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    @ResponseBody
    void delete(@PathVariable String userId) {
        repository.deleteById(userId);
    }
}
