package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {


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

            // start transaction
            session.beginTransaction();


            // get entity-instance by id
            int theId = 2;
            Instructor instructor = session.get(Instructor.class, theId);
            System.out.println("Found Entity-Instance: " + instructor);
            System.out.println(instructor);

            // delete entity-instance
            //
            // Note: Will ALSO save detail-object because
            // of 'CascadeType.ALL'
            System.out.println("Deleting Entity-Instance.");

            if (instructor != null) {
                session.delete(instructor);
            } else {
                System.out.println("\n\n WTF");
            }




            // commit transaction
            session.getTransaction().commit();

        }

    }

}
