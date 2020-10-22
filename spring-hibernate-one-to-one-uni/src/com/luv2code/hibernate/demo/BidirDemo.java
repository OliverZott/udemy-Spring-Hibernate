package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BidirDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        try (sessionFactory) {

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            // get instructor-detail entity-instance
            int id = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            Instructor instructor = instructorDetail.getInstructor();

            // get instructor-detail entity-instance (Query - Version)

            List instArray;
            instArray = session.createQuery("from InstructorDetail i where id=3").getResultList();
            Instructor instructor2 = instructorDetail.getInstructor();

            System.out.println("\n\nInstructor Detail: " + instArray.get(0));
            System.out.println("\n\nInstructor : " + instructor2);

            session.getTransaction().commit();

        }

    }

}
