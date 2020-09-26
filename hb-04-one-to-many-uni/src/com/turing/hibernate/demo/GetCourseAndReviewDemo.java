package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Course;
import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import com.turing.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create a session

        try (Session session = factory.getCurrentSession(); factory) {

            // start a transaction
            session.beginTransaction();

            // get the course
            // print the course
            // print the course review

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
