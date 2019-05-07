package com.seniorproject.server;

import java.util.List;
import java.util.Optional;

import com.seniorproject.dto.Vote;
import com.seniorproject.server.repository.VoteRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteRepository repository;

    @ApiOperation(value="get all Votes", response=Vote.class, responseContainer="List")
    @ApiResponses(value={
        @ApiResponse(code=200,message="All Votes returned",response=Vote.class, responseContainer = "List"),
        @ApiResponse(code=500,message="Internal Server Error")
    })
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Vote> getGroups(){
        return repository.findAll();
    }

    @ApiOperation(value="gets a vote", response=Vote.class)
    @ApiResponses(value={
        @ApiResponse(code=200,message="Vote found",response=Vote.class),
        @ApiResponse(code=404,message="Vote not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/getVote/{Id}")
    @ResponseBody
    Optional<Vote> findByUserIdAndPollId(@PathVariable String userId, String pollId) {
        return repository.findByUserIdAndPollId(userId, pollId);
    }
}