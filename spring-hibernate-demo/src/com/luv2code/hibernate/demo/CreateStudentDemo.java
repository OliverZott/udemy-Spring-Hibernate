package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentDemo {



    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Daffy", "Duck", "duffyD@ente.com"));
        studentList.add(new Student("John", "Wick", "duffyD@mail.org"));
        studentList.add(new Student("Olli", "Zwu", "OZ@velosaurus.com"));
        studentList.add(new Student("Lena", "Zwu", "LZ@velosaurus.com"));

        // use session object to sava POJO
        try (sessionFactory) {

            // create session object
            Session session = sessionFactory.getCurrentSession();

            // create student object (POJO)
            Student newStudent = new Student("John", "Doe", "john_d@mail.com");

            // start transaction
            session.beginTransaction();

            // save pojo
            for (Student student : studentList) {
                session.save(student);
            }


            // commit transaction
            session.getTransaction().commit();

        }

    }

}
