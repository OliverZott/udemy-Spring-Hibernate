package com.luv2code.springdemo;

public class CricketCoach implements Coach {

    private String emailAddress;
    private String team;
    private FortuneService fortuneService;

    // no-arg constructor for spring bean-reference
    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor.");
    }

    /*
    Setter methods for injection (happening in config xml)
     */
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: Setter-Injection");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter-method for email");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter-method for team");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Cricked Coach here: do some workout buddy";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
