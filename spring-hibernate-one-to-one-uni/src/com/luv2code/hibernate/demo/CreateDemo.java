package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {


    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        // use session object to sava POJO
        try (sessionFactory) {

            // create session object
            Session session = sessionFactory.getCurrentSession();

            // create objects
            Instructor tempInstructor =
                    new Instructor("Siggi", "Zwu", "sigbert@verlosaurus.org");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("htp://Siggi.org/FTW", "Shredding");

            // Associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start transaction
            session.beginTransaction();

            // save instructor
            //
            // Note: Will ALSO save detail-object because
            // of 'CascadeType.ALL'
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);


            // commit transaction
            session.getTransaction().commit();

        }

    }

}
