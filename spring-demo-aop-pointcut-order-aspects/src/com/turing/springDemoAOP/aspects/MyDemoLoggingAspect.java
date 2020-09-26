package com.turing.springDemoAOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {


    @Before("com.turing.springDemoAOP.aspects.AOPPointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> Executing @Before advice on addAccount()");
    }


}
