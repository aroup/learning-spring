package com.turing.springDemoAOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPPointcutExpressions {
    @Pointcut("execution (* com.turing.springDemoAOP.dao.*.*(..))")
    public void forDaoPackage() {}

    // pointcut for getter method
    @Pointcut("execution (* com.turing.springDemoAOP.dao.*.get*(..))")
    public void getter() {}

    // pointcut for setter method
    @Pointcut("execution (* com.turing.springDemoAOP.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package... exclude getter and setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
