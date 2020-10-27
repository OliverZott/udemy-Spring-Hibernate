package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviewDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //Instructor tempInstructor = new Instructor("Olli", "Zott", "olli@velosaurus.org");
            Course tempCourse = new Course("BikePark-Advanced");
            Review tempReview = new Review("This course is awesome as well!");

            //tempInstructor.addCourse(tempCourse);
            tempCourse.addReview(tempReview);

            //Instructor dbInstructor = session.get(Instructor.class, 1);
            //dbInstructor.addCourse(tempCourse);


            System.out.println("\nCreating Course [" + tempCourse + "] and Creating Review: " + tempReview);
            //session.save(tempInstructor);
            session.save(tempCourse);
            //session.save(tempCourse2);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
