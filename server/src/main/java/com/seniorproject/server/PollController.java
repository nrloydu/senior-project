package com.seniorproject.server;

import java.util.List;
import java.util.Optional;

import com.seniorproject.dto.Poll;
import com.seniorproject.server.repository.PollRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Poll> getPolls(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPoll/{pollId}")
    @ResponseBody
    Optional<Poll> getPoll(@PathVariable String pollId) {
        return repository.findById(pollId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPollsFrom/{ownerId}")
    @ResponseBody
    List<Poll> getPollsByOwner(@PathVariable String ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPollsForUser/{userId}")
    @ResponseBody
    List<Poll> getPollsByVoter(@PathVariable String userId) {
        return repository.findByVoterIds(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    Poll add(@RequestBody Poll newPoll) {
        return repository.save(newPoll);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{pollId}")
    void delete(@PathVariable String pollId) {
        repository.deleteById(pollId);
    }
}