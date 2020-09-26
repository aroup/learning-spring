package com.turing.hibernate.demo;

import com.turing.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create a session

        try (Session session = factory.getCurrentSession(); factory) {

            // start a transaction
            session.beginTransaction();

            int courseId = 10;
            Course tempCourse = session.get(Course.class, courseId);
            System.out.println("Deleting course: " + tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
