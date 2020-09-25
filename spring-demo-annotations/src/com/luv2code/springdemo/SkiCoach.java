package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SKI")
public class SkiCoach implements Coach {


    // inject properties file using java annotations
    @Value("${foo.name}")
    private String name;


    @Override
    public String getDailyWorkout() {
        return "More Pooooowwwwder!";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    public String sayName() {
        return "Hey, it's me, " + name;
    }
}
