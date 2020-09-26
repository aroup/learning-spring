package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Course;
import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import com.turing.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
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

            // create a course
            // add some reviews
            // save the course - leverage the cascade all
            Course tempCourse = new Course("Pacman - How to score one million");

            tempCourse.addReview(new Review("Great course ... loved it"));
            tempCourse.addReview(new Review("Great course ... liked it"));
            tempCourse.addReview(new Review("Very great course!"));

            System.out.println("Saving the course");
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
