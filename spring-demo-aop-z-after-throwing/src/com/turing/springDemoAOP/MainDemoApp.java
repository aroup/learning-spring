package com.turing.springDemoAOP;

import com.turing.springDemoAOP.dao.AccountDAO;
import com.turing.springDemoAOP.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class  MainDemoApp {
    public static void main(String[] args) {
        /*
            Read the spring config java
            Get the bean from spring container
            Call the business Method
            Get the membership bean from the spring container
            Call the business Method
            Close the context
        */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO =  context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();
        Account myAccount = new Account();
        myAccount.setName("Aroup");
        myAccount.setLevel("Platinum");

        // setter method
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        // getter method
        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();
        context.close();
    }
}
