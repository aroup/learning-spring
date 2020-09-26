package com.turing.hibernate.demo;

import com.turing.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForAroupDemo {
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

            Course tempCourse1 = new Course("Rubiks cube - how to speed cube");
            Course tempCourse2 = new Course("Game Development");

            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            System.out.println("Saving the courses");
            session.save(tempCourse1);
            session.save(tempCourse2);


            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}