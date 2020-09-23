package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private final FortuneService fortune;

    //@Autowired
    public TennisCoach(FortuneService fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortune.getFortune();
    }

}
