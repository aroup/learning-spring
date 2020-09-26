package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Course;
import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create a session

        try (Session session = factory.getCurrentSession(); factory) {

            Instructor tempInstructor = new Instructor("Aroup1", "Goldar2", "aroupdhruba2@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/aroup3", "coding2");

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            // start a transaction
            session.beginTransaction();
            // save the student
            System.out.println("Saving the instructor...");
            session.save(tempInstructor);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
