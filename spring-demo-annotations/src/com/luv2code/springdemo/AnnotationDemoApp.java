package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from string container
        TennisCoach theCoach = context.getBean("thatSillyCoach", TennisCoach.class);

        // call method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // close context
        context.close();

    }

}
