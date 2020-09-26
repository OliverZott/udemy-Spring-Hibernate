package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve been from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if the same object
        boolean result = (theCoach == alphaCoach);
        System.out.println("Same coach instance: " + result);
        System.out.println("Memory Location: " + theCoach);
        System.out.println("Memory Location: " + alphaCoach);

    }
}
