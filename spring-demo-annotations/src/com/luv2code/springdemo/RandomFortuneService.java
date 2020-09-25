package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements  FortuneService {

    // create an array of strings
    private String[] data = {
            "message 1 in array",
            "message 2 in array",
            "message 3 in array",
    };

    // create a random number generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        return data[index];
    }
}
