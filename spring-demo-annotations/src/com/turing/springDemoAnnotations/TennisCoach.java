package com.turing.springDemoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside my doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside my doMyCleanupStuff()");
    }

    // define my destroy method

    /*
        So,
        - first we are adding the dependency injection with TennisCoach - constructor dependency injection.
        - second we can add the dependency injection
     */
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        this.fortuneService = fortuneService;
    }

    public TennisCoach() {
        System.out.println(">> TennisCoach inside default constructor");
    }

    // define a setter method
//    @Autowired
//    @Qualifier("randomFortuneService")
//    public void doSomeCrazyStuff(FortuneService theFortuneService) {
//        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
//        fortuneService = theFortuneService;
//    }


    @Override
    public String getDailyWorkout() {
        return "Practice your backend volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
