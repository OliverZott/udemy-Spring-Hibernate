package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from string container
        SkiCoach theCoach = context.getBean("SKI", SkiCoach.class);

        // call method on the bean
        System.out.println(theCoach.sayName());

        // close context
        context.close();

    }

}
