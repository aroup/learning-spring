package com.turing.setupdev;

public class GymCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Get some burpees";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
