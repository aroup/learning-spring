package com.turing.springDemoAnnotations;

import org.springframework.stereotype.Component;

public class PracticeCoach implements Coach {
    private FortuneService fortuneService;

    public PracticeCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Get a good practice overall";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
