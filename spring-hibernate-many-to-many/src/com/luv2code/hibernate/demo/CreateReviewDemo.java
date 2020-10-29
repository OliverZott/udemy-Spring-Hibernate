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

        //noinspection TryFinallyCanBeTryWithResources
        try {
            session.beginTransaction();


            //Instructor tempInstructor = new Instructor("Olli", "Zott", "olli@velosaurus.org");
            Course tempCourse = new Course("Alpine-Expert");
            Review tempReview = new Review("This Alpine-expert course is awesome as HELL!");

            //tempInstructor.addCourse(tempCourse);

            tempCourse.addReview(tempReview);
            tempCourse.addReview(new Review("Nice alpine bike experience."));
            tempCourse.addReview(new Review("Shitload of fun!!!"));

            // Due to Cascading in course-entity also reviews will be stored!
            session.save(tempCourse);

            // session.save(tempInstructor);
            // session.save(tempReview);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

}
