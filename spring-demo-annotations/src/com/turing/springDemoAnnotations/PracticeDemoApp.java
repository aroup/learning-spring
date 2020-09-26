package com.turing.springDemoAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeDemoApp {
    public static void main(String[] args) {
        // read spring java config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        PracticeCoach theCoach = context.getBean("practiceCoach", PracticeCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}

