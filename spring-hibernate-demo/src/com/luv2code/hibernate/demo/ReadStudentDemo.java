package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();


            String dateString = "07/09/2019";
            Date theDateOfBirth = DateUtils.parseDate(dateString);

            Student putStudent = new Student("Donald", "Duck", "dd@entenhausen.org", theDateOfBirth);
            System.out.printf("\nNew Student %s with initial ID=%s", putStudent.getFirstName(), putStudent.getId());

            session.beginTransaction();
            session.save(putStudent);
            System.out.printf("\nNew Students id after 'save': %s", putStudent.getId());
            System.out.println("\n RAW: "+ putStudent);

            session.getTransaction().commit();


            /*
             * Retrieve object form DB
             * Transaction correspond queries
             */
            // new session and start transaction
            Session session2 = sessionFactory.getCurrentSession();
            session2.beginTransaction();

            // retrieve student, based on id
            System.out.println("\nGetting student with id: " + putStudent.getId());
            Student retrievedStudent = session2.get(Student.class, putStudent.getId());

            // commit transaction
            session2.getTransaction().commit();

            System.out.println("\n" + retrievedStudent.toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
