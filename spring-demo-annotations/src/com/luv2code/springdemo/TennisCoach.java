package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    /**
     * Version 1: Qualifier outside Constructor
     */
    /*
    // If Qualifier used outside Constructor
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortune;

    @Autowired
    public TennisCoach() {
        System.out.println(">> Inside  default constructor of Tennis Coach");
    }
     */


    /**
     * Version 2: Qualifier inside Constructor
     */
    private final FortuneService fortune;

    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortune) {
        System.out.println(">> Inside  default constructor of Tennis Coach");
        this.fortune = fortune;
    }


    /**
     * Setter Injection
     */
    /*
    @Autowired
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
