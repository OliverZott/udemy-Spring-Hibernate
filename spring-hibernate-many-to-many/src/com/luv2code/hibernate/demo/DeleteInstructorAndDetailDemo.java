package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteInstructorAndDetailDemo {


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


            InstructorDetail tmpDetail = session.get(InstructorDetail.class, 2);
            // tmpDetail.getInstructor().setInstructorDetail(null);
            session.delete(tmpDetail);


            // this solution is not working ?!?!
            /*
            Query query = session.createQuery("delete InstructorDetail where id= :tmpId");
            query.setParameter("tmpId", 3);
            query.executeUpdate();
            //*/


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
