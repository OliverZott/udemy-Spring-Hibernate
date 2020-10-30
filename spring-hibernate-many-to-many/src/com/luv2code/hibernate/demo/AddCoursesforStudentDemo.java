package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesforStudentDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        //noinspection TryFinallyCanBeTryWithResources
        try {
            session.beginTransaction();


            // get specific student from DB
            Student tempStudent = session.get(Student.class, 1);
            System.out.println("Student: " + tempStudent);
            System.out.println("Courses of the student: " + tempStudent.getCourses());

            // create courses
            Course tempCourse1 = new Course("Tennis-Course");
            Course tempCourse2 = new Course("PingPong-Course");

            // add student to course
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            session.save(tempCourse1);
            session.save(tempCourse2);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
