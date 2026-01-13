package com.vonnue.bestdrink.bestdrink.controller;

import com.vonnue.bestdrink.bestdrink.model.Response;
import com.vonnue.bestdrink.bestdrink.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
@CrossOrigin(origins = "*")
public class VoteController {

    @Autowired
    Vote vote;

    @RequestMapping("/vote")
    public Vote postVote(@RequestParam String option) {

        if(option.strip().toLowerCase().equalsIgnoreCase("coffee")) {
            vote.setCoffee(vote.getCoffee() + 1);
        } else if(option.strip().toLowerCase().equalsIgnoreCase("tea")) {
            vote.setTea(vote.getTea() + 1);
        }
        System.out.println("vote updated");

        return vote;
    }

    @GetMapping("/msg")
    public Response leadingMessage(){
        if(vote.getCoffee() > vote.getTea()) {
            return new Response("Coffee is leading by " + (vote.getCoffee() - vote.getTea()) + " votes");
        } else if(vote.getTea() > vote.getCoffee()) {
            return new Response("tea is leading by " + (vote.getTea() - vote.getCoffee()) + " votes");
        } else {
            return new Response("its a tie !");
        }
    }

}
