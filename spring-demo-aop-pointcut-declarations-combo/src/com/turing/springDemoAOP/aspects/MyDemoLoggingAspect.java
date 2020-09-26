package com.turing.springDemoAOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution (* com.turing.springDemoAOP.dao.*.*(..))")
    private void forDaoPackage() {}

    // pointcut for getter method
    @Pointcut("execution (* com.turing.springDemoAOP.dao.*.get*(..))")
    private void getter() {}

    // pointcut for setter method
    @Pointcut("execution (* com.turing.springDemoAOP.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package... exclude getter and setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=========>>> Performing API analytics");
    }
}
