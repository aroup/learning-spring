package com.turing.springDemoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    public void setFortuneService(@Qualifier("fileFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public PingPongCoach() {
        System.out.println(">> Ping pongCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Keep your eyes on the ball";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
