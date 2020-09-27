package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private final FortuneService fortuneService;

    // Field level injection
    @Value("${swim.email}")
    private String email;

    @Value("${swim.team}")
    private String team;

    // Constructor Injection
    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim some length.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }
}
