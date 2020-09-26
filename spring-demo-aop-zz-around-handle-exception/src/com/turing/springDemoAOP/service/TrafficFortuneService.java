package com.turing.springDemoAOP.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() {
        // simulate a delay
        // return a fortune
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect Heavy Traffic this morning!";
    }

    public String getFortune(boolean b) {
        if(b) {
            throw new RuntimeException("Major Accident! Highway is closed!");
        }
        return getFortune();
    }
}
