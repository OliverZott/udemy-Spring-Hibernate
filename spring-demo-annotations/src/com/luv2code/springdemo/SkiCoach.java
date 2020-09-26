package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SKI")
public class SkiCoach implements Coach {

    private final FortuneService fortuneService;

    // inject properties file using java annotations
    @Value("${foo.name}")
    private String name;

    @Autowired
    public SkiCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "More Pooooowwwwder!";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public String sayName() {
        return "Hey, it's me, SkiInstructor " + name;
    }
}
