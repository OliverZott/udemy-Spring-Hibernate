package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteCourseDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        //noinspection TryFinallyCanBeTryWithResources
        try {
            session.beginTransaction();

            Course tmpCourse = session.get(Course.class, 11);
            System.out.println(tmpCourse);
            session.delete(tmpCourse);
            System.out.println("Deleted course successfully!");




            // this solution is not working ?!?!
            /*
            Query query = session.createQuery("delete Course where id= :tmpId");
            query.setParameter("tmpId", 10);
            query.executeUpdate();
            */

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
