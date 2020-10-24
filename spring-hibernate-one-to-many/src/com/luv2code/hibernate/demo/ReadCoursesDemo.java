package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ReadCoursesDemo {


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

            // getResultList (generic usage not working?!)
            // https://stackoverflow.com/questions/13700565/jpa-query-getresultlist-use-in-a-generic-way
            @SuppressWarnings("unchecked") List<Instructor> instructorList = session.createQuery("from Instructor").getResultList();
            System.out.println("\nInstructor Database: \n");
            instructorList.forEach(System.out::println);

            Instructor dbInstructor = session.get(Instructor.class, 2);
            System.out.println("\nCourses of specific instructor: " + dbInstructor.getCourses());




            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
