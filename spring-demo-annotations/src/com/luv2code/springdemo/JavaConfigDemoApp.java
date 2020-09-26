package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get bean from string container
        SkiCoach theCoach = context.getBean("SKI", SkiCoach.class);

        // call method on the bean
        System.out.println(theCoach.sayName());
        System.out.println(theCoach.getDailyFortune());

        // close context
        context.close();

    }

}
