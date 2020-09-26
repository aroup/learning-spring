package com.turing.springDemoAOP;

import com.turing.springDemoAOP.dao.AccountDAO;
import com.turing.springDemoAOP.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("Main Program: Around Demo App");
        System.out.println("Calling getFortune:");
        String data = theFortuneService.getFortune();
        System.out.println("My Fortune is: " + data);
        System.out.println("Finished");

        context.close();
    }
}
