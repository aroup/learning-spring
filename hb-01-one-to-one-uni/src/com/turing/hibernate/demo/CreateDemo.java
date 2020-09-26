package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import com.turing.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try (factory) {
            // create a student object
            /*
            Instructor tempInstructor = new Instructor("Aroup","Goldar","aroupdhruba@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/aroup","coding");
            */

            Instructor tempInstructor = new Instructor("Aroup","Goldar2","aroupdhruba2@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/aroup2","coding2");

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
