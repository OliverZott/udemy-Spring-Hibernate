package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReadCoursesDemo {


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


            int theId = 13;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println(tempCourse.getReviews());  // Lazy Fetch... will get result here


            Query query = session.createQuery("from Course c where c.id=:theId");
            query.setParameter("theId", 13);
            Course tempCourse2 = (Course) query.getSingleResult();
            System.out.println(tempCourse2);


            //*
            // getResultList (generic usage not working?!)
            // https://stackoverflow.com/questions/13700565/jpa-query-getresultlist-use-in-a-generic-way
            @SuppressWarnings("unchecked") List<Review> reviewList = session.createQuery("from Review ").getResultList();
            System.out.println("\nInstructor Database: \n");
            reviewList.forEach(System.out::println);
            reviewList.forEach(u -> System.out.println(u.toString()));

            /*
            Instructor dbInstructor = session.get(Instructor.class, 2);
            System.out.println("\nCourses of specific instructor: " + dbInstructor.getCourses());
             //*/


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
