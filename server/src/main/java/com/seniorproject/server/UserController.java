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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @ApiOperation(value="get all users", response=User.class, responseContainer="List")
    @ApiResponses(value={
        @ApiResponse(code=200,message="All users returned",response=User.class, responseContainer = "List"),
        @ApiResponse(code=500,message="Internal Server Error")
    })
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<User> getUsers(){
        return repository.findAll();
    }

    @ApiOperation(value="gets a specific user", response=User.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="User found",response=User.class),
        @ApiResponse(code=404,message="User not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{userId}")
    @ResponseBody
    Optional<User> getUser(@PathVariable String userId) {
        return repository.findById(userId);
    }

    @ApiOperation(value="gets a user by name", response=User.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="User found",response=User.class),
        @ApiResponse(code=404,message="User not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/getUserByName/{name}")
    @ResponseBody
    User getUserByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @ApiOperation(value="gets a user by email address", response=User.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="User found",response=User.class),
        @ApiResponse(code=404,message="User not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/getUserByEmail/{email}")
    @ResponseBody
    User getUserByEmail(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @ApiOperation(value="Creates a new user and returns the record", response=User.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="Create user",response=User.class),
        @ApiResponse(code=500,message="Internal server error")
    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    User add(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @ApiOperation(value="deletes a specific user by id")
    @ApiResponses(value={
        @ApiResponse(code=200,message="User found and deleted"),
        @ApiResponse(code=404,message="User not found")
    })
    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    @ResponseBody
    void delete(@PathVariable String userId) {
        repository.deleteById(userId);
    }
}
