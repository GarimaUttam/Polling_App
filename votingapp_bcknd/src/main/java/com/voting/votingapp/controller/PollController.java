package com.voting.votingapp.controller;

import com.voting.votingapp.model.Poll;
import com.voting.votingapp.services.PollService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        Poll createdPoll = pollService.createPoll(poll);
        return ResponseEntity.ok(createdPoll); // Ensures correct JSON response
    }

    @GetMapping
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }
}
