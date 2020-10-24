package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


            Course tempCourse1 = new Course("Bikepark-Session1");
            Course tempCourse2 = new Course("Programming-Basics");

            Instructor dbInstructor = session.get(Instructor.class, 2);
            dbInstructor.addCourse(tempCourse1);
            dbInstructor.addCourse(tempCourse2);


            System.out.println("\nCreating Course [" + tempCourse1 + tempCourse2 + "] and add to Instructor: " + dbInstructor);
            session.save(tempCourse1);
            session.save(tempCourse2);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
