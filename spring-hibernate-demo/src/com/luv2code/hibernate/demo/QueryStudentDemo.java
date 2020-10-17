package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {


    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory) {

            session.beginTransaction();


            // create Query
            List<Student> studList = session.createQuery("from Student").getResultList();
            displayStudents(studList);

            studList = session.createQuery("from Student s where s.lastName='zwu' or s.email like '%org'").getResultList();
            displayStudents(studList);

            session.getTransaction().commit();


        }
    }


    private static void displayStudents(List<Student> studList) {
        for (Student stud : studList) {
            System.out.println(stud);
        }
    }

}
