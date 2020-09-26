package com.turing.setupdev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeDemoApp {

    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach myCoach = context.getBean("myGolfCoach",Coach.class);
        Coach alphaCoach = context.getBean("myGolfCoach", Coach.class);

        // check if they are the same
        boolean result = (myCoach == alphaCoach);
        // print out the results

        System.out.println("Pointing to the same object " + result);
        System.out.println("Memory location for the Coach " + myCoach);
        System.out.println("Memory location for alphaCoach " + alphaCoach);

        // close the context
        context.close();
    }


}
