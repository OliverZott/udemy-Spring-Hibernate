package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example for IoC via xml-legacy-method
 *
 * - Objects are managed and created elsewhere!
 *    -> id=myFortuneService will instantiate new FortuneService
 *    -> id=myCricketCoach will instantiate new CricketCoach and DI the FortuneService!!
 *
 * - DI is happening
 *
 */
public class HelloSpringApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring context
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // cal methods on the bean
        /* Usage of interface for type-safety
        https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5672766#overview
         */
        System.out.println("HelloSpringApp talking here: " + theCoach.getDailyWorkout());

        // call another method (including DI)
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();

    }
}
