package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BidirDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            // READ single instructor-detail entity-instance
            /*
            int id = 18;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("\nInstructor: " + instructorDetail.getInstructor());
            System.out.println("\nInstructor Detail: " + instructorDetail);
             //*/


            // READ all instructor-detail entity-instance (Query - Version)
            /*
            List instArray;
            instArray = session.createQuery("from InstructorDetail").getResultList();
            instArray.stream().forEach(System.out::println);
            // System.out.println("\n\nInstructor Detail: " + instArray.get(1);
            //*/


            // DELETE cascade (single direction)
            //
            // remove association to break bi-dir link
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);

            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            //session.createQuery("delete from InstructorDetail where id=4").executeUpdate();
            //System.out.println("\nDeleted!");


            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
