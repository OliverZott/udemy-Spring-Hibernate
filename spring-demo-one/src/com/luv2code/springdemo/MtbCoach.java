package com.luv2code.springdemo;

public class MtbCoach implements Coach {

    private RandomFortuneService rndFortune;

    public MtbCoach() {    }

    public MtbCoach(RandomFortuneService rndFortune) {
        this.rndFortune = rndFortune;
    }

    @Override
    public String getDailyWorkout() {
        return "MTB-Guide speaking, you should train bunny hop ;)";
    }

    @Override
    public String getDailyFortune() {
        return rndFortune.getFortune();
    }
}
