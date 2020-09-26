package com.turing.springDemoAOP;

import com.turing.springDemoAOP.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static final Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Main Program: Around Demo App");
        myLogger.info("Calling getFortune:");

        String data = theFortuneService.getFortune(true);
        myLogger.info("My Fortune is: " + data);
        myLogger.info("Finished");

        context.close();
    }
}
