package com.luv2code.springdemo;

public class SwimCoach implements Coach {

    private final FortuneService fortuneService;

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
}
