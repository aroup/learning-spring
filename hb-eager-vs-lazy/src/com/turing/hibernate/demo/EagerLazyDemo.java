package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Course;
import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            // create some courses
            // add courses to instructor
            // save the course

            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            // get the courses
            System.out.println("LOG: Instructor: " + tempInstructor);

            System.out.println("LOG: Courses:" + tempInstructor.getCourses());

            session.getTransaction().commit();
            System.out.println("LOG: We are closing the session");
            session.close();

            System.out.println("LOG: Courses:" + tempInstructor.getCourses());
            System.out.println("LOG: Done!");
        } finally {
            factory.close();
        }
    }
}
