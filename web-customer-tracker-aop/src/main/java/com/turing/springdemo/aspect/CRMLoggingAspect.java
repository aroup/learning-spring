package com.turing.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class  CRMLoggingAspect {
    /*
        Setup logger
        setup Pointcut declaration
        add @Before advice
        add @AfterReturning advice
    */

    private final Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.turing.springdemo.controller.*.*(..))")
    private void forControllerPackage () {}

    @Pointcut("execution(* com.turing.springdemo.service.*.*(..))")
    private void forServicePackage () {}

    @Pointcut("execution(* com.turing.springdemo.dao.*.*(..))")
    private void forDaoPackage () {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        /*
            Display method we are calling
            display the arguments to the method
        */
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====> Before method" + theMethod);

        Object[] args = theJoinPoint.getArgs();
        for(Object tempArg: args) {
            myLogger.info("\n======> Argument: " + tempArg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        /*
            display method we are returning from
            display data returned
        */
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=========> AfterReturning:" + theMethod);

        myLogger.info("======> result:" + theResult);
    }
}
