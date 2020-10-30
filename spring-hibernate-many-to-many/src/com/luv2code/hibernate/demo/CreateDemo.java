package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        //noinspection TryFinallyCanBeTryWithResources
        try {
            session.beginTransaction();


            Instructor tempInstructor = new Instructor("Olli", "Zott", "olli@velosaurus.org");
            Course tempCourse = new Course("Alpine-Advanced");
            Review tempReview = new Review("This Alpine-expert course is awesome as HELL!");
            Student tmpStudent1 = new Student("Max", "Power", "max.power@mail.com");
            Student tmpStudent2 = new Student("Sigi", "Zwu", "sigbert@mail.com");

            tempCourse.addStudent(tmpStudent1);
            tempCourse.addStudent(tmpStudent2);

            /*
            tempCourse.addReview(tempReview);
            tempCourse.addReview(new Review("Nice alpine bike experience."));
            tempCourse.addReview(new Review("Shitload of fun!!!"));
            */

            // Due to Cascading in course-entity also reviews will be stored!
            session.persist(tempCourse);

            // session.save(tempInstructor);DeleteCourseDemo
            // session.save(tempReview);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
