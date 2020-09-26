package com.turing.springDemoAOP.dao;

import com.turing.springDemoAOP.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount, Boolean vipFlag) {
        System.out.println(getClass() + " Doing my DB Work: Adding an account!");
    }

    public boolean doWork() {
        System.out.println(getClass() + " doWork()");
        return false;
    }
}
