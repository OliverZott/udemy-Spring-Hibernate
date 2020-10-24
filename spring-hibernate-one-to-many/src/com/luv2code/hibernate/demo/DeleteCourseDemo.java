package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
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
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        //noinspection TryFinallyCanBeTryWithResources
        try {
            session.beginTransaction();

            // Hibernate Query Language (HQL) version for more flexibility (conditions)
            //
            Query query = session.createQuery("delete Course where id= :tmpId");
            query.setParameter("tmpId", 11);
            query.executeUpdate();


            //
            Course tmpCourse = session.get(Course.class, 13);
            session.delete(tmpCourse);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
