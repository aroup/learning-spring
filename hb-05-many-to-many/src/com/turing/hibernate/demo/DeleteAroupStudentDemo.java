package com.turing.hibernate.demo;

import com.turing.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteAroupStudentDemo {
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

            // get the student Aroup From database
            // create more courses
            // add Aroup to those courses

            int studentId = 2;

            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("Loaded student " + tempStudent);
            System.out.println("Course: " + tempStudent.getCourses());

            System.out.println("deleting student");
            session.delete(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
