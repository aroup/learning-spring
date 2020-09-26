package com.turing.springboot.applicationproperties.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + " Team name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on the server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a 5K hard!";
    }

    @GetMapping("fortune")
    public String getDailyFortune() {
        return "Wish you good luck!";
    }
}
