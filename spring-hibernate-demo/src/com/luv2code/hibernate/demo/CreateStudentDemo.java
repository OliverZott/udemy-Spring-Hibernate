package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateStudentDemo {


    public static void main(String[] args) throws ParseException {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        String dateString = "07/09/2019";
        Date theDateOfBirth = DateUtils.parseDate(dateString);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Sigi", "Zwu", "siggiii@verlosaurus.com", theDateOfBirth));
        // studentList.add(new Student("John", "Wick", "duffyD@mail.org"));
        // studentList.add(new Student("Olli", "Zwu", "OZ@velosaurus.com"));
        // studentList.add(new Student("Lena", "Zwu", "LZ@velosaurus.com"));

        // use session object to sava POJO
        try (sessionFactory) {

            // create session object
            Session session = sessionFactory.getCurrentSession();

            // create student object (POJO)
            Student newStudent = new Student("John", "Doe", "john_d@mail.com", theDateOfBirth);

            // start transaction
            session.beginTransaction();

            // save pojo
            for (Student student : studentList) {
                int id = (int) session.save(student);
                System.out.println("\n\n ID from return value: " + id);
            }


            // commit transaction
            session.getTransaction().commit();

        }

    }

}
