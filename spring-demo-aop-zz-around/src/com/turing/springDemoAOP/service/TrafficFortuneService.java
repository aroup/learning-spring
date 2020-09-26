package com.turing.springDemoAOP.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() throws InterruptedException {
        // simulate a delay
        // return a fortune
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect Heavy Traffic this morning!";
    }
}
