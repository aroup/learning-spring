package com.turing.springDemoAOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class  MyApiAnalyticsAspect {
    @Before("com.turing.springDemoAOP.aspects.AOPPointcutExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=========>>> Performing API analytics");
    }
}

