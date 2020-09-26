package com.turing.springDemoAnnotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of strings.
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "The journey is the reward",
            "Diligence is the mother of good luck"
    };

    // pick a random string from the array.
    private Random myRandom = new Random();
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;
    }


}
