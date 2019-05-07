package com.seniorproject.server;

import java.util.List;
import java.util.Optional;

import com.seniorproject.dto.Group;
import com.seniorproject.server.repository.GroupRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

/*import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/


@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository repository;

    /*@ApiOperation(value="get all groups", response=Group.class, responseContainer="List")
    @ApiResponses(value={
        @ApiResponse(code=200,message="All Groups returned",response=Group.class, responseContainer = "List"),
        @ApiResponse(code=500,message="Internal Server Error")
    })*/
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Group> getGroups(){
        return repository.findAll();
    }

    /*@ApiOperation(value="gets a group", response=Group.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="Group found",response=Group.class),
        @ApiResponse(code=404,message="Group not found")
    })*/
    @RequestMapping(method = RequestMethod.GET, value = "/getGroup/{groupId}")
    @ResponseBody
    Optional<Group> getGroup(@PathVariable String groupId) {
        return repository.findById(groupId);
    }

    /*@ApiOperation(value="gets a group by name", response=Group.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="Group found",response=Group.class),
        @ApiResponse(code=404,message="Group not found")
    })*/
    @RequestMapping(method = RequestMethod.GET, value = "/getUserByName/{groupName}")
    @ResponseBody
    Group getGroupByName(@PathVariable String groupName) {
        return repository.findByGroupName(groupName);
    }

    /*@ApiOperation(value="get a list of groups by userId", response=Group.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="Groups found",response=Group.class),
        @ApiResponse(code=404,message="Groups not found")
    })*/
    /*@RequestMapping(method = RequestMethod.GET, value = "/getUserByName/{groupName}")
    @ResponseBody
    List<Group> getGroupsByUserId(@PathVariable String userId) {
        return repository.findByUserId(userId);
    }*/

    /*@ApiOperation(value="deletes a specific group by id")
    @ApiResponses(value={
        @ApiResponse(code=200,message="Group found and deleted"),
        @ApiResponse(code=404,message="Group not found")
    })*/
    @RequestMapping(method = RequestMethod.DELETE, value = "{groupId}")
    void delete(@PathVariable String groupId) {
        repository.deleteById(groupId);
    }
}