package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

            int theId = 2;
            query.setParameter("theInstructorId", theId);

            Instructor dbInstructor = query.getSingleResult();


            System.out.println("\nInstructor: " + dbInstructor);

            session.getTransaction().commit();
            session.close();


            // To make Lazy Loading work after closing Session:
            // 1. Getter while session is open
            // 2. FETCH JOIN --> FetchJoinDemo.java
            //
            System.out.println("\nCourses of specific instructor: " + dbInstructor.getCourses());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
