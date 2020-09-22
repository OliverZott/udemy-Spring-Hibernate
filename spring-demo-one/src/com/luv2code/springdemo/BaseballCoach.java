package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

	// private field for dependency
	private FortuneService fortuneService;

	// define constructor for DI
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout( ) {
		return "'BaseballCoach here: 'Spend 30 min on batting practice.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


}
