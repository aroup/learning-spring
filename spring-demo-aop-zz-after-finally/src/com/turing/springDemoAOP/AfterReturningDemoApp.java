package com.turing.springDemoAOP;

import com.turing.springDemoAOP.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) throws Exception {
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
        List<Account> theAccounts = theAccountDAO.findAccounts(false);
        System.out.println("\n\nMain Program: After Returning Demo App:");
        System.out.println("-------------");
        System.out.println(theAccounts);
        System.out.println("\n\n");
        context.close();
    }
}
