package com.turing.springDemoAOP;

import com.turing.springDemoAOP.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO =  context.getBean("accountDAO", AccountDAO.class);
        List<Account> theAccounts = null;
        try {
            theAccounts = theAccountDAO.findAccounts(false);
        } catch (Exception exc) {
            System.out.println("\n\n Main Program: Caught Exception");
        }
        System.out.println("\n\nMain Program: After Throwing Demo App:");
        System.out.println("-------------");
        System.out.println(theAccounts);
        System.out.println("\n\n");
        context.close();
    }
}
