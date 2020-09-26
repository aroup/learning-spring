package com.turing.springDemoAOP.dao;

import com.turing.springDemoAOP.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public String getName() {
        System.out.println(getClass() + " getName is being called");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName is being called");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode is being called");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode is being called");
        this.serviceCode = serviceCode;
    }

    private String name;
    private String serviceCode;


    public void addAccount(Account theAccount, Boolean vipFlag) {
        System.out.println(getClass() + " Doing my DB Work: Adding an account!");
    }

    public boolean doWork() {
        System.out.println(getClass() + " doWork()");
        return false;
    }
}
