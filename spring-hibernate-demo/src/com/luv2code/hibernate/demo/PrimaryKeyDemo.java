package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

public class PrimaryKeyDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try (sessionFactory) {

            Session session = sessionFactory.getCurrentSession();

            Student newStudent = new Student("John", "Wick", "JW@mail.com", DateUtils.parseDate("23/011/1974"));

            session.beginTransaction();
            session.save(newStudent);
            session.getTransaction().commit();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
