package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {

	}

	/*
	Beans are just passed to constructor BUT NOT instantiated in our class!!
	 */
	public TrackCoach(FortuneService fortuneService) {
		System.out.println("Track coach constructor speaking");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "'TrackCoach' here: Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Track Coach speaking: " + fortuneService.getFortune();
	}

	// add init method
	public void doStartupStuff() {
		System.out.println("Tracking Coach: Init-Method");
	}

	// add destroy method
	public void doDestroyStuff() {
		System.out.println("Tracking Coach: Destroy-Method");
	}

}
