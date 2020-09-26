package com.turing.hibernate.demo;

import com.turing.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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
            Course tempCourse = new Course("Pacman - How to score one million");
            System.out.println("Saving the course");
            session.save(tempCourse);
            System.out.println("Saving is complete" + tempCourse);

            /*
            - Create the students
            - add students to the course
            - save the students
             */

            Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
            Student tempStudent2 = new Student("Aroup", "Goldar", "aroupdhruba@gmail.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("Saving the student");

            session.save(tempStudent1);
            session.save(tempStudent2);

            System.out.println("Saved the students" + tempCourse.getStudents());


            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
