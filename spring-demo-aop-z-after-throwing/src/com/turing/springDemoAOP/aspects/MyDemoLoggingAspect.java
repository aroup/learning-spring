package com.turing.springDemoAOP.aspects;

import com.turing.springDemoAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.turing.springDemoAOP.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        System.out.println("\n==========>>> Executing @AfterThrowing advice on addAccount()");
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature: " + methodSig);
        // log the exception

        System.out.println("\n======> The exception is: " + theExc);
    }

    @Before("com.turing.springDemoAOP.aspects.AOPPointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n==========>>> Executing @Before advice on addAccount()");

        /*
            Display the method signature
            Display the method arguments
        */

        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature: " + methodSig);

        Object[] args = theJoinPoint.getArgs();
        for(Object tempArg: args) {
            System.out.println(tempArg);

            if(tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }


    /*
        Add a new advice for @AfterReturning on the findAccounts Method
    */

    @AfterReturning(pointcut = "execution(* com.turing.springDemoAOP.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===========>>> Executing @After Returning on method: " + method);
        System.out.println("\n===========>>> Result is: " + result);

        // let's post process the data and modify it.
        convertAccountNamesToUpperCase(result);

        System.out.println("\n===========>>> Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for(Account tempAccount: result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }
}
