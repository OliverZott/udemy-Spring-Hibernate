package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session;

        try(sessionFactory){

            int studentId = 2;

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set  email='JW@mail.wick' where firstName='John'");
            session.getTransaction().commit();


            // begin transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();


            Student student = session.get(Student.class, studentId);

            student.setFirstName("Dagobert (changed)");
            student.setEmail("Dagobert.D@entenhausen.orf");

            // commit, without using any "update" functionality (just changed Entity)
            session.getTransaction().commit();


            /*
            Next Update multiple DB-Objects
            Retrieve session object again
             */
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set  email='JW@mail.wick' where firstName='John'");
            session.getTransaction().commit();


        }


    }
}
