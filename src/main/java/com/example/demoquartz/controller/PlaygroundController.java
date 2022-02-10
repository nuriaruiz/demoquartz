package com.example.demoquartz.controller;

import com.example.demoquartz.playground.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {

    private PlaygroundService playgroundService;

    @Autowired
    public PlaygroundController(PlaygroundService playgroundService){
        this.playgroundService = playgroundService;
    }

    @PostMapping("/runHelloWorld")
    public void runHelloWorld(){
        playgroundService.runHelloWorldJob();
    }
}

