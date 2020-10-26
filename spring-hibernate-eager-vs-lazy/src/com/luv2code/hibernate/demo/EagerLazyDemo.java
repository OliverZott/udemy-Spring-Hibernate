package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        //noinspection TryFinallyCanBeTryWithResources
        try {
            session.beginTransaction();

            // get single instructor
            Instructor dbInstructor = session.get(Instructor.class, 1);

            System.out.println("\nInstructor: " + dbInstructor);

            session.getTransaction().commit();
            session.close();


            // if lazy loading in "Instructor" courses, courses will be loaded here on demand!!
            System.out.println("\nCourses of specific instructor: " + dbInstructor.getCourses());

        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
