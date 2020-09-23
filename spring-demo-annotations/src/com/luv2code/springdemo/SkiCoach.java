package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SkiCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "More Pooooowwwwder!";
    }
}
