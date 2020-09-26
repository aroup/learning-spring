package com.turing.springDemoAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public Boolean addSillyMember() {
        System.out.println(getClass() + ":Doing some stuff right now!");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + " going to sleep right now...");
    }
}
