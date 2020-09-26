package com.turing.springDemoAOP.aspects;

import com.turing.springDemoAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {


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


}
