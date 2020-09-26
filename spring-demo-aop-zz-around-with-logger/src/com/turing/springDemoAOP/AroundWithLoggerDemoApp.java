package com.turing.springDemoAOP;

import com.turing.springDemoAOP.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static final Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Main Program: Around Demo App");
        myLogger.info("Calling getFortune:");
        String data = theFortuneService.getFortune();
        myLogger.info("My Fortune is: " + data);
        myLogger.info("Finished");

        context.close();
    }
}
