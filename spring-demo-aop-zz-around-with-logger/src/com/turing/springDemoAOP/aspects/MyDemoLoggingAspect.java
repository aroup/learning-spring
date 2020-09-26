package com.turing.springDemoAOP.aspects;

import com.turing.springDemoAOP.Account;
import com.turing.springDemoAOP.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {


    private static final Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    @Around("execution(* com.turing.springDemoAOP.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        /*
            Print out method we are advising on
            Get begin timestamp
            now let's execute the method
            get end timestamp
            Compute and display the duration
        */
        myLogger.info("\n==========>>> Executing @Around advice");
        MethodSignature methodSig = (MethodSignature) theProceedingJoinPoint.getSignature();
        myLogger.info("Method Signature: " + methodSig);

        long begin = System.currentTimeMillis();
        Object result = theProceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration =  end - begin;
        myLogger.info("\n==========> Duration: " + duration/1000.0 + " seconds.");
        return result;
    }

    @After("execution(* com.turing.springDemoAOP.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n==========>>> Executing @After advice on findAccount()");
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method Signature: " + methodSig);
    }

    @AfterThrowing(pointcut = "execution(* com.turing.springDemoAOP.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        myLogger.info("\n==========>>> Executing @AfterThrowing advice on findAccounts()");
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method Signature: " + methodSig);
        // log the exception

        myLogger.info("\n======> The exception is: " + theExc);
    }

    @Before("com.turing.springDemoAOP.aspects.AOPPointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n==========>>> Executing @Before advice on addAccount()");

        /*
            Display the method signature
            Display the method arguments
        */

        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method Signature: " + methodSig);

        Object[] args = theJoinPoint.getArgs();
        for(Object tempArg: args) {
            myLogger.info((String) tempArg);

            if(tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                myLogger.info("account name: " + theAccount.getName());
                myLogger.info("account level: " + theAccount.getLevel());
            }
        }
    }


    /*
        Add a new advice for @AfterReturning on the findAccounts Method
    */

    @AfterReturning(pointcut = "execution(* com.turing.springDemoAOP.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n===========>>> Executing @After Returning on method: " + method);
        myLogger.info("\n===========>>> Result is: " + result);

        // let's post process the data and modify it.
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n===========>>> Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for(Account tempAccount: result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }
}
