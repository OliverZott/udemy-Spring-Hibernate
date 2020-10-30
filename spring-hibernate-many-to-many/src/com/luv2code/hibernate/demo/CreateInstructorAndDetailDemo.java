package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorAndDetailDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


            Instructor tempInstructor =
                    new Instructor("Olli", "Zott", "olli@verlosaurus.org");

            InstructorDetail tempDetail =
                    new InstructorDetail("velosaurus.com", "Biking and Programming");

            // Course tempCourse = new Course("Bikepark-Beginner");

            tempInstructor.setInstructorDetail(tempDetail);


            session.save(tempInstructor);
            session.getTransaction().commit();
        }
    }

}
