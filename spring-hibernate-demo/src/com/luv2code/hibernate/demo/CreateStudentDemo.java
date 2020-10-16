package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        // use session object to sava POJO
        try (sessionFactory) {

            // create session object
            Session session = sessionFactory.getCurrentSession();

            // create student object
            Student newStudent = new Student("Olli", "Zwuuu", "ollgu@velosaurus.com");

            // start transaction
            session.beginTransaction();

            // save pojo
            session.save(newStudent);

            // commit transaction
            session.getTransaction().commit();

        }

    }

}
