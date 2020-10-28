package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        try (sessionFactory) {

            Session session = sessionFactory.getCurrentSession();

            // create objects
            Instructor tempInstructor =
                    new Instructor("Ollgu", "Zwu", "ollgu@verlosaurus.org");

            /*
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("htp://www.velosaurus.org", "Shredding");

            Course tmpCourse = new Course("Corners Technics");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

             */
            session.beginTransaction();


            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();
        }
    }

}
