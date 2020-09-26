package com.turing.springDemoAnnotations;


public class PracticeFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Get good results in your practice";
    }
}
