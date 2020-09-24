package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    private FortuneService fortune;

    //@Autowired
    public TennisCoach() {
        System.out.println(">> Inside  default constructor");
    }

/*    @Autowired
    public void setFortuneService(FortuneService fortune) {
        System.out.println(">> Inside  Setter");
        this.fortune = fortune;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortune.getFortune();
    }

}
