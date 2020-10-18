package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session;

        try (sessionFactory) {

            int studentId = 4;

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            // System.out.println("\n\nDeleting: " + student);
            // session.delete(student);

            session.createQuery("delete from Student where id=5").executeUpdate();
            session.getTransaction().commit();

        }


    }
}
